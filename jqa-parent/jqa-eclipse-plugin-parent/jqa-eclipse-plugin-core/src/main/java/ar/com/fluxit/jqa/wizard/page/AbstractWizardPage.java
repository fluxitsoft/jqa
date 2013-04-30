package ar.com.fluxit.jqa.wizard.page;

import org.eclipse.jface.wizard.WizardPage;

import ar.com.fluxit.jqa.wizard.JQAWizard;

public abstract class AbstractWizardPage extends WizardPage {

	protected AbstractWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public JQAWizard getWizard() {
		return (JQAWizard) super.getWizard();
	}

}
