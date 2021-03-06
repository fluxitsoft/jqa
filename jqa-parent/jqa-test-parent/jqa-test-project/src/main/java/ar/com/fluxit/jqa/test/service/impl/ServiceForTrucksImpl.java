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
package ar.com.fluxit.jqa.test.service.impl;

import ar.com.fluxit.jqa.test.dao.impl.DAOForTrucksImpl;
import ar.com.fluxit.jqa.test.service.ServiceForTrucks;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ServiceForTrucksImpl implements ServiceForTrucks {

	private DAOForTrucksImpl daoForTrucksImpl;

	private void dummy() {
		throw new IllegalArgumentException();
	}

	public void getTrucks() {
		dummy();
		this.daoForTrucksImpl.getTrucks();
	}

}
