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
package ar.com.fluxit.jqa.viewer;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersListTableDropListener extends ViewerDropAdapter {

	private final TableViewer targetPackagesTable;
	private final Holder<Collection<IJavaElement>> inputHolder;
	private final Holder<Viewer> viewerHolder;
	private final IWizardContainer wizardContainer;

	public LayersListTableDropListener(Viewer viewer,
			TableViewer targetPackagesTable, Holder<Viewer> viewerHolder,
			Holder<Collection<IJavaElement>> inputHolder,
			IWizardContainer wizardContainer) {
		super(viewer);
		this.targetPackagesTable = targetPackagesTable;
		this.viewerHolder = viewerHolder;
		this.inputHolder = inputHolder;
		this.wizardContainer = wizardContainer;
	}

	@Override
	public void drop(DropTargetEvent event) {
		Layer targetLayer = (Layer) event.item.getData();
		final IJavaElement[] droppedPackages = (IJavaElement[]) event.data;
		targetLayer.getPackages().addAll(Arrays.asList(droppedPackages));
		getDragInputHolder().getValue().removeAll(
				Arrays.asList(droppedPackages));
		getDragViewerHolder().getValue().refresh();
		getViewer().setSelection(new StructuredSelection(targetLayer));
		getViewer().refresh();
		getWizardContainer().updateButtons();
	}

	private Holder<Collection<IJavaElement>> getDragInputHolder() {
		return inputHolder;
	}

	private Holder<Viewer> getDragViewerHolder() {
		return viewerHolder;
	}

	public TableViewer getTargetPackagesTable() {
		return targetPackagesTable;
	}

	private IWizardContainer getWizardContainer() {
		return wizardContainer;
	}

	@Override
	public boolean performDrop(Object arg0) {
		return true;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData data) {
		final boolean result = determineLocation(getCurrentEvent()) == ViewerDropAdapter.LOCATION_ON;
		if (result) {
			Layer targetLayer = (Layer) determineTarget(getCurrentEvent());
			getViewer().setSelection(new StructuredSelection(targetLayer));
			getViewer().refresh();
		}
		return result;
	}
}
