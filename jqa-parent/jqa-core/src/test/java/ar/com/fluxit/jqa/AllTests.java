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
package ar.com.fluxit.jqa;

import junit.framework.Test;
import junit.framework.TestSuite;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicateTest;
import ar.com.fluxit.jqa.predicate.lang.AllocationPredicateTest;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicateTest;
import ar.com.fluxit.jqa.predicate.lang.ThrowingPredicateTest;
import ar.com.fluxit.jqa.predicate.lang.TypingPredicateTest;
import ar.com.fluxit.jqa.predicate.lang.UsagePredicateTest;
import ar.com.fluxit.jqa.predicate.logic.AndPredicateTest;
import ar.com.fluxit.jqa.predicate.logic.NotPredicateTest;
import ar.com.fluxit.jqa.predicate.logic.OrPredicateTest;
import ar.com.fluxit.jqa.predicate.logic.XorPredicateTest;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AllTests {

	public static Test suite() {
		final TestSuite suite = new TestSuite(AllTests.class.getName());
		// $JUnit-BEGIN$
		suite.addTestSuite(JQACheckerTest.class);
		suite.addTestSuite(UsagePredicateTest.class);
		suite.addTestSuite(XorPredicateTest.class);
		suite.addTestSuite(OrPredicateTest.class);
		suite.addTestSuite(TypingPredicateTest.class);
		suite.addTestSuite(NamingPredicateTest.class);
		suite.addTestSuite(NotPredicateTest.class);
		suite.addTestSuite(AndPredicateTest.class);
		suite.addTestSuite(AbstractionPredicateTest.class);
		suite.addTestSuite(AllocationPredicateTest.class);
		suite.addTestSuite(ThrowingPredicateTest.class);		
		// $JUnit-END$
		return suite;
	}

}
