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

import java.io.File;
import java.util.Collection;
import java.util.Collections;

import ar.com.fluxit.jqa.bce.bcel.BCERepositoryImpl;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BCERepositoryLocator {

	private static BCERepository bceRepository;

	public static BCERepository getRepository() {
		if (bceRepository == null) {
			throw new IllegalStateException("The repository is not initializated. Please, call to init method.");
		}
		return bceRepository;
	}

	private static String getSourcesDir() {
		return System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "test" + File.separatorChar + "java";
	}

	public static void init(Collection<File> classPath, String javaVersion, String sourcesDir) {
		bceRepository = new BCERepositoryImpl(classPath == null ? Collections.<File> emptyList() : classPath, javaVersion, sourcesDir == null ? getSourcesDir()
				: sourcesDir);
	}

}
