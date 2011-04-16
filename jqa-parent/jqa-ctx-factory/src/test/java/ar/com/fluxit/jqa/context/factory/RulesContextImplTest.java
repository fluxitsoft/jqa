package ar.com.fluxit.jqa.context.factory;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.ContextProvidedPredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate;
import ar.com.fluxit.jqa.predicate.lang.AllocationPredicate;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;
import ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate;
import ar.com.fluxit.jqa.predicate.lang.TypingPredicate;
import ar.com.fluxit.jqa.predicate.lang.UsagePredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;
import ar.com.fluxit.jqa.predicate.logic.AndPredicate;
import ar.com.fluxit.jqa.predicate.logic.FalsePredicate;
import ar.com.fluxit.jqa.predicate.logic.NotPredicate;
import ar.com.fluxit.jqa.predicate.logic.OrPredicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;
import ar.com.fluxit.jqa.predicate.logic.XorPredicate;
import ar.com.fluxit.jqa.rule.Rule;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImplTest extends TestCase {

	private RulesContext rulesContext;

	private void assertRuleSet(RuleSet ruleSet) {
		assertNotNull(ruleSet);
		assertNotNull(ruleSet.getRules());
		assertEquals(1, ruleSet.getRules().size());
		Rule rule = ruleSet.getRules().iterator().next();
		assertEquals("RuleTest", rule.getName());
		assertTrue(rule.getFilterPredicate() instanceof TruePredicate);
		assertTrue(rule.getCheckPredicate() instanceof TruePredicate);
	}

	private RuleSet getRuleSet(RulesContext rulesContext, String ruleSetName) {
		for (RuleSet ruleSet : rulesContext.getRuleSets()) {
			if (ruleSetName.equals(ruleSet.getName())) {
				return ruleSet;
			}
		}
		return null;
	}

	@Override
	protected void setUp() throws Exception {
		RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		URL resource = RulesContextImplTest.class
				.getResource("/sample_rulescontext.xml");
		rulesContext = rulesContextFactory.getRulesContext(new File(resource
				.getPath()));
	}

	@Override
	protected void tearDown() throws Exception {
		rulesContext = null;
	}

	public void testGetRulesContextGlobalPredicates()
			throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		// AbstractionPredicate
		assertTrue(rulesContext.getGlobalPredicate("AbstractionPredicateTest") instanceof AbstractionPredicate);
		assertTrue(((AbstractionPredicate) rulesContext
				.getGlobalPredicate("AbstractionPredicateTest"))
				.getAbstractionType().equals(AbstractionType.CONCRETE));
		// AllocationPredicate
		assertTrue(rulesContext.getGlobalPredicate("AllocationPredicateTest") instanceof AllocationPredicate);
		assertTrue(((AllocationPredicate) rulesContext
				.getGlobalPredicate("AllocationPredicateTest"))
				.getFilterPredicate() instanceof TruePredicate);
		// AndPredicate
		assertTrue(rulesContext.getGlobalPredicate("AndPredicateTest") instanceof AndPredicate);
		assertEquals(2, ((AndPredicate) rulesContext
				.getGlobalPredicate("AndPredicateTest")).getPredicates().length);
		assertTrue(((AndPredicate) rulesContext
				.getGlobalPredicate("AndPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((AndPredicate) rulesContext
				.getGlobalPredicate("AndPredicateTest")).getPredicates()[1] instanceof TruePredicate);
		// ContextProvidedPredicate
		assertTrue(rulesContext
				.getGlobalPredicate("ContextProvidedPredicateTest") instanceof ContextProvidedPredicate);
		assertEquals("test", ((ContextProvidedPredicate) rulesContext
				.getGlobalPredicate("ContextProvidedPredicateTest"))
				.getProvidedPredicateName());
		// FalsePredicate
		assertTrue(rulesContext.getGlobalPredicate("AlwaysFalsePredicate") instanceof FalsePredicate);
		// NamingPredicate
		assertTrue(rulesContext.getGlobalPredicate("NamingPredicateTest") instanceof NamingPredicate);
		assertEquals("test", ((NamingPredicate) rulesContext
				.getGlobalPredicate("NamingPredicateTest"))
				.getClassNamePattern());
		// NotPredicate
		assertTrue(rulesContext.getGlobalPredicate("NotPredicateTest") instanceof NotPredicate);
		assertTrue(((NotPredicate) rulesContext
				.getGlobalPredicate("NotPredicateTest")).getPredicate() instanceof TruePredicate);
		// OrPredicate
		assertTrue(rulesContext.getGlobalPredicate("OrPredicateTest") instanceof OrPredicate);
		assertEquals(2, ((OrPredicate) rulesContext
				.getGlobalPredicate("OrPredicateTest")).getPredicates().length);
		assertTrue(((OrPredicate) rulesContext
				.getGlobalPredicate("OrPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((OrPredicate) rulesContext
				.getGlobalPredicate("OrPredicateTest")).getPredicates()[1] instanceof TruePredicate);
		// ThrowingPredicate
		assertTrue(rulesContext.getGlobalPredicate("ThrowingPredicateTest") instanceof ThrowingPredicate);
		assertTrue(((ThrowingPredicate) rulesContext
				.getGlobalPredicate("ThrowingPredicateTest"))
				.getFilterPredicate() instanceof TruePredicate);
		// TruePredicate
		assertTrue(rulesContext.getGlobalPredicate("AlwaysTruePredicate") instanceof TruePredicate);
		// TypingPredicate
		assertTrue(rulesContext.getGlobalPredicate("TypingPredicateTest") instanceof TypingPredicate);
		assertEquals("java.lang.Object", ((TypingPredicate) rulesContext
				.getGlobalPredicate("TypingPredicateTest"))
				.getParentClassName());
		// UsagePredicate
		assertTrue(rulesContext.getGlobalPredicate("UsagePredicateTest") instanceof UsagePredicate);
		assertTrue(((UsagePredicate) rulesContext
				.getGlobalPredicate("UsagePredicateTest")).getFilterPredicate() instanceof TruePredicate);
		// XORPredicate
		assertTrue(rulesContext.getGlobalPredicate("XORPredicateTest") instanceof XorPredicate);
		assertEquals(2, ((XorPredicate) rulesContext
				.getGlobalPredicate("XORPredicateTest")).getPredicates().length);
		assertTrue(((XorPredicate) rulesContext
				.getGlobalPredicate("XORPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((XorPredicate) rulesContext
				.getGlobalPredicate("XORPredicateTest")).getPredicates()[1] instanceof TruePredicate);
	}

	public void testGetRulesContextRuleSetImports()
			throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		assertNotNull(rulesContext.getRuleSets());
		assertEquals(2, rulesContext.getRuleSets().size());
		// Ruleset import by file
		RuleSet ruleSet = getRuleSet(rulesContext, "RulesetTestByFileName");
		assertRuleSet(ruleSet);
		// Ruleset import by name
		RuleSet ruleSet2 = getRuleSet(rulesContext, "RulesetTestByName");
		assertRuleSet(ruleSet2);
	}
}
