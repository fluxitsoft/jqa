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

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassF {

	public <C, D> D foo(C clazz, Class<D> object) {
		return null;
	}

	public <E, T> Class<T> foo2(Class<E> result, Class<T> clazz) {
		return null;
	}

	List<ClassA> foo3(Map<String, Map<String, List<ClassA>>> a)
			throws ExceptionB {
		return null;
	}

	List<ClassA> foo4(String a, boolean b, Map<String, List<List<ClassA>>> c,
			Date d, ClassB e, List<ClassA> f) throws ExceptionB {
		return null;
	}

}
