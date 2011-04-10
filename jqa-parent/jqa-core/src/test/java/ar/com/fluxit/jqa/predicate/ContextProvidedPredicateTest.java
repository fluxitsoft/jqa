package ar.com.fluxit.jqa.predicate;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.predicate.logic.FalsePredicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ContextProvidedPredicateTest extends TestCase {

	private RulesContext createContext(Predicate globalPredicate) {
		final RulesContextImpl result = new RulesContextImpl();
		result.addGlobalPredicate(globalPredicate);
		return result;
	}

	public final void testCheck() {
		assertTrue(new ContextProvidedPredicate(TruePredicate.INSTANCE
				.getName()).evaluate(null,
				createContext(TruePredicate.INSTANCE)));
		assertFalse(new ContextProvidedPredicate(FalsePredicate.INSTANCE
				.getName()).evaluate(null,
				createContext(FalsePredicate.INSTANCE)));
	}
}