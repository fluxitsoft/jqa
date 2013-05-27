package ar.com.fluxit.jqa.viewer;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import ar.com.fluxit.jqa.entities.Layer;

public class LayerCellModifier implements ICellModifier {

	private final TableViewer layersTable;
	private boolean canModify;

	public LayerCellModifier(TableViewer layersTable) {
		this.layersTable = layersTable;
		this.canModify = false;
	}

	@Override
	public boolean canModify(Object paramObject, String paramString) {
		boolean result = canModify;
		this.canModify = false;
		return result;
	}

	public void doModifiable() {
		this.canModify = true;
	}

	private TableViewer getLayersTable() {
		return layersTable;
	}

	@Override
	public Object getValue(Object paramObject, String paramString) {
		return paramObject.toString();
	}

	@Override
	public void modify(Object element, String paramString, Object paramObject2) {
		Layer layer = (Layer) ((Item) element).getData();
		layer.setName((String) paramObject2);
		getLayersTable().refresh();
	}

}
