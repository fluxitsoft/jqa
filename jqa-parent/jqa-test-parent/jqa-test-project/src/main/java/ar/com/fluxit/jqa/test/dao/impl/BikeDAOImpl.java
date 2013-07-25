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
package ar.com.fluxit.jqa.test.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ar.com.fluxit.jqa.test.dao.BikeDAO;
import ar.com.fluxit.jqa.test.entity.vehicles.Bike;
import ar.com.fluxit.jqa.test.fmk.dao.DataAccessObjectException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BikeDAOImpl implements BikeDAO {

	private DataSource dataSource;

	@Override
	public List<Bike> getBikes() throws DataAccessObjectException {
		List<Bike> result = new ArrayList<Bike>();
		try {
			ResultSet executeQuery = this.dataSource.getConnection().createStatement().executeQuery("SELECT * FROM BIKE");
			while (executeQuery.next()) {
				result.add(new Bike());
			}
			return result;
		} catch (SQLException e) {
			throw new DataAccessObjectException(e);
		}
	}

}
