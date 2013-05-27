package ar.com.fluxit.jqa.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.viewer.LayerCellModifier;

public class EditLayerAction extends Action {

	private final TableViewer layersTable;

	public EditLayerAction(TableViewer layersTable) {
		super("Edit layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		this.layersTable = layersTable;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	@Override
	public void run() {
		Object currentLayer = ((StructuredSelection) getLayersTable()
				.getSelection()).getFirstElement();
		((LayerCellModifier) getLayersTable().getCellModifier()).doModifiable();
		getLayersTable().setSelection(StructuredSelection.EMPTY);
		getLayersTable().editElement(currentLayer, 0);
	}

}
