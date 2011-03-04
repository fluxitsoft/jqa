package ar.com.fluxit.jqa.bce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public interface Repository {

	boolean instanceOf(JavaClass clazz, JavaClass parentJavaClass) throws ClassNotFoundException;

	JavaClass lookupClass(String parentClassName) throws ClassNotFoundException;

	void addClass(JavaClass clazz);

	Collection<JavaClass> getUses(JavaClass clazz);

	JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException;

	JavaClass parse(FileInputStream classFile, String className)
			throws ClassFormatException, IOException;

}
