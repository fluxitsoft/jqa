/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.bce.bcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sourceforge.pmd.lang.ast.CharStream;
import net.sourceforge.pmd.lang.ast.JavaCharStream;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTAllocationExpression;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceBody;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTCompilationUnit;
import net.sourceforge.pmd.lang.java.ast.ASTEnumDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTImportDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTName;
import net.sourceforge.pmd.lang.java.ast.ASTPackageDeclaration;
import net.sourceforge.pmd.lang.java.ast.JavaParser;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.CodeException;
import org.apache.bcel.classfile.ConstantCP;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.DescendingVisitor;
import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.ExceptionTable;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LineNumberTable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Signature;
import org.apache.bcel.classfile.Visitor;
import org.apache.bcel.generic.ATHROW;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.CPInstruction;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.FieldOrMethod;
import org.apache.bcel.generic.GETSTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InvokeInstruction;
import org.apache.bcel.generic.LocalVariableInstruction;
import org.apache.commons.lang.StringUtils;
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

	private static Logger LOGGER = LoggerFactory
			.getLogger(BCERepositoryImpl.class);

	private final String javaVersion;
	private final CacheManager cacheManager;
	private final File[] sourcesDirs;

	// FIXME replace tokens "Class" to "Type" ("Type" is generic)
	public BCERepositoryImpl(Collection<File> classPathFiles,
			String javaVersion, File[] sourcesDirs) {
		ClassPathLoader.INSTANCE.setClassPath(classPathFiles);
		this.javaVersion = javaVersion;
		this.sourcesDirs = sourcesDirs;
		this.cacheManager = CacheManager.newInstance(getClass()
				.getResourceAsStream("/ehcache.xml"));
	}

	private void addToResult(int sourceLine, Type type,
			Map<Type, Collection<Integer>> result) {
		Collection<Integer> collection = result.get(type);
		if (collection == null) {
			collection = new HashSet<Integer>();
		}
		collection.add(sourceLine);
		result.put(type, collection);
	}

	private Node doGetTypeNode(Node node, String typeShortName) {
		if (typeShortName.contains("$")) {
			// Is inner type
			String currentTypeName = typeShortName.substring(0,
					typeShortName.indexOf("$"));
			String nextTypeName = typeShortName.substring(typeShortName
					.indexOf("$") + 1);
			Node declaration = findFirstLevelTypeDeclarationNode(node,
					currentTypeName);
			return doGetTypeNode(declaration, nextTypeName);
		} else {
			return findFirstLevelTypeDeclarationNode(node, typeShortName);
		}
	}

	private List<? extends Node> findChildNodesWithXPath(Type parentType,
			String xpathString) {
		Node typeNode = getTypeNode(parentType);
		try {
			List<? extends Node> result = typeNode
					.findChildNodesWithXPath(xpathString);
			for (Iterator<? extends Node> iterator = result.iterator(); iterator
					.hasNext();) {
				Node simpleNode = iterator.next();
				ASTClassOrInterfaceDeclaration firstParentOfType = simpleNode
						.getFirstParentOfType(ASTClassOrInterfaceDeclaration.class);
				if (firstParentOfType != null && firstParentOfType != typeNode) {
					iterator.remove();
				}
			}
			return result;
		} catch (JaxenException e) {
			throw new IllegalArgumentException(
					"Error while looking for child of " + parentType.getName()
							+ " with xpath " + xpathString, e);
		}
	}

	private Node findFirstLevelAnonymousTypeDeclarationNode(Node parentNode,
			String namedTypeShortName) {
		List<Node> declarations = findFirstLevelAnonymousTypeDeclarationNodes(
				parentNode, namedTypeShortName);
		return declarations.get(Integer.valueOf(namedTypeShortName) - 1);
	}

	private List<Node> findFirstLevelAnonymousTypeDeclarationNodes(
			Node parentNode, String namedTypeShortName) {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < parentNode.jjtGetNumChildren(); i++) {
			Node children = parentNode.jjtGetChild(i);
			if (!(children instanceof ASTClassOrInterfaceDeclaration || children instanceof ASTEnumDeclaration)) {
				if (children instanceof ASTAllocationExpression
						&& !children.findChildrenOfType(
								ASTClassOrInterfaceBody.class).isEmpty()) {
					// Is an anonymous type
					result.add(children);
				}
				result.addAll(findFirstLevelAnonymousTypeDeclarationNodes(
						children, namedTypeShortName));
			}
		}
		return result;
	}

	private Node findFirstLevelNamedTypeDeclarationNode(Node parentNode,
			String namedTypeShortName) {
		List<Node> declarations = findFirstLevelNamedTypeDeclarationNodes(
				parentNode, namedTypeShortName);
		if (declarations.isEmpty()) {
			throw new IllegalArgumentException(
					"Can not find declaration line number of type: "
							+ namedTypeShortName);
		} else if (declarations.size() > 1) {
			LOGGER.warn("Multiple declaration line numbers found for the type: "
					+ namedTypeShortName);
		}
		return declarations.get(0);
	}

	private List<Node> findFirstLevelNamedTypeDeclarationNodes(Node parentNode,
			String namedTypeShortName) {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < parentNode.jjtGetNumChildren(); i++) {
			Node children = parentNode.jjtGetChild(i);
			if (children instanceof ASTClassOrInterfaceDeclaration
					|| children instanceof ASTEnumDeclaration) {
				if (children.getImage().equals(namedTypeShortName)) {
					result.add(children);
				}
			} else {
				result.addAll(findFirstLevelNamedTypeDeclarationNodes(children,
						namedTypeShortName));
			}
		}
		return result;
	}

	private Node findFirstLevelTypeDeclarationNode(Node node,
			String typeShortName) {
		if (isAnonymous(typeShortName)) {
			return findFirstLevelAnonymousTypeDeclarationNode(node,
					typeShortName);
		} else {
			return findFirstLevelNamedTypeDeclarationNode(node, typeShortName);
		}
	}

	@Override
	public Map<Type, Collection<Integer>> getAllocations(final Type type) {
		// TODO cache
		final Map<Type, Collection<Integer>> result = new HashMap<Type, Collection<Integer>>();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(final Code code) {
				final ConstantPool constantPool = getWrappedType(type)
						.getConstantPool();
				final Map<Instruction, Integer> instructionOffset = new HashMap<Instruction, Integer>();
				iterateInstructions(code, type, instructionOffset,
						new org.apache.bcel.generic.EmptyVisitor() {

							@Override
							public void visitNEW(org.apache.bcel.generic.NEW obj) {
								final int sourceLine = getSourceLineNumber(
										code, instructionOffset.get(obj));
								ConstantPoolGen cpg = new ConstantPoolGen(
										constantPool);
								addToResult(sourceLine,
										BcelJavaType.create(obj.getType(cpg)),
										result);
							};

							@Override
							public void visitNEWARRAY(
									org.apache.bcel.generic.NEWARRAY obj) {
								final int sourceLine = getSourceLineNumber(
										code, instructionOffset.get(obj));
								addToResult(sourceLine,
										BcelJavaType.create(obj.getType()),
										result);
							};

						});
			}
		};
		new DescendingVisitor(getWrappedType(type), visitor).visit();
		// FIXME remove the bellow code?
		// Prevent concurrent modification
		Map<Type, Collection<Integer>> anonymousAllocations = new HashMap<Type, Collection<Integer>>();
		for (Type allocationType : result.keySet()) {
			// Visit anonymous types
			if (allocationType.isAnonymous()) {
				anonymousAllocations.putAll(getAllocations(allocationType));
			}
		}
		result.putAll(anonymousAllocations);
		return result;
	}

	private CacheManager getCacheManager() {
		return this.cacheManager;
	}

	private ASTCompilationUnit getCompilationUnit(Type type) {
		final Cache cache = getCacheManager().getCache("COMPILATION_UNIT");
		Element result = cache.get(type.hashCode());
		if (result == null) {
			InputStream sourceFile = null;
			try {
				sourceFile = getSourceFile(type);
				final CharStream stream = new JavaCharStream(sourceFile);
				final JavaParser javaParser = new JavaParser(stream);
				javaParser.setJdkVersion(Integer.valueOf(javaVersion
						.substring(javaVersion.indexOf('.') + 1)));
				final ASTCompilationUnit compilationUnit = javaParser
						.CompilationUnit();
				result = new Element(type.hashCode(), compilationUnit);
				cache.put(result);
			} finally {
				if (sourceFile != null) {
					try {
						sourceFile.close();
					} catch (IOException e) {
						LOGGER.error("Can not close source file input stream",
								e);
					}
				}
			}
		}
		return (ASTCompilationUnit) result.getObjectValue();
	}

	@Override
	public Integer getDeclarationLineNumber(Type type) {
		Node typeNode = getTypeNode(type);
		return typeNode.getBeginLine();
	}

	private Type getException(ConstantPool constantPool,
			CPInstruction instruction) {
		ConstantCP constantRef = (ConstantCP) constantPool
				.getConstant(instruction.getIndex());
		String typeName = constantPool.getConstantString(
				constantRef.getClassIndex(), Constants.CONSTANT_Class);
		return BcelJavaType.create(typeName);
	}

	protected Integer getFieldSourceLine(String fieldName, Type parentType) {
		String shortName = parentType.getShortName();
		if (shortName.contains("$")) {
			shortName = shortName.substring(shortName.lastIndexOf('$') + 1);
		}
		String xpathString = String
				.format("//ClassOrInterfaceDeclaration[@Image='%s']/ClassOrInterfaceBody/ClassOrInterfaceBodyDeclaration/FieldDeclaration/VariableDeclarator/VariableDeclaratorId[@Image='%s'] | //EnumDeclaration[@Image='%s']/EnumBody/EnumConstant[@Image='%s'] | //EnumDeclaration[@Image='%s']/EnumBody/ClassOrInterfaceBodyDeclaration/FieldDeclaration/VariableDeclarator/VariableDeclaratorId[@Image='%s']",
						shortName, fieldName, shortName, fieldName, shortName,
						fieldName);
		List<? extends Node> fieldTypeNodes = findChildNodesWithXPath(
				parentType, xpathString);
		if (fieldTypeNodes.isEmpty()) {
			throw new IllegalArgumentException("Field not found: " + fieldName
					+ " on type: " + parentType.getName());
		} else if (fieldTypeNodes.size() > 1) {
			throw new IllegalArgumentException("Multiple fields found for: "
					+ fieldName + " on type: " + parentType.getName());
		} else {
			return fieldTypeNodes.get(0).getBeginLine();
		}

	}

	private int getFirstFieldOrMethodInstructionSourceLine(Code code) {
		final InstructionList instructionList = new InstructionList(
				code.getCode());
		for (int i = 0; i < instructionList.size(); i++) {
			Instruction instruction = instructionList.getInstructions()[i];
			if (instruction instanceof FieldOrMethod) {
				int offset = instructionList.getInstructionPositions()[i];
				return getSourceLineNumber(code, offset);
			}
		}
		throw new IllegalArgumentException(
				"FieldOrMethodInstruction instruction not found at :" + code);
	}

	@Override
	public Collection<Type> getInterfaces(Type type) {
		try {
			org.apache.bcel.classfile.JavaClass[] interfaces;
			interfaces = org.apache.bcel.Repository
					.getInterfaces(getWrappedType(type));
			final List<Type> result = new ArrayList<Type>(interfaces.length);
			for (final org.apache.bcel.classfile.JavaClass interfaz : interfaces) {
				result.add(BcelJavaType.create(interfaz));
			}
			return result;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private int getMethodSourceLine(final Method method, Type parentType) {
		Code code = method.getCode();
		if (isConstructor(method)) {
			// Constructors
			return getFirstFieldOrMethodInstructionSourceLine(code);
		} else {
			// Non constructors
			String xpathString = "//MethodDeclarator[@Image='"
					+ method.getName() + "']";
			List<? extends Node> fieldTypeNodes = findChildNodesWithXPath(
					parentType, xpathString);
			if (fieldTypeNodes.size() == 1) {
				return fieldTypeNodes.get(0).getBeginLine();
			} else {
				// There is more than one method with the same name
				xpathString += "[count(.//FormalParameter) = "
						+ method.getArgumentTypes().length + "]";
				fieldTypeNodes = findChildNodesWithXPath(parentType,
						xpathString);
				if (fieldTypeNodes.size() == 1) {
					return fieldTypeNodes.get(0).getBeginLine();
				} else {
					// There is more than one method with the same name and
					// parameters size
					xpathString += getParameterPaths(method, parentType);
					fieldTypeNodes = findChildNodesWithXPath(parentType,
							xpathString);
					if (fieldTypeNodes.size() == 1) {
						return fieldTypeNodes.get(0).getBeginLine();
					} else if (fieldTypeNodes.size() > 1) {
						throw new IllegalArgumentException(
								"More than one method found for: "
										+ method.getName() + " at type: "
										+ parentType.getName());
					} else {
						if (xpathString
								.equals("//ConstructorDeclaration[count(FormalParameters/FormalParameter) = 0]")) {
							// Implicit constructor
							return getDeclarationLineNumber(parentType);
						} else {
							LOGGER.error("Source line not found for method: "
									+ method.getName() + " (" + method
									+ ") at type: " + parentType.getName());
							return 1;
						}
					}
				}
			}
		}
	}

	private String getPackage(ASTCompilationUnit compilationUnit) {
		ASTPackageDeclaration packageDeclaration = compilationUnit
				.getFirstChildOfType(ASTPackageDeclaration.class);
		return packageDeclaration.getFirstChildOfType(ASTName.class).getImage();
	}

	protected String getParameterPath(int i, Type argumentType, boolean array) {
		String result;
		String arrayStr = array ? "[@Array='true' or ancestor::FormalParameter[1][@Varargs='true']]"
				: "[@Array='false']";
		if (TypeNameTranslator.isPrimitive(argumentType)) {
			result = String
					.format("[.//FormalParameter[%d]%s/Type[.//PrimitiveType[@Image='%s']]]",
							i, arrayStr, argumentType.getShortName());
		} else {
			result = String
					.format("[.//FormalParameter[%d]/Type[./ReferenceType%s/*[@Image='%s' or @Image='%s']]]",
							i, arrayStr, argumentType.getShortName(),
							argumentType.getName());
		}
		return result;
	}

	private String getParameterPaths(Method method, Type parentType) {
		String result = "";
		Signature methodSignature = getSignature(method);
		if (methodSignature == null) {
			// Method without generics
			int i = 1;
			for (org.apache.bcel.generic.Type argumentType : method
					.getArgumentTypes()) {
				result += getParameterPath(i,
						BcelJavaType.create(argumentType),
						argumentType instanceof ArrayType);
				i++;
			}
		} else {
			// Method with generics
			String paramsSignature = methodSignature.getSignature();
			int beginIndex = paramsSignature.indexOf("(") + 1;
			int endIndex = paramsSignature.indexOf(")");
			paramsSignature = paramsSignature.substring(beginIndex, endIndex);
			if (!paramsSignature.isEmpty()) {
				result += getParameterPaths(method, parentType, paramsSignature);
			}
		}
		return result;
	}

	protected String getParameterPaths(Method method, Type parentType,
			String paramsSignature) {
		String result = "";
		// TODO improve
		String temp;
		while (paramsSignature != (temp = paramsSignature.replaceAll(
				"<[^>|<]*>", ""))) {
			paramsSignature = temp;
		}
		String[] paramsSignatureSplit = paramsSignature.split(";");
		int i = 1;
		for (String paramSignature : paramsSignatureSplit) {
			boolean array;
			if (paramSignature.startsWith("[")) {
				array = true;
				paramSignature = paramSignature.substring(1);
			} else {
				array = false;
			}
			if (paramSignature.startsWith("T")) {
				result += String
						.format("[.//FormalParameter[%d]/Type[./ReferenceType/*[@Image='%s']]]",
								i, paramSignature.substring(1));
			} else if (paramSignature.startsWith("L")) {
				BcelJavaType argumentType = BcelJavaType.create(paramSignature
						.substring(1));
				result += getParameterPath(i, argumentType, array);
			} else if (paramSignature.startsWith("ZL")) {
				BcelJavaType argumentType = BcelJavaType.create(paramSignature
						.substring(2));
				result += getParameterPath(i, argumentType, array);
			} else if (!(paramSignature.length() == 1 && StringUtils
					.isAllUpperCase(paramSignature))) {
				throw new IllegalStateException("Unssuported param signature "
						+ paramSignature + " of method " + method + " on type"
						+ parentType.getName());
			}
			i++;
		}
		return result;
	}

	private Signature getSignature(
			org.apache.bcel.classfile.FieldOrMethod fieldOrMethod) {
		for (Attribute attribute : fieldOrMethod.getAttributes()) {
			if (attribute instanceof Signature) {
				return (Signature) attribute;
			}
		}
		return null;
	}

	@Override
	public File getSourceFile(String typeName, File[] sourceDirs)
			throws FileNotFoundException {
		for (File sourceDir : sourceDirs) {
			String sourceFile = sourceDir.getPath() + File.separatorChar
					+ typeName.replace('.', File.separatorChar);
			if (sourceFile.contains("$")) {
				sourceFile = sourceFile.substring(0, sourceFile.indexOf('$'));
			}
			sourceFile += ".java";
			File result = new File(sourceFile);
			if (!result.exists()) {
				LOGGER.warn("Can not find the source code for type ["
						+ typeName + "] in [" + sourceDir + "]");
			} else {
				return result;
			}
		}
		throw new FileNotFoundException(
				"Can not find the source code for type [" + typeName + "]");
	}

	private InputStream getSourceFile(Type type) {
		return getSourceFile(type, this.sourcesDirs);
	}

	private InputStream getSourceFile(Type type, File[] sourcesDir2) {
		try {
			return new FileInputStream(getSourceFile(type.getName(),
					sourcesDir2));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(
					"Can not find the source code for type [" + type.getName()
							+ "]", e);
		}
	}

	private String getSourceLine(Type type, int sourceLine) {
		if (sourceLine < 1) {
			throw new IllegalArgumentException(
					"Line number must be greater than or equal to 1");
		}
		InputStream stream = null;
		try {
			stream = getSourceFile(type);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(stream));
			String line = null;
			for (int i = 0; i < sourceLine; i++) {
				line = br.readLine();
			}
			return line;
		} catch (IOException e) {
			throw new IllegalStateException(
					"An error occured while reading source file", e);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				LOGGER.error("Can not close source file input stream", e);
			}
		}
	}

	private int getSourceLineNumber(Code code, int offset) {
		final LineNumberTable lineNumberTable = code.getLineNumberTable();
		return lineNumberTable.getSourceLine(offset);
	}

	@Override
	public Collection<Type> getSuperClasses(Type type) {
		org.apache.bcel.classfile.JavaClass[] superClasses;
		try {
			superClasses = org.apache.bcel.Repository
					.getSuperClasses(getWrappedType(type));
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
	public Map<Type, Collection<Integer>> getThrows(final Type type) {
		final Map<Type, Collection<Integer>> result = new HashMap<Type, Collection<Integer>>();
		JavaClass wrappedType = getWrappedType(type);
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				InstructionList instructionList = new InstructionList(
						code.getCode());
				Instruction lastInstruction = null;
				int lastOffset = 0;
				for (int i = 0; i < instructionList.size(); i++) {
					Instruction currentInstruction = instructionList
							.getInstructions()[i];
					int currentOffset = instructionList
							.getInstructionPositions()[i];
					if (currentInstruction instanceof ATHROW) {
						if (lastInstruction instanceof CPInstruction) {
							final int sourceLine = getSourceLineNumber(code,
									lastOffset);
							addToResult(
									sourceLine,
									getException(code.getConstantPool(),
											(CPInstruction) lastInstruction),
									result);
						}
					}
					lastInstruction = currentInstruction;
					lastOffset = currentOffset;
				}
			}

			@Override
			public void visitMethod(Method obj) {
				// Skip generated fields
				if ((obj.getAccessFlags() & Constants.ACC_SYNTHETIC) == 0) {
					final ExceptionTable exceptionTable = obj
							.getExceptionTable();
					if (exceptionTable != null) {
						for (String exceptionName : exceptionTable
								.getExceptionNames()) {
							final int sourceLine = getMethodSourceLine(obj,
									type);
							addToResult(sourceLine,
									BcelJavaType.create(exceptionName), result);
						}
					}
				}
			}

		};
		new DescendingVisitor(wrappedType, visitor).visit();
		return result;
	}

	private Node getTypeNode(Type type) {
		// TODO cache
		final ASTCompilationUnit compilationUnit = getCompilationUnit(type);
		return doGetTypeNode(compilationUnit, type.getShortName());
	}

	@Override
	public Map<Type, Collection<Integer>> getUses(final Type type) {
		// TODO cache
		final Map<Type, Collection<Integer>> result = new HashMap<Type, Collection<Integer>>();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(final Code code) {
				final ConstantPool constantPool = code.getConstantPool();
				final Map<Instruction, Integer> instructionOffset = new HashMap<Instruction, Integer>();
				iterateInstructions(code, type, instructionOffset,
						new org.apache.bcel.generic.EmptyVisitor() {

							@Override
							public void visitGETSTATIC(GETSTATIC obj) {
								final int sourceLine = getSourceLineNumber(
										code, instructionOffset.get(obj));
								ConstantPoolGen cpg = new ConstantPoolGen(
										constantPool);
								addToResult(sourceLine, BcelJavaType.create(obj
										.getReferenceType(cpg)), result);
							}

							@Override
							public void visitInvokeInstruction(
									InvokeInstruction obj) {
								final int sourceLine = getSourceLineNumber(
										code, instructionOffset.get(obj));
								ConstantPoolGen cpg = new ConstantPoolGen(
										constantPool);
								addToResult(sourceLine, BcelJavaType.create(obj
										.getReferenceType(cpg)), result);
							}

							@Override
							public void visitINVOKEVIRTUAL(INVOKEVIRTUAL obj) {
								ConstantPoolGen cpg = new ConstantPoolGen(
										constantPool);
								org.apache.bcel.generic.Type returnType = obj
										.getReturnType(cpg);
								BcelJavaType type = BcelJavaType
										.create(returnType);
								if (type != null) {
									final int sourceLine = getSourceLineNumber(
											code, instructionOffset.get(obj));
									addToResult(sourceLine, type, result);
								}
							}

							@Override
							public void visitLocalVariableInstruction(
									LocalVariableInstruction obj) {
								ConstantPoolGen cpg = new ConstantPoolGen(
										constantPool);
								org.apache.bcel.generic.Type returnType = obj
										.getType(cpg);
								BcelJavaType type = BcelJavaType
										.create(returnType);
								if (type != null) {
									final int sourceLine = getSourceLineNumber(
											code, instructionOffset.get(obj));
									addToResult(sourceLine, type, result);
								}
							}

						});
				// Catchs blocks exceptions
				for (CodeException codeException : code.getExceptionTable()) {
					try {
						String typeName = constantPool.getConstantString(
								codeException.getCatchType(),
								Constants.CONSTANT_Class);
						final LineNumberTable lineNumberTable = code
								.getLineNumberTable();
						final int sourceLine = lineNumberTable
								.getSourceLine(codeException.getHandlerPC());
						addToResult(sourceLine, BcelJavaType.create(typeName),
								result);
					} catch (ClassFormatException e) {
						LOGGER.error("CodeException skipped " + codeException
								+ ": " + e.getMessage());
					}
				}
			}

			private void visitExceptionTable(ExceptionTable exceptionTable,
					int sourceLine) {
				for (String exceptionName : exceptionTable.getExceptionNames()) {
					addToResult(sourceLine, BcelJavaType.create(exceptionName),
							result);
				}
			}

			@Override
			public void visitField(Field field) {
				// Skip generated fields
				if ((field.getAccessFlags() & Constants.ACC_SYNTHETIC) == 0) {
					final Type fieldType = BcelJavaType
							.create(org.apache.bcel.generic.Type.getType(field
									.getSignature()));
					Integer sourceLine = getFieldSourceLine(field.getName(),
							type);
					addToResult(sourceLine, fieldType, result);
				}
			}

			@Override
			public void visitJavaClass(JavaClass obj) {
				final int sourceLine = getDeclarationLineNumber(BcelJavaType
						.create(obj));
				for (String type : obj.getInterfaceNames()) {
					addToResult(sourceLine, BcelJavaType.create(type), result);
				}
				addToResult(sourceLine,
						BcelJavaType.create(obj.getSuperclassName()), result);
				for (Attribute attribute : obj.getAttributes()) {
					if (attribute instanceof Signature) {
						visitSignature((Signature) attribute, sourceLine);
					}
				}
			}

			@Override
			public void visitMethod(Method method) {
				if ((method.getAccessFlags() & Constants.ACC_SYNTHETIC) == 0) {
					final int sourceLineNumber = getMethodSourceLine(method,
							type);
					String sourceLine = getSourceLine(type, sourceLineNumber);
					final List<String> typeNames = TypeNameTranslator
							.signatureToTypeNames(method.getSignature());
					for (final String typeName : typeNames) {
						BcelJavaType methodType = BcelJavaType.create(typeName);
						if (methodType != null
								&& sourceLine.contains(methodType
										.getShortName())) {
							addToResult(sourceLineNumber, methodType, result);
						}
					}
					for (Attribute attribute : method.getAttributes()) {
						if (attribute instanceof Signature) {
							visitSignature((Signature) attribute,
									sourceLineNumber);
						} else if (attribute instanceof ExceptionTable) {
							visitExceptionTable((ExceptionTable) attribute,
									sourceLineNumber);
						}
					}
				}
			}

			public void visitSignature(Signature obj, int sourceLine) {
				final ConstantUtf8 constantString = (ConstantUtf8) obj
						.getConstantPool().getConstant(obj.getSignatureIndex());
				String signature = constantString.getBytes();
				for (String type : TypeNameTranslator
						.signatureToTypeNames2(signature)) {
					addToResult(sourceLine, BcelJavaType.create(type), result);
				}
			}

		};
		new DescendingVisitor(getWrappedType(type), visitor).visit();
		// Add throws
		for (Entry<Type, Collection<Integer>> entry : getThrows(type)
				.entrySet()) {
			for (Integer sourceLine : entry.getValue()) {
				addToResult(sourceLine, entry.getKey(), result);
			}
		}
		return result;
	}

	private org.apache.bcel.classfile.JavaClass getWrappedType(Type type) {
		return ((BcelJavaType) type).getWrapped();
	}

	boolean hasImport(ASTCompilationUnit compilationUnit, Type type) {
		if (type.getPackage().equals("java.lang")
				|| type.getPackage().equals(getPackage(compilationUnit))) {
			// The java.lang package is imported by default
			// The types on the same package are not imported
			return true;
		} else {
			for (ASTImportDeclaration importDeclaration : compilationUnit
					.findChildrenOfType(ASTImportDeclaration.class)) {
				String importTypeName = importDeclaration.getFirstChildOfType(
						ASTName.class).getImage();
				if (importTypeName.equals(type.getName())) {
					return true;
				}
			}
			return false;
		}
	}

	private boolean isAnonymous(String currentTypeName) {
		try {
			new Integer(currentTypeName);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isConstructor(final Method method) {
		return method.getName().matches("<.*>");
	}

	private void iterateInstructions(Code code, Type type,
			Map<Instruction, Integer> instructionOffset,
			org.apache.bcel.generic.Visitor visitor) {
		InstructionList instructionList = new InstructionList(code.getCode());
		@SuppressWarnings("unchecked")
		Iterator<InstructionHandle> iterator = instructionList.iterator();
		while (iterator.hasNext()) {
			InstructionHandle ih = iterator.next();
			final Instruction instruction = ih.getInstruction();
			final int offset = ih.getPosition();
			instructionOffset.put(instruction, offset); // TODO refactor?
			instruction.accept(visitor);
		}
	}

	@Override
	public Type lookupType(Class<?> clazz) throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository
				.lookupClass(clazz);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Class not found: "
					+ clazz.getName());
		} else {
			return BcelJavaType.create(lookupClass);
		}
	}

	@Override
	public Type lookupType(String typeName) throws ClassNotFoundException {
		// TODO cache
		return BcelJavaType.create(typeName);
	}

	@Override
	public Type parse(FileInputStream classFile, String typeName)
			throws TypeFormatException, IOException {
		try {
			return BcelJavaType.create(new ClassParser(classFile, typeName)
					.parse());
		} catch (final org.apache.bcel.classfile.ClassFormatException e) {
			throw new TypeFormatException(e);
		}
	}

}
