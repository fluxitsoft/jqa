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

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import ar.com.fluxit.jqa.entities.CommonType;
import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CommonTypesContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof Layer) {
			return ((Layer) element).getCommonTypes().toArray();
		} else {
			throw new IllegalArgumentException("Unsupported type "
					+ element.getClass().getName());
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getElements(Object input) {
		if (input instanceof List) {
			return ((List) input).toArray();
		} else {
			throw new IllegalArgumentException("Unsupported type "
					+ input.getClass().getName());

		}
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof Layer) {
			return null;
		} else if (element instanceof CommonType) {
			return ((CommonType) element).getLayer();
		} else {
			throw new IllegalArgumentException("Unsupported type "
					+ element.getClass().getName());
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Layer) {
			return !((Layer) element).getCommonTypes().isEmpty();
		} else if (element instanceof CommonType) {
			return false;
		} else {
			throw new IllegalArgumentException("Unsupported type "
					+ element.getClass().getName());
		}
	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

}
