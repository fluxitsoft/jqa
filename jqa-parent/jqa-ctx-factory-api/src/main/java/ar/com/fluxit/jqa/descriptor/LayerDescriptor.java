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
package ar.com.fluxit.jqa.descriptor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayerDescriptor {

	private String name;
	private final Set<String> packages;
	private boolean hasApi;
	private String namingPattern;
	private String superType;
	private String exceptionSuperType;
	private final Set<LayerDescriptor> usages;
	private boolean allocable;

	private Set<CommonDescriptor> commons;

	public LayerDescriptor(String name, boolean hasApi, String namingPattern,
			boolean allocable) {
		this.name = name;
		this.packages = new HashSet<String>();
		this.hasApi = hasApi;
		setNamingPattern(namingPattern);
		this.superType = "java.lang.Object";
		this.exceptionSuperType = "java.lang.Exception";
		this.usages = new HashSet<LayerDescriptor>();
		this.allocable = allocable;
		this.commons = new HashSet<CommonDescriptor>();
	}

	public void addPackages(Collection<String> packages) {
		this.packages.addAll(packages);
	}

	public void addUsage(LayerDescriptor destinationLayer) {
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
			if (obj instanceof LayerDescriptor) {
				return ((LayerDescriptor) obj).getName().equals(this.getName());
			} else {
				return false;
			}
		}
	}

	public Set<CommonDescriptor> getCommons() {
		return commons;
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

	public Set<String> getPackages() {
		return Collections.unmodifiableSet(packages);
	}

	public String getSuperType() {
		return superType;
	}

	public Set<LayerDescriptor> getUsages() {
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

	public void removePackages(Collection<String> packages) {
		this.packages.removeAll(packages);
	}

	public void removeUsage(LayerDescriptor dest) {
		usages.remove(dest);
	}

	public void setAllocable(boolean allocable) {
		this.allocable = allocable;
	}

	public void setCommons(CommonDescriptor... commonTypes) {
		setCommons(new LinkedHashSet<CommonDescriptor>(
				Arrays.asList(commonTypes)));
	}

	public void setCommons(Set<CommonDescriptor> commonTypes) {
		this.commons = commonTypes;
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
		if (namingPattern != null) {
			if (namingPattern.contains("**")) {
				throw new IllegalArgumentException(
						"The naming pattern can not contains '**'");
			}
			if (namingPattern.contains(".")) {
				throw new IllegalArgumentException(
						"The naming pattern can not contains '.'");
			}
		}
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
