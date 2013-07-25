/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ExceptionA extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionA() {
		super();
	}

	public ExceptionA(String message) {
		super(message);
	}

	public ExceptionA(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionA(Throwable cause) {
		super(cause);
	}

}
