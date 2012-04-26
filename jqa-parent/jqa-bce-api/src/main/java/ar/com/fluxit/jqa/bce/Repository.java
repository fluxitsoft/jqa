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

	Collection<Type> getAllocations(Type type);

	Integer getDeclarationLineNumber(Type type, File sourceDir) throws FileNotFoundException;

	/**
	 * @param type
	 *            a type
	 * @return all interfaces implemented by the type and its super classes and
	 *         the interfaces that those interfaces extend, and so on. (Some
	 *         people call this a transitive hull).
	 */
	Collection<Type> getInterfaces(Type type);

	/**
	 * @param type
	 *            a type
	 * @return list of super classes of the type in ascending order, i.e.,
	 *         java.lang.Object is always the last element
	 */
	Collection<Type> getSuperClasses(Type type);

	Collection<Type> getThrows(Type type);

	Collection<Type> getUses(Type type);

	Type lookupType(Class<?> clazz) throws ClassNotFoundException;

	Type lookupType(String typeName) throws ClassNotFoundException;

	Type parse(FileInputStream classFile, String typeName) throws TypeFormatException, IOException;

	void setClassPath(Collection<File> classPathFiles) throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException;

}
