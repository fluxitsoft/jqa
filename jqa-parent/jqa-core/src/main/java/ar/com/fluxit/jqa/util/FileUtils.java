/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
		final String fileName = clazz.getResource(
				clazz.getSimpleName() + CLASS_FILE_EXTENSION).getFile();
		return new File(fileName);
	}

	public Collection<File> getClassFiles(Class<?>... classes) {
		final Collection<File> result = new ArrayList<File>();
		for (final Class<?> clazz : classes) {
			result.add(getClassFile(clazz));
		}
		return result;
	}

	private boolean copyJarResourcesRecursively(final File destDir,
			final JarURLConnection jarConnection) throws IOException {

		final JarFile jarFile = jarConnection.getJarFile();

		for (final Enumeration<JarEntry> e = jarFile.entries(); e
				.hasMoreElements();) {
			final JarEntry entry = e.nextElement();
			if (entry.getName().startsWith(jarConnection.getEntryName())) {
				final String filename = removeStart(entry.getName(),
						jarConnection.getEntryName());

				final File f = new File(destDir, filename);
				if (!entry.isDirectory()) {
					final InputStream entryInputStream = jarFile
							.getInputStream(entry);
					copyStream(entryInputStream, f);
					entryInputStream.close();
				} else {
					if (!ensureDirectoryExists(f)) {
						throw new IOException("Could not create directory: "
								+ f.getAbsolutePath());
					}
				}
			}
		}
		return true;
	}

	public void copyResourcesRecursively(final URL originUrl,
			final File destination) throws IOException {
		final URLConnection urlConnection = originUrl.openConnection();
		final File toCopy = new File(originUrl.getPath());
		final File newDestDir = new File(destination, toCopy.getName());
		if (!newDestDir.exists() && !newDestDir.mkdir()) {
			return;
		}
		copyJarResourcesRecursively(newDestDir,
				(JarURLConnection) urlConnection);
	}

	private void copyStream(final InputStream is, final File f)
			throws IOException {
		copyStream(is, new FileOutputStream(f));
	}

	private void copyStream(final InputStream is, final OutputStream os)
			throws IOException {
		try {
			final byte[] buf = new byte[1024];

			int len = 0;
			while ((len = is.read(buf)) > 0) {
				os.write(buf, 0, len);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	private boolean ensureDirectoryExists(final File f) {
		return f.exists() || f.mkdir();
	}

	private String removeStart(String str, String remove) {
		if (isEmpty(str) || isEmpty(remove)) {
			return str;
		}
		if (str.startsWith(remove)) {
			return str.substring(remove.length());
		}
		return str;
	}

	private boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

}
