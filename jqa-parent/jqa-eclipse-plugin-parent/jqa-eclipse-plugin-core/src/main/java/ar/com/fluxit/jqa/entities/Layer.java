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

	private static final Layer EMPTY = new Layer("", true, "");

	public static List<Layer> buildStandardLayers() {
		List<Layer> result = new ArrayList<Layer>();
		result.add(new Layer("Entity", false, ""));
		result.add(new Layer("Business Object", true, "*BO"));
		result.add(new Layer("Data Access Object", true, "*DAO"));
		result.add(new Layer("Service", true, "*Service"));
		result.add(new Layer("View", false, ""));
		return result;
	}

	public static Layer emptyLayer() {
		return EMPTY;
	}

	private String name;
	private final Set<IJavaElement> packages;
	private boolean hasApi;
	private String namingPattern;
	private String superType;

	public Layer(String name, boolean hasApi, String namingPattern) {
		this.name = name;
		this.packages = new HashSet<IJavaElement>();
		this.hasApi = hasApi;
		this.namingPattern = namingPattern;
		this.superType = "java.lang.Object";
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

	public String getNamingPattern() {
		return namingPattern;
	}

	public Set<IJavaElement> getPackages() {
		return packages;
	}

	public String getSuperType() {
		return superType;
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

	public void setNamingPattern(String namingPattern) {
		this.namingPattern = namingPattern;
	}

	public void setSuperType(String superType) {
		this.superType = superType;
	}

	@Override
	public String toString() {
		return name;
	}

}
