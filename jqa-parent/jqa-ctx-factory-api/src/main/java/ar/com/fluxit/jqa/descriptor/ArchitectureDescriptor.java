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

import java.util.ArrayList;
import java.util.List;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ArchitectureDescriptor {

	private List<LayerDescriptor> layers;
	private String packageImplSuffix;
	private String classImplSuffix;

	public ArchitectureDescriptor() {
		this.layers = buildStandardLayers();
		this.packageImplSuffix = "impl";
		this.classImplSuffix = "Impl";
	}

	private List<LayerDescriptor> buildStandardLayers() {
		List<LayerDescriptor> result = new ArrayList<LayerDescriptor>();
		result.add(new LayerDescriptor("Entity", false, "", true));
		result.add(new LayerDescriptor("Business Object", true, "*BO", false));
		result.add(new LayerDescriptor("Data Access Object", true, "*DAO", false));
		result.add(new LayerDescriptor("Service", true, "*Service", false));
		result.add(new LayerDescriptor("View", false, "", false));
		return result;
	}

	public String getClassImplSuffix() {
		return classImplSuffix;
	}

	public List<LayerDescriptor> getLayers() {
		return layers;
	}

	public String getPackageImplSuffix() {
		return packageImplSuffix;
	}

	public void setClassImplSuffix(String classPackageText) {
		this.classImplSuffix = classPackageText;
	}

	public void setLayers(List<LayerDescriptor> layers) {
		this.layers = layers;
	}

	public void setPackageImplSuffix(String text) {
		this.packageImplSuffix = text;
	}

}
