package ar.com.fluxit.jqa.predicate;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.RulesContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ContextProvidedPredicate extends AbstractPredicate {

	private String providedPredicateName;

	public ContextProvidedPredicate() {
		super();
	}

	public ContextProvidedPredicate(String providedPredicateName) {
		super();
		this.providedPredicateName = providedPredicateName;
	}

	@Override
	public final boolean evaluate(JavaClass clazz, RulesContext context) {
		final Predicate providedPredicate = context
				.getGlobalPredicate(getProvidedPredicateName());
		return providedPredicate.evaluate(clazz, context);
	}

	public String getProvidedPredicateName() {
		return providedPredicateName;
	}

	public void setProvidedPredicateName(String providedPredicateName) {
		this.providedPredicateName = providedPredicateName;
	}
}
