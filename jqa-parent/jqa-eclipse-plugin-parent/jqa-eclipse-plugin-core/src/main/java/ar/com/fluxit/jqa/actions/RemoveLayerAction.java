package ar.com.fluxit.jqa.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.entities.Layer;

public class RemoveLayerAction extends Action {

	private final List<Layer> layers;
	private final TableViewer layersTable;

	public RemoveLayerAction(List<Layer> layers, TableViewer layersTable) {
		super("Remove layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));
		this.layers = layers;
		this.layersTable = layersTable;
	}

	private List<Layer> getLayers() {
		return layers;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	@Override
	public void run() {
		Object currentLayer = ((StructuredSelection) getLayersTable()
				.getSelection()).getFirstElement();
		getLayers().remove(currentLayer);
		getLayersTable().refresh(false);
	}

}
