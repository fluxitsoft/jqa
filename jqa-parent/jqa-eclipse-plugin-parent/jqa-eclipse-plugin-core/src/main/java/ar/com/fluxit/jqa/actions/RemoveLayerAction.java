package ar.com.fluxit.jqa.actions;

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.entities.Layer;

public class RemoveLayerAction extends Action {

	private final List<Layer> layers;
	private final TableViewer layersTable;
	private final TableViewer targeyLayersTable;

	public RemoveLayerAction(List<Layer> layers, TableViewer layersTable,
			TableViewer targeyLayersTable) {
		super("Remove layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));
		this.layers = layers;
		this.layersTable = layersTable;
		this.targeyLayersTable = targeyLayersTable;
	}

	private List<Layer> getLayers() {
		return layers;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	private TableViewer getTargetLayersTable() {
		return targeyLayersTable;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Layer currentLayer = (Layer) ((StructuredSelection) getLayersTable()
				.getSelection()).getFirstElement();
		getLayers().remove(currentLayer);
		getLayersTable().refresh(false);
		((Collection<IJavaElement>) getTargetLayersTable().getInput())
				.addAll(currentLayer.getPackages());
		getTargetLayersTable().refresh(false);
	}

}
