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
package ar.com.fluxit.jqa.wizard.page;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SelectRulesContextPage extends WizardPage {

	public SelectRulesContextPage() {
		super("SelectRulesContextPage");
		setTitle("Rules context selection");
		setDescription("Select your rules context to run");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);
		setPageComplete(false);
		// New rules contexto
		Composite newRulesContextContainer = new Composite(container, SWT.NONE);
		Layout newRulesContextLayout = new GridLayout();
		newRulesContextContainer.setLayout(newRulesContextLayout);
		final Button newRulesContextRadio = new Button(
				newRulesContextContainer, SWT.RADIO);
		newRulesContextRadio.setSelection(true);
		newRulesContextRadio.setText("New rules context");

		// Existent rules context
		Composite existenRulesContextContainer = new Composite(container,
				SWT.NONE);
		existenRulesContextContainer.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		GridLayout existentRulesContextLayout = new GridLayout();
		existentRulesContextLayout.numColumns = 3;
		existenRulesContextContainer.setLayout(existentRulesContextLayout);
		final Button existentRulesContextRadio = new Button(
				existenRulesContextContainer, SWT.RADIO);
		existentRulesContextRadio.setSelection(false);
		existentRulesContextRadio.setText("Existent rules context");
		final Text selectionRulesContextText = new Text(
				existenRulesContextContainer, SWT.READ_ONLY);
		selectionRulesContextText.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		selectionRulesContextText.setEnabled(false);
		final Button selectionRulesContextButton = new Button(
				existenRulesContextContainer, SWT.NONE);
		selectionRulesContextButton.setText("...");
		selectionRulesContextButton.setLayoutData(new GridData(30, 25));
		selectionRulesContextButton.setEnabled(false);
		// Listeners
		newRulesContextRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectRulesContextPage.this.newRulesContextRadioSelected(
						existentRulesContextRadio, selectionRulesContextText,
						selectionRulesContextButton);
			}
		});
		existentRulesContextRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectRulesContextPage.this.selectionRulesContextRadioSelected(
						newRulesContextRadio, selectionRulesContextText,
						selectionRulesContextButton);
			}
		});
		selectionRulesContextButton
				.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						SelectRulesContextPage.this
								.openRulesContextSelectionDialog();
					}
				});
	}

	protected void openRulesContextSelectionDialog() {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(),
				new BaseWorkbenchContentProvider());
		dialog.setTitle("Tree Selection");
		dialog.setMessage("Select the elements from the tree:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer arg0, Object arg1, Object arg2) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		dialog.open();
	}

	protected void selectionRulesContextRadioSelected(
			Button newRulesContextRadio, Text selectionRulesContextText,
			Button selectionRulesContextButton) {
		newRulesContextRadio.setSelection(false);
		selectionRulesContextText.setEnabled(true);
		selectionRulesContextButton.setEnabled(true);
	}

	protected void newRulesContextRadioSelected(
			Button selectionRuleContextButton, Text selectionRulesContextText,
			Button selectionRulesContextButton) {
		selectionRuleContextButton.setSelection(false);
		selectionRulesContextText.setEnabled(false);
		selectionRulesContextButton.setEnabled(false);
	}

}
