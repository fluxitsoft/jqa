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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.management.IntrospectionException;

import org.slf4j.Logger;

import ar.com.fluxit.jqa.bce.ClassFormatException;
import ar.com.fluxit.jqa.bce.RepositoryLocator;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassPathLoader {

	public static ClassPathLoader INSTANCE = new ClassPathLoader();

	private ClassPathLoader() {
		super();
	}

	public void addArtifactFile(File file, Logger log)
			throws IntrospectionException, ClassFormatException,
			FileNotFoundException, IOException {
		// addURL(file.toURI().toURL(), log);
		System.setProperty("java.class.path", System
				.getProperty("java.class.path")
				+ ":" + file.getPath());
		log.debug("File added to classpath " + file);
	}

	public void addClassFile(File file, Logger log)
			throws ClassFormatException, IOException {
		final FileInputStream file2 = new FileInputStream(file);
		RepositoryLocator.getRepository().addClass(
				RepositoryLocator.getRepository().parse(file2, null));
		file2.close();
		log.debug("File added to classpath " + file);
	}

	// public void addURL(URL url, Logger log) throws IntrospectionException {
	// final URLClassLoader systemClassLoader = (URLClassLoader)
	// ClassPath.SYSTEM_CLASS_PATH
	// .getClass().getClassLoader();
	// try {
	// final Method method = URLClassLoader.class.getDeclaredMethod(
	// "addURL", new Class[] { URL.class });
	// method.setAccessible(true);
	// method.invoke(systemClassLoader, new Object[] { url });
	// log.debug("File added to classpath " + url);
	// } catch (final Throwable t) {
	// throw new IntrospectionException(
	// "Error when adding url to system ClassLoader");
	// }
	// }

}
