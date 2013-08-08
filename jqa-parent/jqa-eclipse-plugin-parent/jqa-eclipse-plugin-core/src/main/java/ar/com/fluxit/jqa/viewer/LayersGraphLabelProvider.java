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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IConnectionStyleProvider;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersGraphLabelProvider extends LabelProvider implements
		IConnectionStyleProvider, IEntityStyleProvider {

	private static final String USES = "uses";

	@Override
	public boolean fisheyeNode(Object entity) {
		return false;
	}

	@Override
	public Color getBackgroundColour(Object entity) {
		return null;
	}

	@Override
	public Color getBorderColor(Object entity) {
		return null;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	@Override
	public int getBorderWidth(Object entity) {
		return 0;
	}

	@Override
	public Color getColor(Object rel) {
		return null;
	}

	@Override
	public int getConnectionStyle(Object rel) {
		return SWT.NONE;
	}

	@Override
	public Color getForegroundColour(Object entity) {
		return null;
	}

	@Override
	public Color getHighlightColor(Object rel) {
		return null;
	}

	@Override
	public int getLineWidth(Object rel) {
		return 0;
	}

	@Override
	public Color getNodeHighlightColor(Object entity) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof LayerDescriptor) {
			LayerDescriptor layer = (LayerDescriptor) element;
			return layer.getName();
		} else if (element instanceof EntityConnectionData) {
			return USES;
		}
		throw new IllegalArgumentException("Type not supported: "
				+ element.getClass().getName());
	}

	@Override
	public IFigure getTooltip(Object element) {
		String msg;
		if (element instanceof LayerDescriptor) {
			msg = "Press Ctrl+Click to draw connections";
		} else if (element instanceof EntityConnectionData) {
			msg = "Click this connection to delete it";
		} else {
			throw new IllegalArgumentException("Type not supported: "
					+ element.getClass().getName());
		}
		return new Label(msg);
	}

}
