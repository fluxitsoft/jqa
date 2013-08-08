/*******************************************************************************
 * Copyright (c) 2011 Flux IT.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
package ar.com.fluxit.jqa.viewer;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import ar.com.fluxit.jqa.utils.JdtUtils;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public final class LayerPackagesContentProvider implements
		IStructuredContentProvider {

	private final Holder<IProject[]> targetProjectsHolder;

	public LayerPackagesContentProvider(Holder<IProject[]> targetProjectsHolder) {
		super();
		this.targetProjectsHolder = targetProjectsHolder;
	}

	@Override
	public void dispose() {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		try {
			if (inputElement instanceof Collection) {
				@SuppressWarnings("unchecked")
				Collection<String> packages = (Collection<String>) inputElement;
				Collection<IJavaElement> result = new ArrayList<IJavaElement>(
						packages.size());
				for (String pkg : packages) {
					for (IProject project : getTargetProjectsHolder()
							.getValue()) {
						IJavaProject javaProject = JavaCore.create(project);
						for (IPackageFragment packageFragment : javaProject
								.getPackageFragments()) {
							if (packageFragment.getElementName().equals(pkg)
									&& JdtUtils
											.isSourcePackage(packageFragment)) {
								result.add(packageFragment);
							}
						}
					}
				}
				return result.toArray();
			} else {
				throw new IllegalArgumentException("Not supported input: "
						+ inputElement.getClass().getName());
			}
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"An error has occurred while collection Java packages", e);
		}
	}

	private Holder<IProject[]> getTargetProjectsHolder() {
		return targetProjectsHolder;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
