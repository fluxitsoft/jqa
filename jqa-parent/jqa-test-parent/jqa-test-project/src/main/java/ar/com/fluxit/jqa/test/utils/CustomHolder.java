/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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
package ar.com.fluxit.jqa.test.utils;

import java.util.Iterator;

import com.thoughtworks.xstream.converters.DataHolder;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CustomHolder implements DataHolder {

	public CustomHolder() {
		super();
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Iterator<?> keys() {
		return null;
	}

	@Override
	public void put(Object key, Object value) {

	}

}
