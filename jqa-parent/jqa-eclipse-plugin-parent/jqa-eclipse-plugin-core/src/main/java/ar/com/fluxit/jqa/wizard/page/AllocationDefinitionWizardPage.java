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
package ar.com.fluxit.jqa.wizard.page;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AllocationDefinitionWizardPage extends
		AbstractLayerCheckWizardPage {

	public static final String PAGE_NAME = "AllocationDefinitionWizardPage";

	public AllocationDefinitionWizardPage() {
		super(PAGE_NAME, "Allocation definition",
				"Define wich layers has allocable (instantiable) classes");
	}

	@Override
	ICheckStateListener getCheckStateListener() {
		return new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				((Layer) event.getElement()).setAllocable(event.getChecked());
			}
		};
	}

	@Override
	ICheckStateProvider getCheckStateProvider() {
		return new ICheckStateProvider() {

			@Override
			public boolean isChecked(Object element) {
				return ((Layer) element).isAllocable();
			}

			@Override
			public boolean isGrayed(Object element) {
				return false;
			}
		};
	}

}
