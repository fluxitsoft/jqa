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
		if(parse == null) {
			throw new IllegalArgumentException("Wrapped class can not be null");
		}
		wrapped = parse;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof BcelJavaClass))
			return false;
		return ((BcelJavaClass) obj).getClassName().equals(this.getClassName());
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
