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
