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

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AllTests {

	public static Test suite() {
		final TestSuite suite = new TestSuite("Test for ar.com.fluxit.jqa.context.factory");
		// $JUnit-BEGIN$
		suite.addTestSuite(RulesContextImplTest2.class);
		suite.addTestSuite(RulesContextImplTest3.class);
		suite.addTestSuite(RulesContextImplTest.class);
		// $JUnit-END$
		return suite;
	}

}
