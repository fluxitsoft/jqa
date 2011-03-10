package ar.com.fluxit.jqa.bce.bcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.apache.bcel.util.ByteSequence;

import ar.com.fluxit.jqa.bce.ClassFormatException;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.bcel.util.ClassNameTranslator;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RepositoryImpl implements Repository {

	private static final String VOID = "void";
	protected static final String NEW_OPCODE_NAME = "new";

	@Override
	public void addClass(JavaClass clazz) {
		org.apache.bcel.Repository.addClass(getWrappedClass(clazz));
	}

	@Override
	public Collection<JavaClass> getAllocations(final JavaClass clazz) {
		final List<JavaClass> result = new ArrayList<JavaClass>();
		getWrappedClass(clazz).getMethods();
		final Visitor visitor = new EmptyVisitor() {

			@Override
			public void visitCode(Code obj) {
				final ByteSequence stream = new ByteSequence(obj.getCode());
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

	private ConstantPool getConstantPool(JavaClass clazz) {
		return getWrappedClass(clazz).getConstantPool();
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

	private org.apache.bcel.classfile.JavaClass getWrappedClass(
			JavaClass clazz) {
		return ((BcelJavaClass) clazz).getWrapped();
	}

	@Override
	public boolean instanceOf(JavaClass clazz, JavaClass parentJavaClass)
			throws ClassNotFoundException {
		return org.apache.bcel.Repository.instanceOf(
				getWrappedClass(clazz),
				getWrappedClass(parentJavaClass));
	}

	@Override
	public JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException {
		return new BcelJavaClass(org.apache.bcel.Repository.lookupClass(clazz));
	}

	@Override
	public JavaClass lookupClass(String parentClassName)
			throws ClassNotFoundException {
		return new BcelJavaClass(
				org.apache.bcel.Repository.lookupClass(parentClassName));
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

}
