package ar.com.fluxit.jqa.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class NewLayoutAction extends Action {

	public NewLayoutAction() {
		super("New layout", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
	}

	@Override
	public void run() {
		super.run();
	}

}
