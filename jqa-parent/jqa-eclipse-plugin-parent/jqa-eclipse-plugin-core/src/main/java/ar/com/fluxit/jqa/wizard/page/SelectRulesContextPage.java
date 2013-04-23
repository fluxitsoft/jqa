package ar.com.fluxit.jqa.wizard.page;

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
