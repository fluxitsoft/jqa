package ar.com.fluxit.jqa.bce.bcel;

import ar.com.fluxit.jqa.bce.JavaClass;

public class BcelJavaClass implements JavaClass {

	private org.apache.bcel.classfile.JavaClass wrapped;

	org.apache.bcel.classfile.JavaClass getWrapped() {
		return wrapped;
	}

	public BcelJavaClass(org.apache.bcel.classfile.JavaClass parse) {
		this.wrapped = parse;
	}

	@Override
	public String getClassName() {
		return wrapped.getClassName();
	}

	@Override
	public boolean isAbstract() {
		return wrapped.isAbstract();
	}

	@Override
	public boolean isInterface() {
		return wrapped.isInterface();
	}

	@Override
	public String toString() {
		return wrapped.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return wrapped.equals(obj);
	}

	@Override
	public int hashCode() {
		return wrapped.hashCode();
	}

}
