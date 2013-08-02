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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import ar.com.fluxit.jqa.entities.CommonType;
import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class JdtUtils {

	private static final int COMMON_TYPE_PACKAGE_DEEP = 3;

	private static boolean check(CommonType commonType, String pkgName) {
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

	private static Collection<CommonType> collectCommonTypes(
			ICompilationUnit compilationUnit) {
		try {
			Collection<CommonType> result = new ArrayList<CommonType>();
			for (IImportDeclaration importDeclaration : compilationUnit
					.getImports()) {
				result.add(new CommonType(getCommonTypeName(importDeclaration),
						true));
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"Error while processing common types", e);
		}
	}

	public static Collection<CommonType> collectCommonTypes(
			IPackageFragment packageFragment) {
		try {
			Collection<CommonType> result = new ArrayList<CommonType>();
			ICompilationUnit[] compilationUnits = packageFragment
					.getCompilationUnits();
			for (ICompilationUnit compilationUnit : compilationUnits) {
				for (CommonType commonType : JdtUtils
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

	public static boolean hasCommonTypes(Layer element,
			Map<String, Set<CommonType>> commonTypes) {
		for (IJavaElement pkg : element.getPackages()) {
			Collection<CommonType> collection = commonTypes.get(pkg
					.getElementName());
			if (collection != null && !collection.isEmpty()) {
				return true;
			}
		}
		return false;
	}

}