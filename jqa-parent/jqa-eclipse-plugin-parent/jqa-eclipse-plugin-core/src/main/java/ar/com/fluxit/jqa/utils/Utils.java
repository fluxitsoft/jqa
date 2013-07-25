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
package ar.com.fluxit.jqa.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class Utils {

	public static File getAbsolutePath(IPath path) throws JavaModelException {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(path)
				.getLocation().toFile();
	}

	public static File[] getSourcesDirs(IJavaProject javaProject)
			throws JavaModelException {
		Collection<File> result = new ArrayList<File>();
		IPackageFragmentRoot[] packageFragmentRoot = javaProject
				.getAllPackageFragmentRoots();
		for (int i = 0; i < packageFragmentRoot.length; i++) {
			if (packageFragmentRoot[i].getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT
					&& !packageFragmentRoot[i].isArchive()) {
				result.add(getAbsolutePath(packageFragmentRoot[i].getPath()));
			}
		}
		return result.toArray(new File[result.size()]);
	}
}