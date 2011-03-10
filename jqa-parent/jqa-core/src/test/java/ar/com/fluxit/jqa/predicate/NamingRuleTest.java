/*______________________________________________________________________________
 *
 * Macker   http://innig.net/macker/
 *
 * Copyright 2002 Paul Cantrell
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License version 2, as published by the
 * Free Software Foundation. See the file LICENSE.html for more information.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, including the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the license for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc. / 59 Temple
 * Place, Suite 330 / Boston, MA 02111-1307 / USA.
 *______________________________________________________________________________
 */
package ar.com.fluxit.jqa.predicate;

import ar.com.fluxit.jqa.predicate.NamingPredicate;
import junit.framework.TestCase;

/**
 * TODO javadoc
 * 
 * @author Paul Cantrell
 * @author Juan Ignacio Barisich
 */
public class NamingRuleTest extends TestCase {

	public final void testCheck() {
		testMatches(new NamingPredicate("java.lang.*"),
				new String[] { "java.lang.String" },
				new String[] { "java.lang.reflect.Method",
						"java.language.MadeUpClass" });
		testMatches(new NamingPredicate("java.lang.**"), new String[] {
				"java.lang.String", "java.lang.reflect.Method" },
				new String[] { "java.language.MadeUpClass" });
		testMatches(new NamingPredicate("java.lang**"), new String[] {
				"java.lang.String", "java.lang.reflect.Method",
				"java.language.MadeUpClass" }, new String[0]);
		testMatches(new NamingPredicate("String"), new String[] { "String" },
				new String[] { "java.lang.String" });
		testMatches(new NamingPredicate("java.lang.String"),
				new String[] { "java.lang.String" }, new String[] { "String" });
		testMatches(new NamingPredicate("String"), new String[] { "String" },
				new String[] { "java.lang.String", "java.lang.StringBuffer",
						"java.text.AttributedString" });
		testMatches(new NamingPredicate("**String*"), new String[] { "String",
				"java.lang.String", "java.lang.StringBuffer",
				"java.text.AttributedString" }, new String[0]);
		testMatches(new NamingPredicate("**String"), new String[] { "String",
				"java.lang.String", "java.text.AttributedString" },
				new String[] { "java.lang.StringBuffer" });
		testMatches(new NamingPredicate("**.String*"), new String[] { "String",
				"java.lang.String", "java.lang.StringBuffer" },
				new String[] { "java.text.AttributedString" });
		testMatches(new NamingPredicate("a.b"), new String[] { "a.b", "a$b" },
				new String[] { "" });
	}

	private void testMatches(NamingPredicate rule, String[] positive,
			String[] negative) {
		for (final String element : positive) {
			assertTrue("\"" + rule + "\" should match \"" + element + "\"",
					rule.evaluateClassName(element));
		}
		for (int n = 0; n < negative.length; n++) {
			assertTrue("\"" + rule + "\" shouldn't match \"" + negative[n]
					+ "\"", !rule.evaluateClassName(negative[n]));
		}
	}

}