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
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImplTest3 extends TestCase {

	public void testInvalidRulesContextImportByName() {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator.getRulesContextFactory();
		final URL resource = RulesContextImplTest3.class.getResource("/invalid_rulesContext_import.xml");
		try {
			rulesContextFactory.getRulesContext(new File(resource.getPath()));
			fail("RulesContextFactoryException expected");
		} catch (RulesContextFactoryException e) {
			assertEquals("RulesContext import is invalid. Inexistent RulesContext with name: inexistent", e.getMessage());
		}
	}

	public void testInvalidRuleSetImportByName() {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator.getRulesContextFactory();
		final URL resource = RulesContextImplTest3.class.getResource("/invalid_ruleSet_import.xml");
		try {
			rulesContextFactory.getRulesContext(new File(resource.getPath()));
			fail("RulesContextFactoryException expected");
		} catch (RulesContextFactoryException e) {
			assertEquals("RulesSet import is invalid. Inexistent RuleSet with name: inexistent", e.getMessage());
		}
	}
}
