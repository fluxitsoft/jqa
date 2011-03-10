package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.CheckingContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class CheckingContextIgnoringRule implements Rule {

	public abstract boolean check(JavaClass clazz);

	@Override
	public final boolean check(JavaClass clazz, CheckingContext checkingContext) {
		return check(clazz);
	}

}
