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
package ar.com.fluxit.jqa.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class FileUtils {

	private static final String CLASS_FILE_EXTENSION = ".class";
	public static final FileUtils INSTANCE = new FileUtils();

	public FileUtils() {
		super();
	}

	public File getClassFile(Class<?> clazz) {
		final String fileName = clazz.getResource(clazz.getSimpleName() + CLASS_FILE_EXTENSION).getFile();
		return new File(fileName);
	}

	public Collection<File> getClassFiles(Class<?>... classes) {
		final Collection<File> result = new ArrayList<File>();
		for (final Class<?> clazz : classes) {
			result.add(getClassFile(clazz));
		}
		return result;
	}
}
