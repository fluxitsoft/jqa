/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class JdtUtils {

	private static final int COMMON_TYPE_PACKAGE_DEEP = 4;

	private static boolean check(CommonDescriptor commonType, String pkgName) {
		if ("java".equals(commonType.getTypeName())) {
			// java is outside the discussion
			return false;
		} else {
			// Check that the package is from an external library
			String[] commonNameSplit = commonType.getTypeName().split("\\.");
			String[] pkgNameSplit = pkgName.split("\\.");
			int end = Math.min(commonNameSplit.length, pkgNameSplit.length);
			end = Math.min(end, COMMON_TYPE_PACKAGE_DEEP);
			for (int i = 0; i < end; i++) {
				if (!commonNameSplit[i].equals(pkgNameSplit[i])) {
					return true;
				}
			}
			return false;
		}
	}

	private static Set<CommonDescriptor> collectCommonTypes(
			Collection<String> packages, IProject[] targetProjects) {
		Set<CommonDescriptor> commonTypes = new HashSet<CommonDescriptor>();
		for (IPackageFragment pkg : getPackageFragments(packages,
				targetProjects)) {
			commonTypes.addAll(JdtUtils.collectCommonTypes(pkg));
		}
		return commonTypes;
	}

	private static Collection<CommonDescriptor> collectCommonTypes(
			ICompilationUnit compilationUnit) {
		try {
			Collection<CommonDescriptor> result = new ArrayList<CommonDescriptor>();
			for (IImportDeclaration importDeclaration : compilationUnit
					.getImports()) {
				result.add(new CommonDescriptor(
						getCommonTypeName(importDeclaration)));
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"Error while processing common types", e);
		}
	}

	private static Collection<CommonDescriptor> collectCommonTypes(
			IPackageFragment packageFragment) {
		try {
			Collection<CommonDescriptor> result = new ArrayList<CommonDescriptor>();
			ICompilationUnit[] compilationUnits = packageFragment
					.getCompilationUnits();
			for (ICompilationUnit compilationUnit : compilationUnits) {
				for (CommonDescriptor commonType : JdtUtils
						.collectCommonTypes(compilationUnit)) {
					if (check(commonType, packageFragment.getElementName())) {
						result.add(commonType);
					}
				}
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"Error while processing common types", e);
		}
	}

	public static Set<CommonDescriptor> collectCommonTypes(
			LayerDescriptor targetLayer, IProject[] targetProjects) {
		return collectCommonTypes(targetLayer.getPackages(), targetProjects);
	}

	public static File getAbsolutePath(IPath path) throws JavaModelException {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(path)
				.getLocation().toFile();
	}

	private static String getCommonTypeName(IImportDeclaration importDeclaration) {
		String importName = importDeclaration.getElementName();
		if (importName.startsWith("java.")) {
			return "java";
		} else {
			String[] splitImport = importName.split("\\.");
			String elementName = "";
			int end = Math
					.min(COMMON_TYPE_PACKAGE_DEEP, splitImport.length - 1);
			for (int i = 0; i < end; i++) {
				elementName += splitImport[i] + ".";
			}
			return elementName.substring(0, elementName.length() - 1);
		}
	}

	public static Collection<IPackageFragment> getPackageFragments(
			Collection<String> packages, IProject[] targetProjects) {
		Collection<IPackageFragment> result = new ArrayList<IPackageFragment>();
		for (String pkg : packages) {
			result.addAll(getPackages(pkg, targetProjects));
		}
		return result;
	}

	private static Collection<IPackageFragment> getPackages(String pkg,
			IProject[] targetProjects) {
		try {
			Collection<IPackageFragment> result = new ArrayList<IPackageFragment>();
			for (IProject project : targetProjects) {
				IJavaProject javaProject = JavaCore.create(project);
				for (IPackageFragment packageFragment : javaProject
						.getPackageFragments()) {
					if (packageFragment.getElementName().equals(pkg)
							&& JdtUtils.isSourcePackage(packageFragment)) {
						result.add(packageFragment);
					}
				}
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"An error occured while collecting packages", e);
		}
	}

	public static File[] getSourcesDirs(IJavaProject javaProject)
			throws JavaModelException {
		Collection<File> result = new ArrayList<File>();
		IPackageFragmentRoot[] packageFragmentRoot = javaProject
				.getPackageFragmentRoots();
		for (int i = 0; i < packageFragmentRoot.length; i++) {
			if (packageFragmentRoot[i].getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT
					&& !packageFragmentRoot[i].isArchive()) {
				result.add(getAbsolutePath(packageFragmentRoot[i].getPath()));
			}
		}
		return result.toArray(new File[result.size()]);
	}

	public static boolean hasCommonTypes(LayerDescriptor element,
			Map<String, Set<CommonDescriptor>> commonTypes) {
		for (String pkg : element.getPackages()) {
			Collection<CommonDescriptor> collection = commonTypes.get(pkg);
			if (collection != null && !collection.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSourcePackage(IPackageFragment packageFragment) {
		try {
			return packageFragment.containsJavaResources()
					&& packageFragment.getKind() == IPackageFragmentRoot.K_SOURCE;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"An error has occurred while collection Java packages", e);
		}
	}
}