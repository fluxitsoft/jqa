/*______________________________________________________________________________
 *
 * Macker   http://innig.net/macker/
 *
 * Copyright 2002-2003 Paul Cantrell
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2, as published by the
 * Free Software Foundation. See the file LICENSE.html for more information.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, including the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the license for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc. / 59 Temple
 * Place, Suite 330 / Boston, MA 02111-1307 / USA.
 *______________________________________________________________________________
 */
package ar.com.fluxit.jqa.exception;

/**
 * TODO javadoc
 * 
 * @author Paul Cantrell
 * @author Juan Ignacio Barisich
 */
public class RegExSyntaxException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegExSyntaxException(String string) {
		super(string);
	}

	public RegExSyntaxException(String message, Throwable cause) {
		super(message, cause);
	}

}
