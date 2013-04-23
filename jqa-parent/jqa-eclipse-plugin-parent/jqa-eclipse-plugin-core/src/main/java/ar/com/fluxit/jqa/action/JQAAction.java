package ar.com.fluxit.jqa.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import ar.com.fluxit.jqa.wizard.JQAWizard;

public class JQAAction implements IObjectActionDelegate {

	private IWorkbenchPart activeWorkbenchPart;

	@Override
	public void run(IAction arg0) {
		WizardDialog dialog = new WizardDialog(activeWorkbenchPart.getSite()
				.getShell(), new JQAWizard());
		dialog.open();
	}

	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
		// do nothing
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart workbenchPart) {
		this.activeWorkbenchPart = workbenchPart;
	}

}
