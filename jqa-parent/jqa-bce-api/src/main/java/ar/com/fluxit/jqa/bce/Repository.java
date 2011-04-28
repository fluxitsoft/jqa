package ar.com.fluxit.jqa.bce;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import javax.management.IntrospectionException;

public interface Repository {

	void addClass(JavaClass clazz);

	Collection<JavaClass> getAllocations(JavaClass clazz);

	Collection<JavaClass> getThrows(JavaClass clazz);

	Collection<JavaClass> getUses(JavaClass clazz);

	boolean instanceOf(JavaClass clazz, JavaClass parentClass)
			throws ClassNotFoundException;

	JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException;

	JavaClass lookupClass(String className) throws ClassNotFoundException;

	JavaClass parse(FileInputStream classFile, String className)
			throws ClassFormatException, IOException;

	void setClassPath(Collection<File> classPathFiles)
			throws IntrospectionException, FileNotFoundException,
			ClassFormatException, IOException;

}
