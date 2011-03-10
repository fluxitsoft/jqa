package ar.com.fluxit.jqa.predicate;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.CheckingContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class CheckingContextIgnoringPredicate implements Predicate {

	public abstract boolean check(JavaClass clazz);

	@Override
	public final boolean evaluate(JavaClass clazz, CheckingContext checkingContext) {
		return check(clazz);
	}

}
