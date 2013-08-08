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

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages;

import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
@SuppressWarnings("restriction")
public class CommonTypesLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			if (element instanceof CommonDescriptor) {
				String imgName;
				if (((CommonDescriptor) element).isCommon()) {
					imgName = IDEInternalWorkbenchImages.IMG_OBJS_COMPLETE_TSK;
				} else {
					imgName = IDEInternalWorkbenchImages.IMG_OBJS_INCOMPLETE_TSK;
				}
				return PlatformUI.getWorkbench().getSharedImages()
						.getImage(imgName);
			} else if (element instanceof LayerDescriptor) {
				return null;
			} else {
				throw new IllegalArgumentException(
						"Unsupported type un column 1: "
								+ element.getClass().getName());
			}
		default:
			throw new IllegalArgumentException("Unsupported column: "
					+ columnIndex);
		}
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return element.toString();
		case 1:
			return "";
		default:
			throw new IllegalArgumentException("Unsupported column: "
					+ columnIndex);
		}
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {

	}
}
