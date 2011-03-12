package ar.com.fluxit.jqa.predicate;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.RulesContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ContextProvidedPredicate implements Predicate {

	private String name;

	public ContextProvidedPredicate() {
		super();
	}

	public ContextProvidedPredicate(String name) {
		super();
		this.name = name;
	}

	@Override
	public final boolean evaluate(JavaClass clazz, RulesContext context) {
		final Predicate providedPredicate = context
				.getGlobalPredicate(getName());
		return providedPredicate.evaluate(clazz, context);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
