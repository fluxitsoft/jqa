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

	private static final Layer EMPTY = new Layer("", true, "", true);

	public static List<Layer> buildStandardLayers() {
		List<Layer> result = new ArrayList<Layer>();
		result.add(new Layer("Entity", false, "", true));
		result.add(new Layer("Business Object", true, "*BO", false));
		result.add(new Layer("Data Access Object", true, "*DAO", false));
		result.add(new Layer("Service", true, "*Service", false));
		result.add(new Layer("View", false, "", false));
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
	private String exceptionSuperType;
	private final Set<Layer> usages;
	private boolean allocable;
	private List<CommonType> commonTypes;

	public Layer(String name, boolean hasApi, String namingPattern,
			boolean allocable) {
		this.name = name;
		this.packages = new HashSet<IJavaElement>();
		this.hasApi = hasApi;
		this.namingPattern = namingPattern;
		this.superType = "java.lang.Object";
		this.exceptionSuperType = "java.lang.Exception";
		this.usages = new HashSet<Layer>();
		this.allocable = allocable;
		this.commonTypes = new ArrayList<CommonType>();
		// FIXME borrar
		this.commonTypes.add(new CommonType("hola", true, this));
		this.commonTypes.add(new CommonType("chau", false, this));
	}

	public void addUsage(Layer destinationLayer) {
		destinationLayer.removeUsage(this);
		usages.add(destinationLayer);
	}

	public void clearUsages() {
		usages.clear();
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

	public List<CommonType> getCommonTypes() {
		return commonTypes;
	}

	public String getExceptionSuperType() {
		return exceptionSuperType;
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

	public Set<Layer> getUsages() {
		return Collections.unmodifiableSet(usages);
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public boolean isAllocable() {
		return allocable;
	}

	public boolean isHasApi() {
		return hasApi;
	}

	public void removeUsage(Layer dest) {
		usages.remove(dest);
	}

	public void setAllocable(boolean allocable) {
		this.allocable = allocable;
	}

	public void setCommonTypes(List<CommonType> commonTypes) {
		this.commonTypes = commonTypes;
	}

	public void setExceptionSuperType(String exceptionSuperType) {
		this.exceptionSuperType = exceptionSuperType;
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
