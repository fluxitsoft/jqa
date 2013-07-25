/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.context.factory;

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
		rulesContext = rulesContextFactory.getRulesContext(resource.getPath());
	}

	@Override
	protected void tearDown() throws Exception {
		rulesContext = null;
	}

	public void testRulesContextImports() throws RulesContextFactoryException {
		assertNotNull(rulesContext);
		assertNotNull(rulesContext.getGlobalPredicates());
		assertEquals(1, rulesContext.getGlobalPredicates().size());
		// RulesContext import by file
		assertNotNull(rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextFileName"));
		assertTrue(rulesContext.getGlobalPredicate("GlobalPredicateImportedByRulesContextFileName") instanceof NamingPredicate);
	}
}
