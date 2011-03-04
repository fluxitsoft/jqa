package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.context.CheckingContext;

import ar.com.fluxit.jqa.bce.JavaClass;

public abstract class CheckingContextIgnoringRule implements Rule {

	@Override
	public final boolean check(JavaClass clazz, CheckingContext checkingContext) {
		return check(clazz);
	}

	public abstract boolean check(JavaClass clazz);

}
