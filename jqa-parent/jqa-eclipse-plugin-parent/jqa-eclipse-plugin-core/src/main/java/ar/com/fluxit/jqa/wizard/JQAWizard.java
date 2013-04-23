package ar.com.fluxit.jqa.wizard;

import org.eclipse.jface.wizard.Wizard;

import ar.com.fluxit.jqa.wizard.page.SelectRulesContextPage;

public class JQAWizard extends Wizard {

	public void addPages() {
		addPage(new SelectRulesContextPage());
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
