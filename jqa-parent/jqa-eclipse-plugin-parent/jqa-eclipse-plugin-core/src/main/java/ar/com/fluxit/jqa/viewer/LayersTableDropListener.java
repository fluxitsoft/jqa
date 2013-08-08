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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.utils.JdtUtils;
import ar.com.fluxit.jqa.wizard.JQAWizard;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersTableDropListener extends ViewerDropAdapter {

	// target drag
	private final Holder<DropStrategy> dropStrategyHolder;
	// target wizard
	private final JQAWizard wizardContainer;

	public LayersTableDropListener(Viewer viewer,
			Holder<DropStrategy> dropStrategyHolder, JQAWizard wizard) {
		super(viewer);
		this.dropStrategyHolder = dropStrategyHolder;
		this.wizardContainer = wizard;
	}

	@Override
	public void drop(final DropTargetEvent event) {
		// TODO run in background because this blocks the screen
		final LayerDescriptor targetLayer = (LayerDescriptor) event.item
				.getData();
		final IJavaElement[] packages = (IJavaElement[]) event.data;
		final Collection<String> droppedPackages = new ArrayList<String>(
				packages.length);
		for (IJavaElement pkg : packages) {
			droppedPackages.add(((IPackageFragment) pkg).getElementName());
		}
		targetLayer.addPackages(droppedPackages);
		Set<CommonDescriptor> commonTypes = JdtUtils.collectCommonTypes(
				targetLayer, getWizard().getTargetProjects());
		if (!targetLayer.getCommons().equals(commonTypes)) {
			// Avoid lose the common types assignments
			targetLayer.setCommons(commonTypes);
		}
		getViewer().setSelection(new StructuredSelection(targetLayer));
		getDropStrategyHolder().getValue().drop(droppedPackages);
		getViewer().refresh();
		getWizard().getContainer().updateButtons();
	}

	public Holder<DropStrategy> getDropStrategyHolder() {
		return dropStrategyHolder;
	}

	private JQAWizard getWizard() {
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
			// shows the current layer content
			LayerDescriptor targetLayer = (LayerDescriptor) determineTarget(getCurrentEvent());
			getViewer().setSelection(new StructuredSelection(targetLayer));
			getViewer().refresh();
		}
		return result;
	}

}
