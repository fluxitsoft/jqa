package ar.com.fluxit.jqa.bce.bcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.bcel.classfile.ClassParser;
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
import ar.com.fluxit.jqa.bce.bcel.util.ClassNameTranslator;

public class RepositoryImpl implements Repository {

	private static final String VOID = "void";

	@Override
	public boolean instanceOf(JavaClass clazz, JavaClass parentJavaClass)
			throws ClassNotFoundException {
		return org.apache.bcel.Repository.instanceOf(
				getWrappedJavaClass(clazz),
				getWrappedJavaClass(parentJavaClass));
	}

	@Override
	public JavaClass lookupClass(String parentClassName)
			throws ClassNotFoundException {
		return new BcelJavaClass(
				org.apache.bcel.Repository.lookupClass(parentClassName));
	}

	@Override
	public void addClass(JavaClass clazz) {
		org.apache.bcel.Repository.addClass(getWrappedJavaClass(clazz));
	}

	private org.apache.bcel.classfile.JavaClass getWrappedJavaClass(
			JavaClass clazz) {
		return ((BcelJavaClass) clazz).getWrapped();
	}

	@Override
	public Collection<JavaClass> getUses(final JavaClass clazz) {
		final List<JavaClass> result = new ArrayList<JavaClass>();
		getWrappedJavaClass(clazz).getMethods();
		final Visitor visitor = new EmptyVisitor() {
			@Override
			public void visitConstantClass(ConstantClass constantClass) {
				result.add(getJavaClass(constantClass, clazz));
			}

			public void visitField(Field field) {
				// TODO ver si se puede pasar esta logica a
				// ClassNameTranslator.typeConstantToClassName
				final String signature = field.getSignature();
				final int beginIndex = signature.startsWith("[") ? 2 : 1;
				final String signatureClassName = signature.substring(
						beginIndex, signature.length() - 1);
				result.add(getJavaClass(signatureClassName));
			};

			@Override
			public void visitMethod(Method method) {
				final List<String> classNames = ClassNameTranslator
						.signatureToClassNames(method.getSignature());
				for (String className : classNames) {
					if (!className.equals(VOID)) {
						result.add(getJavaClass(className));
					}
				}
			}

		};
		new DescendingVisitor(getWrappedJavaClass(clazz), visitor).visit();
		return result;
	}

	private JavaClass getJavaClass(ConstantClass constantClass, JavaClass clazz) {
		ConstantPool cp = getConstantPool(clazz);
		return getJavaClass(constantClass.getBytes(cp));
	}

	private JavaClass getJavaClass(String constantClassName) {
		// try {
		String usedClassName = ClassNameTranslator
				.typeConstantToClassName(constantClassName);
		org.apache.bcel.classfile.JavaClass usedClass = org.apache.bcel.Repository
				.lookupClass(usedClassName);
		return new BcelJavaClass(usedClass);
		// } catch (ClassNotFoundException e) {
		// throw new IllegalStateException(e);
		// }
	}

	private ConstantPool getConstantPool(JavaClass clazz) {
		return getWrappedJavaClass(clazz).getConstantPool();
	}

	@Override
	public JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException {
		return new BcelJavaClass(org.apache.bcel.Repository.lookupClass(clazz));
	}

	@Override
	public JavaClass parse(FileInputStream fis, String object)
			throws ClassFormatException, IOException {
		try {
			return new BcelJavaClass(new ClassParser(fis, object).parse());
		} catch (org.apache.bcel.classfile.ClassFormatException e) {
			throw new ClassFormatException(e);
		}
	}

}
