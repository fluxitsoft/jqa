/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.viewer;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
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
