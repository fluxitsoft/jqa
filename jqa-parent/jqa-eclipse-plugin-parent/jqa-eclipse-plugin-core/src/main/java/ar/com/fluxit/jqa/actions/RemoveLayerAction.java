package ar.com.fluxit.jqa.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

public class RemoveLayerAction extends Action {

	private final List<LayerDescriptor> layers;
	private final TableViewer layersTable;
	private final TableViewer targeyLayersTable;
	private final IWizardContainer wizardContainer;

	public RemoveLayerAction(List<LayerDescriptor> layers,
			TableViewer layersTable, TableViewer targeyLayersTable,
			IWizardContainer wizardContainer) {
		super("Remove layer", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));
		this.layers = layers;
		this.layersTable = layersTable;
		this.targeyLayersTable = targeyLayersTable;
		this.wizardContainer = wizardContainer;
	}

	private List<LayerDescriptor> getLayers() {
		return layers;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	private TableViewer getTargetLayersTable() {
		return targeyLayersTable;
	}

	private IWizardContainer getWizardContainer() {
		return wizardContainer;
	}

	@Override
	public void run() {
		LayerDescriptor currentLayer = (LayerDescriptor) ((StructuredSelection) getLayersTable()
				.getSelection()).getFirstElement();
		getLayers().remove(currentLayer);
		// Remove de conections
		for (LayerDescriptor layer : getLayers()) {
			layer.removeUsage(currentLayer);
		}
		getLayersTable().refresh(false);
		getTargetLayersTable().refresh();
		getWizardContainer().updateButtons();
	}

}