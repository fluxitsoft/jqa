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
package ar.com.fluxit.jqa.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.IJavaElement;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class Layer {

	private static final Layer EMPTY = new Layer("");

	public static List<Layer> buildStandardLayers() {
		List<Layer> result = new ArrayList<Layer>();
		result.add(new Layer("Entity"));
		result.add(new Layer("Business Object"));
		result.add(new Layer("Data Access Object"));
		result.add(new Layer("Service"));
		result.add(new Layer("View"));
		return result;
	}

	public static Layer emptyLayer() {
		return EMPTY;
	}

	private String name;

	private final Set<IJavaElement> packages;

	private boolean hasApi;

	public Layer(String name) {
		this.name = name;
		this.packages = new HashSet<IJavaElement>();
		this.hasApi = true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else {
			if (obj instanceof Layer) {
				return ((Layer) obj).getName().equals(this.getName());
			} else {
				return false;
			}
		}
	}

	public String getName() {
		return name;
	}

	public Set<IJavaElement> getPackages() {
		return packages;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public boolean isHasApi() {
		return hasApi;
	}

	public void setHasApi(boolean hasApi) {
		this.hasApi = hasApi;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
