/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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

import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersListTableDropListener extends ViewerDropAdapter {

	private final List<IJavaElement> targetPackages;
	private final TableViewer targetPackagesTable;

	public LayersListTableDropListener(Viewer viewer,
			List<IJavaElement> targetPackages, TableViewer targetPackagesTable) {
		super(viewer);
		this.targetPackages = targetPackages;
		this.targetPackagesTable = targetPackagesTable;
	}

	@Override
	public void drop(DropTargetEvent event) {
		Layer targetLayer = (Layer) event.item.getData();
		final IJavaElement[] droppedPackages = (IJavaElement[]) event.data;
		targetLayer.addAll(droppedPackages);
		getTargetPackages().removeAll(Arrays.asList(droppedPackages));
		getTargetPackagesTable().refresh(false);
		getViewer().setSelection(new StructuredSelection(targetLayer));
		getViewer().refresh();
	}

	public List<IJavaElement> getTargetPackages() {
		return targetPackages;
	}

	public TableViewer getTargetPackagesTable() {
		return targetPackagesTable;
	}

	@Override
	public boolean performDrop(Object arg0) {
		return true;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData data) {
		return determineLocation(getCurrentEvent()) == ViewerDropAdapter.LOCATION_ON;
	}

}
