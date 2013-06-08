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

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TargetPackagesDragListener extends DragSourceAdapter {

	private final TableViewer tableViewer;

	public TargetPackagesDragListener(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	@Override
	public void dragFinished(DragSourceEvent paramDragSourceEvent) {
		// do nothing
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) getTableViewer()
				.getSelection();
		event.data = selection.toList().toArray(
				new IJavaElement[selection.size()]);
	}

	@Override
	public void dragStart(DragSourceEvent paramDragSourceEvent) {
		// do nothing
	}

	private TableViewer getTableViewer() {
		return tableViewer;
	}

}
