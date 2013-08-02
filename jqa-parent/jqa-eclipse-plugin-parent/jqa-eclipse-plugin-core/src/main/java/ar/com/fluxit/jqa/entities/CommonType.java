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

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CommonType {

	private String typeName;
	private boolean common;

	public CommonType(String typeName, boolean common) {
		super();
		this.typeName = typeName;
		this.common = common;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else {
			if (obj instanceof CommonType) {
				return ((CommonType) obj).getTypeName().equals(
						this.getTypeName());
			} else {
				return false;
			}
		}
	}

	public String getTypeName() {
		return typeName;
	}

	@Override
	public int hashCode() {
		return getTypeName().hashCode();
	}

	public boolean isCommon() {
		return common;
	}

	public void setCommon(boolean common) {
		this.common = common;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return typeName;
	}

}