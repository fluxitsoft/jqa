package ar.com.fluxit.jqa.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.wizard.JQAWizard;

public class JQAHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		WizardDialog dialog = new WizardDialog(shell, new JQAWizard());
		dialog.open();
		return null;
	}
	
}
