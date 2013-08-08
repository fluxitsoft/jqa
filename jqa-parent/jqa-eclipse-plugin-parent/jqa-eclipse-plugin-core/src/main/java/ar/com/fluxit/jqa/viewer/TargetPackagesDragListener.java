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
package ar.com.fluxit.jqa.viewer;

import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class TargetPackagesDragListener extends DragSourceAdapter {

	private final TableViewer tableViewer;
	private final DropStrategy dropStrategy;
	private final Holder<DropStrategy> dropStrategyHolder;
	private IJavaElement[] currentSelection;

	public TargetPackagesDragListener(TableViewer tableViewer,
			Holder<DropStrategy> dropStrategyHolder, DropStrategy dropStrategy) {
		this.tableViewer = tableViewer;
		this.dropStrategy = dropStrategy;
		this.dropStrategyHolder = dropStrategyHolder;
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		event.data = currentSelection;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) getTableViewer()
				.getSelection();
		// Get the current selection at start because the table changes while
		// selecting the target Layer. Also, allocates a new IJavaElement array
		// because JavaElementTransfer.javaToNative
		currentSelection = ((List<IJavaElement>) selection.toList())
				.toArray(new IJavaElement[selection.size()]);
		// Sets the target of drag
		getDropStrategy().setSourceLayer(getSourceLayer());
		getDropStrategyHolder().setValue(getDropStrategy());
	}

	public DropStrategy getDropStrategy() {
		return dropStrategy;
	}

	public Holder<DropStrategy> getDropStrategyHolder() {
		return dropStrategyHolder;
	}

	public abstract LayerDescriptor getSourceLayer();

	private TableViewer getTableViewer() {
		return tableViewer;
	}

}
