/*******************************************************************************
 * Copyright (c) 2011 Flux IT.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersGraphContentProvider extends ArrayContentProvider implements
		IGraphEntityContentProvider {

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Layer) {
			Layer layer = (Layer) entity;
			return layer.getUsages().toArray();
		}
		throw new IllegalArgumentException("Type not supported: "
				+ entity.getClass().getName());
	}

}
