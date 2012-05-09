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
package ar.com.fluxit.jqa.bce.bcel;

import ar.com.fluxit.jqa.bce.Type;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class BcelJavaType implements Type {

	private final org.apache.bcel.classfile.JavaClass wrapped;

	public BcelJavaType(org.apache.bcel.classfile.JavaClass parse) {
		if (parse == null) {
			throw new IllegalArgumentException("Wrapped class can not be null");
		}
		this.wrapped = parse;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BcelJavaType)) {
			return false;
		}
		return ((BcelJavaType) obj).getName().equals(getName());
	}

	@Override
	public String getName() {
		return this.wrapped.getClassName();
	}

	org.apache.bcel.classfile.JavaClass getWrapped() {
		return this.wrapped;
	}

	@Override
	public int hashCode() {
		return this.wrapped.getClassName().hashCode();
	}

	@Override
	public boolean isAbstract() {
		return this.wrapped.isAbstract() && !this.wrapped.isInterface();
	}

	@Override
	public boolean isInterface() {
		return this.wrapped.isInterface();
	}

	@Override
	public String toString() {
		return this.wrapped.getClassName();
	}

}
