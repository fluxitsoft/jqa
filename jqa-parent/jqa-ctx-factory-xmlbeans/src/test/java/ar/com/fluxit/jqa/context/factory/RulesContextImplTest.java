/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.context.factory;

import java.net.URL;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.ContextProvidedPredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;
import ar.com.fluxit.jqa.predicate.lang.AllocationPredicate;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;
import ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate;
import ar.com.fluxit.jqa.predicate.lang.TypingPredicate;
import ar.com.fluxit.jqa.predicate.lang.UsagePredicate;
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

	private Rule getRule(String ruleName) {
		for (final RuleSet ruleSet : rulesContext.getRuleSets()) {
			for (final Rule rule : ruleSet.getRules()) {
				if (rule.getName().equals(ruleName)) {
					return rule;
				}
			}
		}
		throw new IllegalArgumentException("Can not fin rule with name " + ruleName);
	}

	@Override
	protected void setUp() throws Exception {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator.getRulesContextFactory();
		final URL resource = RulesContextImplTest.class.getResource("/sample_rulescontext.xml");
		rulesContext = rulesContextFactory.getRulesContext(resource.getPath());
	}

	@Override
	protected void tearDown() throws Exception {
		rulesContext = null;
	}

	public void testGlobalPredicates() throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		// AbstractionPredicate
		assertTrue(rulesContext.getGlobalPredicate("AbstractionPredicateTest") instanceof AbstractionPredicate);
		assertTrue(((AbstractionPredicate) rulesContext.getGlobalPredicate("AbstractionPredicateTest")).getAbstractionType().equals(AbstractionType.CONCRETE));
		// AllocationPredicate
		assertTrue(rulesContext.getGlobalPredicate("AllocationPredicateTest") instanceof AllocationPredicate);
		assertTrue(((AllocationPredicate) rulesContext.getGlobalPredicate("AllocationPredicateTest")).getFilterPredicate() instanceof TruePredicate);
		// AndPredicate
		assertTrue(rulesContext.getGlobalPredicate("AndPredicateTest") instanceof AndPredicate);
		assertEquals(2, ((AndPredicate) rulesContext.getGlobalPredicate("AndPredicateTest")).getPredicates().length);
		assertTrue(((AndPredicate) rulesContext.getGlobalPredicate("AndPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((AndPredicate) rulesContext.getGlobalPredicate("AndPredicateTest")).getPredicates()[1] instanceof TruePredicate);
		// ContextProvidedPredicate
		assertTrue(rulesContext.getGlobalPredicate("ContextProvidedPredicateTest") instanceof ContextProvidedPredicate);
		assertEquals("test", ((ContextProvidedPredicate) rulesContext.getGlobalPredicate("ContextProvidedPredicateTest")).getProvidedPredicateName());
		// FalsePredicate
		assertTrue(rulesContext.getGlobalPredicate("AlwaysFalsePredicate") instanceof FalsePredicate);
		// NamingPredicate
		assertTrue(rulesContext.getGlobalPredicate("NamingPredicateTest") instanceof NamingPredicate);
		assertEquals("test", ((NamingPredicate) rulesContext.getGlobalPredicate("NamingPredicateTest")).getClassNamePattern());
		// NotPredicate
		assertTrue(rulesContext.getGlobalPredicate("NotPredicateTest") instanceof NotPredicate);
		assertTrue(((NotPredicate) rulesContext.getGlobalPredicate("NotPredicateTest")).getPredicate() instanceof TruePredicate);
		// OrPredicate
		assertTrue(rulesContext.getGlobalPredicate("OrPredicateTest") instanceof OrPredicate);
		assertEquals(2, ((OrPredicate) rulesContext.getGlobalPredicate("OrPredicateTest")).getPredicates().length);
		assertTrue(((OrPredicate) rulesContext.getGlobalPredicate("OrPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((OrPredicate) rulesContext.getGlobalPredicate("OrPredicateTest")).getPredicates()[1] instanceof TruePredicate);
		// ThrowingPredicate
		assertTrue(rulesContext.getGlobalPredicate("ThrowingPredicateTest") instanceof ThrowingPredicate);
		assertTrue(((ThrowingPredicate) rulesContext.getGlobalPredicate("ThrowingPredicateTest")).getFilterPredicate() instanceof TruePredicate);
		// TruePredicate
		assertTrue(rulesContext.getGlobalPredicate("AlwaysTruePredicate") instanceof TruePredicate);
		// TypingPredicate
		assertTrue(rulesContext.getGlobalPredicate("TypingPredicateTest") instanceof TypingPredicate);
		final TypingPredicate typingPredicate = (TypingPredicate) rulesContext.getGlobalPredicate("TypingPredicateTest");
		assertTrue(typingPredicate.getFilterPredicate() instanceof NamingPredicate);
		final NamingPredicate namingPredicate = (NamingPredicate) typingPredicate.getFilterPredicate();
		assertEquals("java.lang.Object", namingPredicate.getClassNamePattern());
		// UsagePredicate
		assertTrue(rulesContext.getGlobalPredicate("UsagePredicateTest") instanceof UsagePredicate);
		assertTrue(((UsagePredicate) rulesContext.getGlobalPredicate("UsagePredicateTest")).getFilterPredicate() instanceof TruePredicate);
		// XORPredicate
		assertTrue(rulesContext.getGlobalPredicate("XORPredicateTest") instanceof XorPredicate);
		assertEquals(2, ((XorPredicate) rulesContext.getGlobalPredicate("XORPredicateTest")).getPredicates().length);
		assertTrue(((XorPredicate) rulesContext.getGlobalPredicate("XORPredicateTest")).getPredicates()[0] instanceof TruePredicate);
		assertTrue(((XorPredicate) rulesContext.getGlobalPredicate("XORPredicateTest")).getPredicates()[1] instanceof TruePredicate);
	}

	public void testInvalidRulesContextFile() throws RulesContextFactoryException {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator.getRulesContextFactory();
		final URL resource = RulesContextImplTest.class.getResource("/invalid_rulescontext.xml");
		try {
			rulesContextFactory.getRulesContext(resource.getPath());
			fail("Must throw an RulesContextFactoryException");
		} catch (final RulesContextFactoryException e) {
			// OK
		}
	}

	public void testRuleBidirectionalCheck() throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		assertTrue(getRule("BidirectionalCheckRule").getBidirectionalCheck());
		assertFalse(getRule("RuleTest").getBidirectionalCheck());
	}

	public void testRulePriority() throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		final Rule rule = getRule("PriorityCheckRule");
		assertEquals(3, rule.getPriority());
	}

}
