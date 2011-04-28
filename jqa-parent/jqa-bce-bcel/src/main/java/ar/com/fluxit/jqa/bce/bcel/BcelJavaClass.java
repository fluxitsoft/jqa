/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
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

import ar.com.fluxit.jqa.bce.JavaClass;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class BcelJavaClass implements JavaClass {

	private final org.apache.bcel.classfile.JavaClass wrapped;

	public BcelJavaClass(org.apache.bcel.classfile.JavaClass parse) {
		if (parse == null) {
			throw new IllegalArgumentException("Wrapped class can not be null");
		}
		wrapped = parse;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BcelJavaClass)) {
			return false;
		}
		return ((BcelJavaClass) obj).getClassName().equals(getClassName());
	}

	@Override
	public String getClassName() {
		return wrapped.getClassName();
	}

	org.apache.bcel.classfile.JavaClass getWrapped() {
		return wrapped;
	}

	@Override
	public int hashCode() {
		return wrapped.getClassName().hashCode();
	}

	@Override
	public boolean isAbstract() {
		return wrapped.isAbstract() && !wrapped.isInterface();
	}

	@Override
	public boolean isInterface() {
		return wrapped.isInterface();
	}

	@Override
	public String toString() {
		return wrapped.toString();
	}

}
