package ar.com.fluxit.jqa.predicate;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.RulesContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class IgnoringContextPredicate implements Predicate {

	public IgnoringContextPredicate() {
		super();
	}

	@Override
	public final boolean evaluate(JavaClass clazz, RulesContext context) {
		return evaluate(clazz);
	}

	public abstract boolean evaluate(JavaClass clazz);
}
