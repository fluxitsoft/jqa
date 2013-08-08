package ar.com.fluxit.jqa.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.viewer.LayerCellModifier;

public class NewLayerAction extends Action {

	private final List<LayerDescriptor> layers;
	private final TableViewer layersTable;

	public NewLayerAction(List<LayerDescriptor> layers, TableViewer layersTable) {
		super("New layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		this.layers = layers;
		this.layersTable = layersTable;
	}

	private List<LayerDescriptor> getLayers() {
		return layers;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	private String getNewLayerName(List<LayerDescriptor> layers) {
		String result = "New Layer";
		if (getLayers().contains(new LayerDescriptor(result, true, "", true))) {
			int i = 0;
			do {
				result = "New Layer " + ++i;
			} while (getLayers().contains(new LayerDescriptor(result, true, "", true)));
		}
		return result;
	}

	@Override
	public void run() {
		final String layerName = getNewLayerName(getLayers());
		final LayerDescriptor newLayer = new LayerDescriptor(layerName, true, "", true);
		getLayers().add(newLayer);
		getLayersTable().refresh(false);
		((LayerCellModifier) getLayersTable().getCellModifier()).doModifiable();
		getLayersTable().setSelection(StructuredSelection.EMPTY);
		getLayersTable().editElement(newLayer, 0);
	}

}
