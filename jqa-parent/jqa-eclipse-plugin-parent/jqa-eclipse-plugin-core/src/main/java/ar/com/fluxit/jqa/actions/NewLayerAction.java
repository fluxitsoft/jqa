package ar.com.fluxit.jqa.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.entities.Layer;
import ar.com.fluxit.jqa.viewer.LayerCellModifier;

public class NewLayerAction extends Action {

	private final List<Layer> layers;
	private final TableViewer layersTable;

	public NewLayerAction(List<Layer> layers, TableViewer layersTable) {
		super("New layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		this.layers = layers;
		this.layersTable = layersTable;
	}

	private List<Layer> getLayers() {
		return layers;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	private String getNewLayerName(List<Layer> layers2) {
		String result = "New Layer";
		if (getLayers().contains(new Layer(result))) {
			int i = 0;
			do {
				result = "New Layer " + ++i;
			} while (getLayers().contains(new Layer(result)));
		}
		return result;
	}

	@Override
	public void run() {
		final String layerName = getNewLayerName(getLayers());
		final Layer newLayer = new Layer(layerName);
		getLayers().add(newLayer);
		getLayersTable().refresh(false);
		((LayerCellModifier) getLayersTable().getCellModifier()).doModifiable();
		getLayersTable().setSelection(StructuredSelection.EMPTY);
		getLayersTable().editElement(newLayer, 0);
	}

}
