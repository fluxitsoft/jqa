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
package ar.com.fluxit.jqa.test.service;

import java.util.List;

import ar.com.fluxit.jqa.test.domain.vehicles.Boat;
import ar.com.fluxit.jqa.test.fmk.bo.BusinessObjectException;
import ar.com.fluxit.jqa.test.fmk.service.Service;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface BoatService extends Service {

	List<Boat> getBoats() throws BusinessObjectException;

}
