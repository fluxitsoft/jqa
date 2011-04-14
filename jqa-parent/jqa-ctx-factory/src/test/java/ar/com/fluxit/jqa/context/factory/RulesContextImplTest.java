package ar.com.fluxit.jqa.context.factory;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.logic.FalsePredicate;
import ar.com.fluxit.jqa.predicate.logic.NotPredicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImplTest extends TestCase {

	public static void testA() throws RulesContextFactoryException {
		RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		URL resource = RulesContextImplTest.class
				.getResource("/sample_rulescontext.xml");
		RulesContext rulesContext = rulesContextFactory
				.getRulesContext(new File(resource.getPath()));
		assertNotNull(rulesContext);
		// TruePredicate
		assertNotNull(rulesContext.getGlobalPredicate("AlwaysTruePredicate"));
		assertTrue(rulesContext.getGlobalPredicate("AlwaysTruePredicate") instanceof TruePredicate);
		// FalsePredicate
		assertNotNull(rulesContext.getGlobalPredicate("AlwaysFalsePredicate"));
		assertTrue(rulesContext.getGlobalPredicate("AlwaysFalsePredicate") instanceof FalsePredicate);
		// NotPredicate
		assertNotNull(rulesContext.getGlobalPredicate("NotPredicateTest"));
		assertTrue(rulesContext.getGlobalPredicate("NotPredicateTest") instanceof NotPredicate);
	}

}
