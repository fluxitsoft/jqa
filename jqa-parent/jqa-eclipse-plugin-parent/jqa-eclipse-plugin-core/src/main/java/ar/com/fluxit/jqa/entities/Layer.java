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
import java.util.Collections;
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

	public static List<Layer> buildStandardLayers() {
		List<Layer> result = new ArrayList<Layer>();
		result.add(new Layer("Entity"));
		result.add(new Layer("Business Object API"));
		result.add(new Layer("Data Access Object API"));
		result.add(new Layer("Service API"));
		result.add(new Layer("View"));
		result.add(new Layer("Business Object Impl"));
		result.add(new Layer("Data Access Object Impl"));
		result.add(new Layer("Service Impl"));
		return result;
	}

	private String name;
	private final Set<IJavaElement> packages;

	public Layer(String name) {
		this.name = name;
		this.packages = new HashSet<IJavaElement>();
	}

	public void addAll(IJavaElement[] datiJavaElements) {
		for (IJavaElement iJavaElement : datiJavaElements) {
			packages.add(iJavaElement);
		}
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
		return Collections.unmodifiableSet(packages);
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public boolean removePackage(String packaje) {
		return packages.remove(packaje);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
