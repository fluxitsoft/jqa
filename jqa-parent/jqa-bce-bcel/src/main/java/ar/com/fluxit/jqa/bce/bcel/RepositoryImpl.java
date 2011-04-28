/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.IntrospectionException;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.DescendingVisitor;
import org.apache.bcel.classfile.EmptyVisitor;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Visitor;

import ar.com.fluxit.jqa.bce.ClassFormatException;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.Repository;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RepositoryImpl implements Repository {

	private static final String VOID = "void";
	protected static final String NEW_OPCODE_NAME = "new";
	protected static final String THROW_OPCODE_NAME = "athrow";
	protected static final int SLIDE = 6;

	@Override
	public Collection<JavaClass> getAllocations(final JavaClass clazz) {
		final List<JavaClass> result = new ArrayList<JavaClass>();
		getWrappedClass(clazz).getMethods();
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
							final ConstantPool constantPool = getWrappedClass(
									clazz).getConstantPool();
							final String className = constantPool
									.constantToString(index, (byte) 7);
							result.add(getClazz(className));
						}
					}
				} catch (final IOException e) {
					throw new IllegalStateException(e);
				}
			}

		};
		new DescendingVisitor(getWrappedClass(clazz), visitor).visit();
		return result;
	}

	private JavaClass getClazz(ConstantClass constantClass, JavaClass clazz) {
		final ConstantPool cp = getConstantPool(clazz);
		return getClazz(constantClass.getBytes(cp));
	}

	private JavaClass getClazz(String constantClassName) {
		final String usedClassName = ClassNameTranslator
				.typeConstantToClassName(constantClassName);
		final org.apache.bcel.classfile.JavaClass usedClass = org.apache.bcel.Repository
				.lookupClass(usedClassName);
		return new BcelJavaClass(usedClass);
	}

	private ConstantPool getConstantPool(JavaClass clazz) {
		return getWrappedClass(clazz).getConstantPool();
	}

	@Override
	public Collection<JavaClass> getThrows(final JavaClass clazz) {
		final List<JavaClass> result = new ArrayList<JavaClass>();
		getWrappedClass(clazz).getMethods();
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
							final ConstantPool constantPool = getWrappedClass(
									clazz).getConstantPool();
							final String className = constantPool
									.constantToString(index, (byte) 7);
							result.add(getClazz(className));
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
		new DescendingVisitor(getWrappedClass(clazz), visitor).visit();
		return result;
	}

	@Override
	public Collection<JavaClass> getUses(final JavaClass clazz) {
		final List<JavaClass> result = new ArrayList<JavaClass>();
		getWrappedClass(clazz).getMethods();
		final Visitor visitor = new EmptyVisitor() {
			@Override
			public void visitConstantClass(ConstantClass constantClass) {
				result.add(getClazz(constantClass, clazz));
			}

			@Override
			public void visitField(Field field) {
				// TODO ver si se puede pasar esta logica a
				// ClassNameTranslator.typeConstantToClassName
				final String signature = field.getSignature();
				final int beginIndex = signature.startsWith("[") ? 2 : 1;
				final String signatureClassName = signature.substring(
						beginIndex, signature.length() - 1);
				result.add(getClazz(signatureClassName));
			};

			@Override
			public void visitMethod(Method method) {
				final List<String> classNames = ClassNameTranslator
						.signatureToClassNames(method.getSignature());
				for (final String className : classNames) {
					if (!className.equals(VOID)) {
						result.add(getClazz(className));
					}
				}
			}

		};
		new DescendingVisitor(getWrappedClass(clazz), visitor).visit();
		return result;
	}

	private org.apache.bcel.classfile.JavaClass getWrappedClass(JavaClass clazz) {
		return ((BcelJavaClass) clazz).getWrapped();
	}

	@Override
	public boolean instanceOf(JavaClass clazz, JavaClass parentJavaClass)
			throws ClassNotFoundException {
		if (clazz.equals(parentJavaClass)) {
			return true;
		} else {
			return org.apache.bcel.Repository.instanceOf(
					getWrappedClass(clazz), getWrappedClass(parentJavaClass));
		}
	}

	@Override
	public JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository
				.lookupClass(clazz);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Class not found: "
					+ clazz.getName());
		} else {
			return new BcelJavaClass(lookupClass);
		}
	}

	@Override
	public JavaClass lookupClass(String parentClassName)
			throws ClassNotFoundException {
		// TODO cache
		final org.apache.bcel.classfile.JavaClass lookupClass = org.apache.bcel.Repository
				.lookupClass(parentClassName);
		if (lookupClass == null) {
			throw new ClassNotFoundException("Can not find class "
					+ parentClassName);
		} else {
			return new BcelJavaClass(lookupClass);
		}
	}

	@Override
	public JavaClass parse(FileInputStream fis, String object)
			throws ClassFormatException, IOException {
		try {
			return new BcelJavaClass(new ClassParser(fis, object).parse());
		} catch (final org.apache.bcel.classfile.ClassFormatException e) {
			throw new ClassFormatException(e);
		}
	}

	@Override
	public void setClassPath(Collection<File> classPathFiles)
			throws IntrospectionException, FileNotFoundException,
			ClassFormatException, IOException {
		ClassPathLoader.INSTANCE.setClassPath(classPathFiles);
	}

}
