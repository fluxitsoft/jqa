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

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardPage;
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
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import ar.com.fluxit.jqa.JQAEclipsePlugin;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextSelectionWizardPage extends AbstractWizardPage {

	public static final String PAGE_NAME = "RulesContextSelectionWizardPage";

	public RulesContextSelectionWizardPage() {
		super(PAGE_NAME);
		setTitle("Rules context selection");
		setDescription("Select the rules context to run");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);
		// New rules context
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
		final Text existentRulesContextText = new Text(
				existenRulesContextContainer, SWT.READ_ONLY);
		existentRulesContextText.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		existentRulesContextText.setEnabled(false);
		final Button existentRulesContextButton = new Button(
				existenRulesContextContainer, SWT.NONE);
		existentRulesContextButton.setText("...");
		existentRulesContextButton.setLayoutData(new GridData(30, 25));
		existentRulesContextButton.setEnabled(false);
		// Listeners
		newRulesContextRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RulesContextSelectionWizardPage.this.updateSelection(
						existentRulesContextRadio, newRulesContextRadio,
						existentRulesContextText, existentRulesContextButton,
						true);
				getWizard().setNewRulesContext(true);
				getContainer().updateButtons();
			}
		});
		existentRulesContextRadio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RulesContextSelectionWizardPage.this.updateSelection(
						existentRulesContextRadio, newRulesContextRadio,
						existentRulesContextText, existentRulesContextButton,
						false);
				getWizard().setNewRulesContext(false);
				getContainer().updateButtons();
			}
		});
		existentRulesContextButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RulesContextSelectionWizardPage.this
						.openRulesContextSelectionDialog(existentRulesContextText);
			}
		});
		restoreState(existentRulesContextRadio, newRulesContextRadio,
				existentRulesContextText, existentRulesContextButton);
	}

	@Override
	public IWizardPage getNextPage() {
		if (getWizard().isNewRulesContext()) {
			return getWizard().getPage(NewRulesContextFileWizardPage.PAGE_NAME);
		} else {
			return getWizard().getPage(
					TargetProjectsSelectionWizardPage.PAGE_NAME);
		}
	}

	@Override
	public boolean isPageComplete() {
		return getWizard().isNewRulesContext()
				|| getWizard().getRulesContextFile() != null;
	}

	protected void openRulesContextSelectionDialog(
			Text selectionRulesContextText) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(),
				new BaseWorkbenchContentProvider());
		dialog.setTitle("Tree Selection");
		dialog.setMessage("Select the elements from the tree:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.setAllowMultiple(false);
		dialog.setValidator(new ISelectionStatusValidator() {

			@Override
			public IStatus validate(Object[] paramArrayOfObject) {
				final boolean b = paramArrayOfObject.length > 0
						&& paramArrayOfObject[0] instanceof File;
				return new Status(b ? IStatus.OK : IStatus.ERROR,
						JQAEclipsePlugin.PLUGIN_ID, "");
			}
		});
		dialog.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer arg0, Object arg1, Object arg2) {
				if (arg2 instanceof File) {
					return "xml".equals(((File) arg2).getFileExtension()
							.toLowerCase());
				}
				return true;
			}
		});
		dialog.open();
		if (dialog.getResult() != null && dialog.getResult().length > 0) {
			IResource file = (IResource) dialog.getResult()[0];
			getWizard().setRulesContextFile(file);
			selectionRulesContextText.setText(file.getFullPath()
					.toPortableString());
			getContainer().updateButtons();
		}
	}

	private void restoreState(Button existentRulesContextRadio,
			Button newRulesContextRadio, Text existentRulesContextText,
			Button existentRulesContextButton) {

		updateSelection(existentRulesContextRadio, newRulesContextRadio,
				existentRulesContextText, existentRulesContextButton,
				getWizard().isNewRulesContext());

		final IResource rulesContextFile = getWizard().getRulesContextFile();
		if (rulesContextFile != null) {
			existentRulesContextText.setText(rulesContextFile.getFullPath()
					.toPortableString());
		}
	}

	protected void updateSelection(Button existentRulesContextRadio,
			Button newRulesContextRadio, Text existentRulesContextText,
			Button existentRulesContextButton, boolean isNewRulesContext) {
		newRulesContextRadio.setSelection(isNewRulesContext);
		existentRulesContextRadio.setSelection(!isNewRulesContext);
		existentRulesContextText.setEnabled(!isNewRulesContext);
		existentRulesContextButton.setEnabled(!isNewRulesContext);
	}

}
