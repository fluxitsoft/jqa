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

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.context.CheckingContext;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.MockCheckingContext;
import ar.com.fluxit.jqa.mock.allocation.ClassThatAllocatesClassA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AllocationRuleTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final String filterRuleParentClass = ClassA.class.getName();

		testMatches(filterRuleParentClass, ClassA.class, false);
		testMatches(filterRuleParentClass, ClassThatAllocatesClassA.class, true);
	}

	private CheckingContext checkingContext;

	private CheckingContext getCheckingContext() {
		return checkingContext;
	}

	@Override
	protected void tearDown() throws Exception {
		this.checkingContext = null;
	}

	@Override
	protected void setUp() throws Exception {
		this.checkingContext = new MockCheckingContext();
	}

	private void testMatches(String filterRuleParentClass,
			Class<?> usageRuleclass, boolean matches)
			throws ClassNotFoundException {
		final Rule filterRule = new TypingRule(filterRuleParentClass);
		final JavaClass clazz = RepositoryLocator.getRepository().lookupClass(
				usageRuleclass);
		assertEquals(matches, new AllocationRule(filterRule).check(clazz,
				getCheckingContext()));
	}

}
