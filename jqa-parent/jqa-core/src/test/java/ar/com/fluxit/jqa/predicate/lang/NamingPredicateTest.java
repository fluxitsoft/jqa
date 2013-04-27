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
package ar.com.fluxit.jqa.predicate.lang;

import junit.framework.TestCase;

/**
 * TODO javadoc
 * 
 * @author Paul Cantrell
 * @author Juan Ignacio Barisich
 */
public class NamingPredicateTest extends TestCase {

	private NamingPredicate createNamingPredicate(String string) {
		final NamingPredicate result = new NamingPredicate();
		result.setClassNamePattern(string);
		return result;
	}

	public final void testCheck() {
		testMatches(createNamingPredicate("java.lang.*"), new String[] { "java.lang.String" }, new String[] { "java.lang.reflect.Method",
				"java.language.MadeUpClass" });
		testMatches(createNamingPredicate("java.lang.**"), new String[] { "java.lang.String", "java.lang.reflect.Method" },
				new String[] { "java.language.MadeUpClass" });
		testMatches(createNamingPredicate("java.lang**"), new String[] { "java.lang.String", "java.lang.reflect.Method", "java.language.MadeUpClass" },
				new String[0]);
		testMatches(createNamingPredicate("String"), new String[] { "String" }, new String[] { "java.lang.String" });
		testMatches(createNamingPredicate("java.lang.String"), new String[] { "java.lang.String" }, new String[] { "String" });
		testMatches(createNamingPredicate("String"), new String[] { "String" }, new String[] { "java.lang.String", "java.lang.StringBuffer",
				"java.text.AttributedString" });
		testMatches(createNamingPredicate("**String*"), new String[] { "String", "java.lang.String", "java.lang.StringBuffer", "java.text.AttributedString" },
				new String[0]);
		testMatches(createNamingPredicate("**String"), new String[] { "String", "java.lang.String", "java.text.AttributedString" },
				new String[] { "java.lang.StringBuffer" });
		testMatches(createNamingPredicate("**.String*"), new String[] { "String", "java.lang.String", "java.lang.StringBuffer" },
				new String[] { "java.text.AttributedString" });
		testMatches(createNamingPredicate("a.b"), new String[] { "a.b" }, new String[] { "", "a$b" });
		testMatches(createNamingPredicate("**.service.+Service"), new String[] { "ar.com.fluxit.test.service.CarService",
				"ar.com.fluxit.test.old.service.TruckService" }, new String[] { "ar.com.fluxit.test.fmk.service.Service" });
		testMatches(createNamingPredicate("**.service+.+Service"), new String[] { "ar.com.fluxit.test.services.CarService",
				"ar.com.fluxit.test.old.services.TruckService" }, new String[] { "ar.com.fluxit.test.service.CarService",
				"ar.com.fluxit.test.old.service.TruckService", "ar.com.fluxit.test.fmk.service.Service" });
		testMatches(createNamingPredicate("+String"), new String[] { "AString", "TheString" }, new String[] { "String", "StringA" });
		testMatches(createNamingPredicate("**.entities.**"), new String[] { "ar.com.osde.framework.historial.entities.SearchResult" },
				new String[] { "java.io.Serializable" });
	}

	private void testMatches(NamingPredicate predicate, String[] positive, String[] negative) {
		for (final String element : positive) {
			assertTrue("\"" + predicate + "\" should match \"" + element + "\"", predicate.evaluateClassName(element, null));
		}
		for (int n = 0; n < negative.length; n++) {
			assertTrue("\"" + predicate + "\" shouldn't match \"" + negative[n] + "\"", !predicate.evaluateClassName(negative[n], null));
		}
	}

}
