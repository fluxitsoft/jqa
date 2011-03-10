package ar.com.fluxit.jqa.bce.bcel;

import ar.com.fluxit.jqa.bce.JavaClass;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BcelJavaClass implements JavaClass {

	private final org.apache.bcel.classfile.JavaClass wrapped;

	public BcelJavaClass(org.apache.bcel.classfile.JavaClass parse) {
		wrapped = parse;
	}

	@Override
	public boolean equals(Object obj) {
		return wrapped.equals(obj);
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
		return wrapped.hashCode();
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

}
