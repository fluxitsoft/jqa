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

import net.sourceforge.pmd.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.ast.ASTCompilationUnit;
import net.sourceforge.pmd.ast.CharStream;
import net.sourceforge.pmd.ast.JavaCharStream;
import net.sourceforge.pmd.ast.JavaParser;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.DescendingVisitor;
import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Visitor;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BasicType;
import org.apache.bcel.generic.ObjectType;

import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.bce.TypeFormatException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RepositoryImpl implements Repository {

	private static final String VOID = "void";
	protected static final String NEW_OPCODE_NAME = "new";
	protected static final String INVOKE_PREFIX_OPCODE_NAME = "invoke";
	protected static final String THROW_OPCODE_NAME = "athrow";
	protected static final int SLIDE = 6;
	private String javaVersion;

	@Override
	public Collection<Type> getAllocations(final Type type) {
		final List<Type> result = new ArrayList<Type>();
		getWrappedClass(type).getMethods();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				final ByteSequence stream = new ByteSequence(code.getCode());
				short opcode;
				try {
					while (stream.available() > 0) {
						opcode = (short) stream.readUnsignedByte();
						final String op = Constants.OPCODE_NAMES[opcode];
						if (NEW_OPCODE_NAME.equals(op)) {
							final int index = stream.readUnsignedShort();
							final ConstantPool constantPool = getWrappedClass(type).getConstantPool();
							final String className = constantPool.constantToString(index, (byte) 7);
							result.add(getType(className));
						}
					}
				} catch (final IOException e) {
					throw new IllegalStateException(e);
				}
			}

		};
		new DescendingVisitor(getWrappedClass(type), visitor).visit();
		return result;
	}

	private String getClassName(final int index, final ConstantPool constantPool) {
		String result;
		try {
			result = constantPool.constantToString(index, Constants.CONSTANT_Methodref);
			result = result.substring(result.indexOf(")") + 2).replaceAll(";", "");
		} catch (ClassFormatException e) {
			result = constantPool.constantToString(index, Constants.CONSTANT_InterfaceMethodref);
			result = result.substring(0, result.lastIndexOf("."));
		}
		return result;
	}

	private String getClassName(org.apache.bcel.generic.Type type) {
		String signatureClassName;
		if (type instanceof BasicType) {
			signatureClassName = Constants.CLASS_TYPE_NAMES[type.getType()];
		} else if (type instanceof ObjectType) {
			signatureClassName = ((ObjectType) type).getClassName();
		} else {
			signatureClassName = getClassName(((ArrayType) type).getBasicType());
		}
		return signatureClassName;
	}

	private ConstantPool getConstantPool(Type type) {
		return getWrappedClass(type).getConstantPool();
	}

	@Override
	public Integer getDeclarationLineNumber(Type type, File sourceDir) throws FileNotFoundException {
		// TODO cache
		final CharStream stream = new JavaCharStream(getSourceFile(type, sourceDir));
		final JavaParser javaParser = new JavaParser(stream);
		if ("1.5".equals(this.javaVersion) || "1.6".equals(this.javaVersion)) {
			javaParser.setJDK15();
		}
		final ASTCompilationUnit compilationUnit = javaParser.CompilationUnit();
		return compilationUnit.getFirstChildOfType(ASTClassOrInterfaceDeclaration.class).getBeginLine();
	}

	@Override
	public Collection<Type> getInterfaces(Type type) {
		try {
			org.apache.bcel.classfile.JavaClass[] interfaces;
			interfaces = org.apache.bcel.Repository.getInterfaces(getWrappedClass(type));
			final List<Type> result = new ArrayList<Type>(interfaces.length);
			for (final org.apache.bcel.classfile.JavaClass interfaz : interfaces) {
				result.add(new BcelJavaType(interfaz));
			}
			return result;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public InputStream getSourceFile(Type type, File sourceDir) throws FileNotFoundException {
		return new FileInputStream(sourceDir + "/" + type.getName().replace(".", "/") + ".java");
	}

	@Override
	public Collection<Type> getSuperClasses(Type type) {
		org.apache.bcel.classfile.JavaClass[] superClasses;
		try {
			superClasses = org.apache.bcel.Repository.getSuperClasses(getWrappedClass(type));
			final List<Type> result = new ArrayList<Type>(superClasses.length);
			for (final org.apache.bcel.classfile.JavaClass superClass : superClasses) {
				result.add(new BcelJavaType(superClass));
			}
			return result;
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public Collection<Type> getThrows(final Type type) {
		final List<Type> result = new ArrayList<Type>();
		// getWrappedClass(type).getMethods();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				final ByteSequence stream = new ByteSequence(code.getCode());
				short opcode;
				try {
					while (stream.available() > 0) {
						opcode = (short) stream.readUnsignedByte();
						final String op = Constants.OPCODE_NAMES[opcode];
						if (THROW_OPCODE_NAME.equals(op)) {
							for (int i = 0; i < SLIDE; i++) {
								stream.unreadByte();
							}
							final int index = stream.readUnsignedByte();
							final ConstantPool constantPool = getWrappedClass(type).getConstantPool();
							final String className = constantPool.constantToString(index, (byte) 7);
							result.add(getType(className));
							for (int i = 0; i < SLIDE - 1; i++) {
								stream.readUnsignedByte();
							}
						}
					}
				} catch (final IOException e) {
					throw new IllegalStateException(e);
				}
			}

		};
		new DescendingVisitor(getWrappedClass(type), visitor).visit();
		return result;
	}

	private Type getType(ConstantClass constantClass, Type type) {
		final ConstantPool cp = getConstantPool(type);
		return getType(constantClass.getBytes(cp));
	}

	private Type getType(String constantClassName) {
		final String usedClassName = ClassNameTranslator.typeConstantToClassName(constantClassName);
		org.apache.bcel.classfile.JavaClass usedClass;
		try {
			usedClass = org.apache.bcel.Repository.lookupClass(usedClassName);
			return new BcelJavaType(usedClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public Collection<Type> getUses(final Type type) {
		// TODO cache
		final Collection<Type> uses = new ArrayList<Type>();
		getWrappedClass(type).getMethods();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code code) {
				final ByteSequence stream = new ByteSequence(code.getCode());
				short opcode;
				try {
					while (stream.available() > 0) {
						opcode = (short) stream.readUnsignedByte();
						final String op = Constants.OPCODE_NAMES[opcode];
						if (op.startsWith(INVOKE_PREFIX_OPCODE_NAME)) {
							final int index = stream.readUnsignedShort();
							final ConstantPool constantPool = getWrappedClass(type).getConstantPool();
							String className = getClassName(index, constantPool);
							if (!className.isEmpty()) {
								uses.add(getType(className));
							}
						}
					}
				} catch (final IOException e) {
					throw new IllegalStateException(e);
				}
			}

			@Override
			public void visitConstantClass(ConstantClass constantClass) {
				uses.add(getType(constantClass, type));
			}

			@Override
			public void visitField(Field field) {
				final org.apache.bcel.generic.Type type = org.apache.bcel.generic.Type.getType(field.getSignature());
				uses.add(getType(getClassName(type)));
			}

			@Override
			public void visitMethod(Method method) {
				final List<String> classNames = ClassNameTranslator.signatureToClassNames(method.getSignature());
				for (final String className : classNames) {
					if (!className.equals(VOID)) {
						uses.add(getType(className));
					}
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

	@Override
	public Type lookupType(Class<?> clazz) throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository.lookupClass(clazz);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Class not found: " + clazz.getName());
		} else {
			return new BcelJavaType(lookupClass);
		}
	}

	@Override
	public Type lookupType(String typeName) throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository.lookupClass(typeName);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Can not find class " + typeName);
		} else {
			return new BcelJavaType(lookupClass);
		}
	}

	@Override
	public Type parse(FileInputStream fis, String object) throws TypeFormatException, IOException {
		try {
			return new BcelJavaType(new ClassParser(fis, object).parse());
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
