package ar.com.fluxit.jqa.bce;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public interface Repository {

	void addClass(JavaClass clazz);

	Collection<JavaClass> getAllocations(JavaClass clazz);

	Collection<JavaClass> getUses(JavaClass clazz);

	boolean instanceOf(JavaClass clazz, JavaClass parentJavaClass)
			throws ClassNotFoundException;

	JavaClass lookupClass(Class<?> clazz) throws ClassNotFoundException;

	JavaClass lookupClass(String parentClassName) throws ClassNotFoundException;

	JavaClass parse(FileInputStream classFile, String className)
			throws ClassFormatException, IOException;

}
