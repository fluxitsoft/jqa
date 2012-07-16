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

import org.apache.bcel.classfile.JavaClass;

import ar.com.fluxit.jqa.bce.Type;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class BcelJavaType implements Type {

	private static final String VOID = "void";

	static BcelJavaType create(org.apache.bcel.classfile.JavaClass javaClass) {
		return new BcelJavaType(javaClass);
	}

	static BcelJavaType create(org.apache.bcel.generic.Type type) {
		String className = TypeNameTranslator.getClassName(type);
		return className.equals(VOID) ? null : BcelJavaType.create(className);
	}

	static BcelJavaType create(String className) {
		if (className == null) {
			throw new IllegalArgumentException("ClassName can not be null");
		}
		JavaClass c;
		if (className.equals(VOID)) {
			return null;
		} else if ((c = TypeNameTranslator.getPrimitive(className)) != null) {
			return new BcelJavaType(c);
		} else {
			try {
				return new BcelJavaType(org.apache.bcel.Repository.lookupClass(className));
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Can not find class " + className, e);
			}
		}
	}

	private final org.apache.bcel.classfile.JavaClass wrapped;

	private BcelJavaType(org.apache.bcel.classfile.JavaClass javaClass) {
		if (javaClass == null) {
			throw new IllegalArgumentException("Wrapped class can not be null");
		}
		this.wrapped = javaClass;
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

	@Override
	public String getPackage() {
		return this.wrapped.getPackageName();
	}

	@Override
	public String getShortName() {
		return getName().substring(getName().lastIndexOf(".") + 1);
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
	public boolean isAnonymous() {
		return getName().matches(".*\\$\\d+");
	}

	@Override
	public boolean isInner() {
		return getName().contains("$");
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
