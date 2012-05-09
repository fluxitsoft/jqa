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
package ar.com.fluxit.jqa.test.dao.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import ar.com.fluxit.jqa.test.dao.BoatDAO;
import ar.com.fluxit.jqa.test.domain.vehicles.Boat;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BoatDAOImpl implements BoatDAO {

	@Override
	public List<Boat> getBoats() throws SQLException {
		return Collections.emptyList();
	}

}
