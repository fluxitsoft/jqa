/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.bce.bcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.management.IntrospectionException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sourceforge.pmd.ast.ASTAllocationExpression;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceBody;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTCompilationUnit;
import net.sourceforge.pmd.ast.ASTImportDeclaration;
import net.sourceforge.pmd.ast.ASTName;
import net.sourceforge.pmd.ast.ASTNameList;
import net.sourceforge.pmd.ast.ASTPackageDeclaration;
import net.sourceforge.pmd.ast.ASTThrowStatement;
import net.sourceforge.pmd.ast.CharStream;
import net.sourceforge.pmd.ast.JavaCharStream;
import net.sourceforge.pmd.ast.JavaParser;
import net.sourceforge.pmd.ast.Node;
import net.sourceforge.pmd.ast.SimpleNode;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.ConstantCP;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.DescendingVisitor;
import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.ExceptionTable;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Signature;
import org.apache.bcel.classfile.Visitor;
import org.apache.bcel.generic.ATHROW;
import org.apache.bcel.generic.CPInstruction;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InvokeInstruction;
import org.jaxen.JaxenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fluxit.jqa.bce.BCERepository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.bce.TypeFormatException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BCERepositoryImpl implements BCERepository {

	private static Logger LOGGER = LoggerFactory.getLogger(BCERepositoryImpl.class);
	private String javaVersion;
	private final CacheManager cacheManager;

	// FIXME replace tokens Class for Type (type is generic)
	public BCERepositoryImpl() {
		this.cacheManager = CacheManager.newInstance(getClass().getResourceAsStream("/ehcache.xml"));
	}

	@Override
	public Collection<Integer> getAllocationLineNumbers(Type type, Type allocatedType, File sourcesDir) {
		Collection<Integer> result = new HashSet<Integer>();
		final ASTCompilationUnit compilationUnit = getCompilationUnit(type, sourcesDir);
		int anonymousTypeCount = 0;
		List<ASTAllocationExpression> allocations = compilationUnit.findChildrenOfType(ASTAllocationExpression.class);
		for (ASTAllocationExpression allocation : allocations) {
			// Omit inner classes allocations
			if (type.getShortName().equals(getParentTypeDeclarationImage(allocation))) {
				if (allocation.containsChildOfType(ASTClassOrInterfaceBody.class)) {
					// Is an anonymous an type
					anonymousTypeCount++;
					if (allocatedType.isAnonymous() && allocatedType.getShortName().equals(String.valueOf(anonymousTypeCount))) {
						result.add(allocation.getBeginLine());
					}
				} else {
					// Is named type allocation
					ASTClassOrInterfaceType classOrInterface = allocation.getFirstChildOfType(ASTClassOrInterfaceType.class);
					if (match(classOrInterface.getImage(), allocatedType, compilationUnit)) {
						result.add(classOrInterface.getBeginLine());
					}
				}
			}
		}
		return result;
	}

	@Override
	public Collection<Type> getAllocations(final Type type) {
		// TODO cache
		final Collection<Type> result = new HashSet<Type>();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				final ConstantPool constantPool = getWrappedClass(type).getConstantPool();
				iterateInstructions(code, type, new org.apache.bcel.generic.EmptyVisitor() {

					@Override
					public void visitNEW(org.apache.bcel.generic.NEW obj) {
						ConstantPoolGen cpg = new ConstantPoolGen(constantPool);
						result.add(BcelJavaType.create(obj.getType(cpg)));
					};

					@Override
					public void visitNEWARRAY(org.apache.bcel.generic.NEWARRAY obj) {
						result.add(BcelJavaType.create(obj.getType()));
					};

				});
			}
		};
		new DescendingVisitor(getWrappedClass(type), visitor).visit();
		// Visit anonymous types
		Collection<Type> anonymousAllocations = new ArrayList<Type>();
		for (Type allocationType : result) {
			if (allocationType.isAnonymous()) {
				anonymousAllocations.addAll(getAllocations(allocationType));
			}
		}
		result.addAll(anonymousAllocations);
		return result;
	}

	private CacheManager getCacheManager() {
		return this.cacheManager;
	}

	private ASTCompilationUnit getCompilationUnit(Type type, File sourcesDir) {
		final Cache cache = getCacheManager().getCache("COMPILATION_UNIT");
		Element result = cache.get(type.getName());
		if (result == null) {
			final CharStream stream = new JavaCharStream(getSourceFile(type, sourcesDir));
			final JavaParser javaParser = new JavaParser(stream);
			if ("1.5".equals(this.javaVersion) || "1.6".equals(this.javaVersion)) {
				javaParser.setJDK15();
			}
			final ASTCompilationUnit compilationUnit = javaParser.CompilationUnit();
			result = new Element(type.getName(), compilationUnit);
			cache.put(result);
		}
		return (ASTCompilationUnit) result.getObjectValue();
	}

	@Override
	public Integer getDeclarationLineNumber(Type type, File sourcesDir) {
		// TODO cache
		final ASTCompilationUnit compilationUnit = getCompilationUnit(type, sourcesDir);
		try {
			if (type.isAnonymous()) {
				String parentName = getParentImage(type);
				int anonymousTypeCount = 0;
				@SuppressWarnings("unchecked")
				List<SimpleNode> anonymousDeclarations = compilationUnit
						.findChildNodesWithXPath("//AllocationExpression[ClassOrInterfaceBody]/ClassOrInterfaceType");
				for (SimpleNode anonymousDeclaration : anonymousDeclarations) {
					// Avoid other scope classes
					if (parentName.equals(getParentTypeDeclarationImage(anonymousDeclaration))) {
						anonymousTypeCount++;
						if (type.getShortName().equals(String.valueOf(anonymousTypeCount))) {
							return anonymousDeclaration.getBeginLine();
						}
					}
				}
			} else {
				@SuppressWarnings("unchecked")
				List<SimpleNode> declarations = compilationUnit.findChildNodesWithXPath("//ClassOrInterfaceDeclaration[@Image='" + type.getShortName() + "']");
				if (declarations.isEmpty()) {
					throw new IllegalArgumentException("Can not find declaration line number of type: " + type);
				} else if (declarations.size() > 1) {
					LOGGER.warn("Multiple declaration line numbers found for the type: " + type);
				}
				return declarations.get(0).getBeginLine();
			}
		} catch (JaxenException e) {
			throw new IllegalArgumentException("Error occured while looking for declaration line number of type: " + type, e);
		}
		throw new IllegalArgumentException("Can not find declaration line number of type: " + type);
	}

	private Type getException(ConstantPool constantPool, CPInstruction instruction) {
		ConstantCP constantRef = (ConstantCP) constantPool.getConstant(instruction.getIndex());
		String typeName = constantPool.getConstantString(constantRef.getClassIndex(), Constants.CONSTANT_Class);
		return BcelJavaType.create(typeName);
	}

	@SuppressWarnings("unchecked")
	private Iterator<InstructionHandle> getInstructionListIterator(Code code) {
		InstructionList instructionList = new InstructionList(code.getCode());
		return instructionList.iterator();
	}

	@Override
	public Collection<Type> getInterfaces(Type type) {
		try {
			org.apache.bcel.classfile.JavaClass[] interfaces;
			interfaces = org.apache.bcel.Repository.getInterfaces(getWrappedClass(type));
			final List<Type> result = new ArrayList<Type>(interfaces.length);
			for (final org.apache.bcel.classfile.JavaClass interfaz : interfaces) {
				result.add(BcelJavaType.create(interfaz));
			}
			return result;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private String getPackage(ASTCompilationUnit compilationUnit) {
		ASTPackageDeclaration packageDeclaration = compilationUnit.getFirstChildOfType(ASTPackageDeclaration.class);
		return packageDeclaration.getFirstChildOfType(ASTName.class).getImage();
	}

	private String getParentImage(Type anonymousType) {
		if (!anonymousType.isAnonymous()) {
			throw new IllegalArgumentException("Type must be anonymous");
		}
		String name = anonymousType.getName();
		name = name.substring(name.lastIndexOf(".") + 1);
		name = name.substring(0, name.lastIndexOf("$"));
		if (name.contains("$")) {
			// The parent is an inner class
			name = name.substring(name.lastIndexOf("$") + 1);
		}
		return name;
	}

	private String getParentTypeDeclarationImage(Node node) {
		Node parent = node.jjtGetParent();
		while (parent != null) {
			if (parent instanceof ASTClassOrInterfaceDeclaration) {
				return ((ASTClassOrInterfaceDeclaration) parent).getImage();
			} else {
				parent = parent.jjtGetParent();
			}
		}
		return null;
	}

	public InputStream getSourceFile(Type type, File sourceDir) {
		String sourceFile = sourceDir + "/" + type.getName().replace(".", "/");
		if (sourceFile.contains("$")) {
			sourceFile = sourceFile.substring(0, sourceFile.indexOf('$'));
		}
		try {
			return new FileInputStream(sourceFile + ".java");
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Invalid sources directory [" + sourceFile + "]", e);
		}
	}

	@Override
	public Collection<Type> getSuperClasses(Type type) {
		org.apache.bcel.classfile.JavaClass[] superClasses;
		try {
			superClasses = org.apache.bcel.Repository.getSuperClasses(getWrappedClass(type));
			final List<Type> result = new ArrayList<Type>(superClasses.length);
			for (final org.apache.bcel.classfile.JavaClass superClass : superClasses) {
				result.add(BcelJavaType.create(superClass));
			}
			return result;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public Collection<? extends Integer> getThrowLineNumbers(Type type, Type throwedType, File sourcesDir) {
		Collection<Integer> result = new HashSet<Integer>();
		final ASTCompilationUnit compilationUnit = getCompilationUnit(type, sourcesDir);
		for (ASTNameList nameList : compilationUnit.findChildrenOfType(ASTNameList.class)) {
			for (ASTName name : nameList.findChildrenOfType(ASTName.class)) {
				if (match(name.getImage(), throwedType, compilationUnit)) {
					result.add(nameList.getBeginLine());
				}
			}
		}
		for (ASTThrowStatement throwStatement : compilationUnit.findChildrenOfType(ASTThrowStatement.class)) {
			for (ASTClassOrInterfaceType classOrInterface : throwStatement.findChildrenOfType(ASTClassOrInterfaceType.class)) {
				if (match(classOrInterface.getImage(), throwedType, compilationUnit)) {
					result.add(throwStatement.getBeginLine());
				}
			}
		}
		return result;
	}

	@Override
	public Collection<Type> getThrows(final Type type) {
		final Collection<Type> result = new HashSet<Type>();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				final ConstantPool constantPool = code.getConstantPool();
				Iterator<InstructionHandle> iterator = getInstructionListIterator(code);
				Instruction last = null;
				while (iterator.hasNext()) {
					Instruction current = iterator.next().getInstruction();
					if (current instanceof ATHROW) {
						if (last instanceof CPInstruction) {
							result.add(getException(constantPool, (CPInstruction) last));
						}
					}
					last = current;
				}
			}

			@Override
			public void visitMethod(Method obj) {
				final ExceptionTable exceptionTable = obj.getExceptionTable();
				if (exceptionTable != null) {
					for (String type : exceptionTable.getExceptionNames()) {
						result.add(BcelJavaType.create(type));
					}
				}
			}

		};
		new DescendingVisitor(getWrappedClass(type), visitor).visit();
		return result;
	}

	@Override
	public Collection<? extends Integer> getUseLineNumbers(Type type, Type usedType, File sourcesDir) {
		Collection<Integer> result = new HashSet<Integer>();
		final ASTCompilationUnit compilationUnit = getCompilationUnit(type, sourcesDir);
		for (ASTImportDeclaration importDeclaration : compilationUnit.findChildrenOfType(ASTImportDeclaration.class)) {
			for (ASTName name : importDeclaration.findChildrenOfType(ASTName.class)) {
				if (match(name.getImage(), usedType, compilationUnit)) {
					result.add(importDeclaration.getBeginLine());
				}
			}
		}
		if (result.isEmpty()) {
			result.add(getDeclarationLineNumber(type, sourcesDir));
		}
		return result;
	}

	@Override
	public Collection<Type> getUses(final Type type) {
		// TODO cache
		final Collection<Type> uses = new HashSet<Type>();
		final ConstantPool constantPool = getWrappedClass(type).getConstantPool();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				iterateInstructions(code, type, new org.apache.bcel.generic.EmptyVisitor() {

					@Override
					public void visitInvokeInstruction(InvokeInstruction obj) {
						ConstantPoolGen cpg = new ConstantPoolGen(constantPool);
						uses.add(BcelJavaType.create(obj.getReferenceType(cpg)));
					};

					@Override
					public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {
						ConstantPoolGen cpg = new ConstantPoolGen(constantPool);
						org.apache.bcel.generic.Type returnType = obj.getReturnType(cpg);
						BcelJavaType type = BcelJavaType.create(returnType);
						if (type != null) {
							uses.add(type);
						}
					}

				});
			}

			@Override
			public void visitField(Field field) {
				final org.apache.bcel.generic.Type type = org.apache.bcel.generic.Type.getType(field.getSignature());
				uses.add(BcelJavaType.create(type));
			}

			@Override
			public void visitJavaClass(JavaClass obj) {
				for (String type : obj.getInterfaceNames()) {
					uses.add(BcelJavaType.create(type));
				}
				uses.add(BcelJavaType.create(obj.getSuperclassName()));
			}

			@Override
			public void visitMethod(Method method) {
				final List<String> classNames = ClassNameTranslator.signatureToClassNames(method.getSignature());
				for (final String className : classNames) {
					BcelJavaType create = BcelJavaType.create(className);
					if (create != null) {
						uses.add(create);
					}
				}
				final ExceptionTable exceptionTable = method.getExceptionTable();
				if (exceptionTable != null) {
					for (final String exceptionClassName : exceptionTable.getExceptionNames()) {
						uses.add(BcelJavaType.create(exceptionClassName));
					}
				}
			}

			@Override
			public void visitSignature(Signature obj) {
				final ConstantUtf8 constantString = (ConstantUtf8) constantPool.getConstant(obj.getSignatureIndex());
				String signature = constantString.getBytes();
				for (String type : ClassNameTranslator.signatureToClassNames2(signature)) {
					uses.add(BcelJavaType.create(type));
				}
			}

		};
		new DescendingVisitor(getWrappedClass(type), visitor).visit();
		Collection<Type> result = new HashSet<Type>(uses);
		// Removes the target type and its inner classes
		result.remove(type);
		for (Iterator<Type> iterator = result.iterator(); iterator.hasNext();) {
			Type type2 = iterator.next();
			if (type2.getName().contains("$")) {
				iterator.remove();
			}
		}
		return result;
	}

	private org.apache.bcel.classfile.JavaClass getWrappedClass(Type type) {
		return ((BcelJavaType) type).getWrapped();
	}

	boolean hasImport(ASTCompilationUnit compilationUnit, Type type) {
		if (type.getPackage().equals("java.lang") || type.getPackage().equals(getPackage(compilationUnit))) {
			// The java.lang package is imported by default
			// The classes on the same package are not imported
			return true;
		} else {
			for (ASTImportDeclaration importDeclaration : compilationUnit.findChildrenOfType(ASTImportDeclaration.class)) {
				String importTypeName = importDeclaration.getFirstChildOfType(ASTName.class).getImage();
				if (importTypeName.equals(type.getName())) {
					return true;
				}
			}
			return false;
		}
	}

	private void iterateInstructions(Code code, Type type, org.apache.bcel.generic.Visitor visitor) {
		Iterator<InstructionHandle> iterator = getInstructionListIterator(code);
		while (iterator.hasNext()) {
			final Instruction instruction = iterator.next().getInstruction();
			instruction.accept(visitor);
		}
	}

	@Override
	public Type lookupType(Class<?> clazz) throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository.lookupClass(clazz);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Class not found: " + clazz.getName());
		} else {
			return BcelJavaType.create(lookupClass);
		}
	}

	@Override
	public Type lookupType(String typeName) throws ClassNotFoundException {
		// TODO cache
		return BcelJavaType.create(typeName);
	}

	// TODO improve method name
	private boolean match(String image, Type type, ASTCompilationUnit compilationUnit) {
		if (image.equals(type.getName())) {
			// Explicit reference
			return true;
		} else if (image.equals(type.getShortName()) && hasImport(compilationUnit, type)) {
			// Implicit reference, via import
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Type parse(FileInputStream classFile, String typeName) throws TypeFormatException, IOException {
		try {
			return BcelJavaType.create(new ClassParser(classFile, typeName).parse());
		} catch (final org.apache.bcel.classfile.ClassFormatException e) {
			throw new TypeFormatException(e);
		}
	}

	@Override
	public void setClassPath(Collection<File> classPathFiles) throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		ClassPathLoader.INSTANCE.setClassPath(classPathFiles);
	}

	@Override
	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

}