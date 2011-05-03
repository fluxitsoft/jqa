/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
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

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImplTest2 extends TestCase {

	private RulesContext rulesContext;

	@Override
	protected void setUp() throws Exception {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator.getRulesContextFactory();
		final URL resource = RulesContextImplTest2.class.getResource("/sample_rulescontext2.xml");
		this.rulesContext = rulesContextFactory.getRulesContext(new File(resource.getPath()));
	}

	@Override
	protected void tearDown() throws Exception {
		this.rulesContext = null;
	}

	public void testRulesContextImports() throws RulesContextFactoryException {
		assertNotNull(this.rulesContext);
		assertNotNull(this.rulesContext.getGlobalPredicates());
		assertEquals(2, this.rulesContext.getGlobalPredicates().size());
		// RulesContext import by file
		assertNotNull(this.rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextFileName"));
		assertTrue(this.rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextFileName") instanceof NamingPredicate);
		// Ruleset import by name
		assertNotNull(this.rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextName"));
		assertTrue(this.rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextName") instanceof NamingPredicate);
	}
}
