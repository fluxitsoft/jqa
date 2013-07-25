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
package ar.com.fluxit.jqa.test.view.actions;

import java.util.List;

import ar.com.fluxit.jqa.test.dao.CarDAO;
import ar.com.fluxit.jqa.test.entities.vehicles.Car;
import ar.com.fluxit.jqa.test.fmk.view.View;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CarAction implements View {

	public static CarAction instance = new CarAction();

	private CarDAO carDAO;
	private List<Car> cars;

	public String listCars() {
		this.cars.clear();
		this.cars = this.carDAO.getCars();
		return "SUCESS";
	}

}
