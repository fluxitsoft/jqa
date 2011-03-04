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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.rule;

import java.util.ArrayList;
import java.util.Vector;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.RepositoryLocator;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TypingRuleTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		Repository repository = RepositoryLocator.getRepository();
		// Test class type
		testMatches(new TypingRule("java.lang.Number"),
				new JavaClass[] { repository.lookupClass(Integer.class),
						repository.lookupClass(Long.class) },
				new JavaClass[] { repository.lookupClass(String.class),
						repository.lookupClass(Exception.class) });
		// Test interface type
		testMatches(new TypingRule("java.util.List"),
				new JavaClass[] { repository.lookupClass(ArrayList.class),
						repository.lookupClass(Vector.class) },
				new JavaClass[] { repository.lookupClass(String.class),
						repository.lookupClass(Integer.class) });
	}

	private void testMatches(TypingRule rule, JavaClass[] positive,
			JavaClass[] negative) {
		for (final JavaClass element : positive) {
			assertTrue("\"" + rule + "\" should match \"" + element + "\"",
					rule.evaluateClass(element));
		}
		for (final JavaClass element : negative) {
			assertTrue("\"" + rule + "\" shouldn't match \"" + element + "\"",
					!rule.evaluateClass(element));
		}
	}
}
