/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.bce;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TypeFormatException extends Exception {

	private static final long serialVersionUID = -7446697331694653195L;

	public TypeFormatException() {
		super();
	}

	public TypeFormatException(String message) {
		super(message);
	}

	public TypeFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeFormatException(Throwable cause) {
		super(cause);
	}

}
