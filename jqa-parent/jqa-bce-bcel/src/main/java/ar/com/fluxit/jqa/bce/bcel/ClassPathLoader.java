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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.management.IntrospectionException;

import org.apache.bcel.util.ClassPath;
import org.apache.bcel.util.SyntheticRepository;

import ar.com.fluxit.jqa.bce.ClassFormatException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class ClassPathLoader {

	public static ClassPathLoader INSTANCE = new ClassPathLoader();

	private ClassPathLoader() {
		super();
	}

	private void addToClassPath(File file) throws IntrospectionException, ClassFormatException, FileNotFoundException, IOException {
		System.setProperty("java.class.path", System.getProperty("java.class.path") + ":" + file.getPath());
	}

	private void reloadBCELClassPath() {
		try {
			final ClassPath updatedClassPath = new ClassPath(ClassPath.getClassPath());
			final SyntheticRepository repository = SyntheticRepository.getInstance();
			final Field declaredField = repository.getClass().getDeclaredField("_path");
			declaredField.setAccessible(true);
			declaredField.set(repository, updatedClassPath);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public void setClassPath(Collection<File> classPathFiles) throws IntrospectionException, FileNotFoundException, ClassFormatException, IOException {
		for (final File classPathFile : classPathFiles) {
			addToClassPath(classPathFile);
		}
		reloadBCELClassPath();
	}

}
