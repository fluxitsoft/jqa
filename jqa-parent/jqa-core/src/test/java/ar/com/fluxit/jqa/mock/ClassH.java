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
package ar.com.fluxit.jqa.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class ClassH<I extends ClassA, D extends ClassB, S extends Map<I, D>>
		extends HashMap<I, D> implements InterfaceC<D> {

	private static final long serialVersionUID = -8478568679512298907L;

	private I field;

	public ClassA foo(ar.com.fluxit.jqa.mock.ClassA param) {
		return null;
	}

	public void foo(Map<String, String[]> params) {

	}

	public void foo(String key) {

	}

	public void foo(String key, String params) {

	}

	public void foo(String key, String[] params) {

	}

	public void foo(String[] param, String param2, Map<String, ClassA> param3) {

	}

	public void foo(String[] param, String param2, Map<String, ClassA> param3,
			Map<String, ClassB> param4) {

	}

	public void foo2(Map<String, List<I>> results) {

	}

	public I getField() {
		return field;
	}

	public void setField(I field) {
		this.field = field;
	}

}
