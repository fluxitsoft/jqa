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
package ar.com.fluxit.jqa.wizard.page;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CommonsTypesDefinitionWizardPage extends AbstractWizardPage
		implements IPageChangedListener {

	public static final String PAGE_NAME = "CommonsTypesDefinitionWizardPage";

	public CommonsTypesDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Common types definition");
		setDescription("Define the common types of each layer");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		setControl(container);
		((WizardDialog) getContainer()).addPageChangedListener(this);
	}

	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getSelectedPage() == this) {
			// TODO
		}
	}

}
