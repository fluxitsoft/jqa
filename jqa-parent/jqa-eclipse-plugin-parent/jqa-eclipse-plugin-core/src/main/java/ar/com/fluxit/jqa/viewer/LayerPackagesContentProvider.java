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

import java.util.Collection;

import org.eclipse.core.resources.IProject;
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

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection) {
			return JdtUtils.getPackageFragments(
					(Collection<String>) inputElement,
					getTargetProjectsHolder().getValue()).toArray();
		} else {
			throw new IllegalArgumentException("Not supported input: "
					+ inputElement.getClass().getName());
		}
	}

	private Holder<IProject[]> getTargetProjectsHolder() {
		return targetProjectsHolder;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

}
