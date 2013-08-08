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

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ApisDefinitionWizardPage extends AbstractLayerCheckWizardPage {

	public static final String PAGE_NAME = "ApisDefinitionWizardPage";

	public ApisDefinitionWizardPage() {
		super(PAGE_NAME, "APIs definition",
				"Define which layers must be accessed via API (interfaces)");
	}

	@Override
	ICheckStateListener getCheckStateListener() {
		return new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				((LayerDescriptor) event.getElement()).setHasApi(event.getChecked());
			}
		};
	}

	@Override
	ICheckStateProvider getCheckStateProvider() {
		return new ICheckStateProvider() {

			@Override
			public boolean isChecked(Object element) {
				return ((LayerDescriptor) element).isHasApi();
			}

			@Override
			public boolean isGrayed(Object element) {
				return false;
			}
		};
	}

}
