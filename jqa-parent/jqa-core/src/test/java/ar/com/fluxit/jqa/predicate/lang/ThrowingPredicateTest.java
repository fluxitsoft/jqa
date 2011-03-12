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
package ar.com.fluxit.jqa.predicate.lang;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.ExceptionA;
import ar.com.fluxit.jqa.mock.throwing.ClassThatDoesntThrowsExceptionA;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnStaticMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnStaticMethod;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ThrowingPredicateTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final String filterRuleParentClass = ExceptionA.class.getName();
		// No exceptions
		testMatches(filterRuleParentClass, ClassA.class, false);
		testMatches(filterRuleParentClass,
				ClassThatDoesntThrowsExceptionA.class, false);
		// Checked exceptions
		testMatches(filterRuleParentClass,
				ClassThatThrowsExceptionAOnConstructor.class, true);
		testMatches(filterRuleParentClass,
				ClassThatThrowsExceptionAOnMethod.class, true);
		testMatches(filterRuleParentClass,
				ClassThatThrowsExceptionAOnStaticMethod.class, true);
		// Unchecked exceptions
		final String runtimeExceptionClassName = RuntimeException.class
				.getName();
		testMatches(runtimeExceptionClassName,
				ClassThatThrowsUncheckedExceptionOnMethod.class, true);
		testMatches(runtimeExceptionClassName,
				ClassThatThrowsUncheckedExceptionOnConstructor.class, true);
		testMatches(runtimeExceptionClassName,
				ClassThatThrowsUncheckedExceptionOnStaticMethod.class, true);
	}

	private void testMatches(String filterRuleParentClass,
			Class<?> usageRuleclass, boolean matches)
			throws ClassNotFoundException {
		final Predicate filterRule = new TypingPredicate(filterRuleParentClass);
		final JavaClass clazz = RepositoryLocator.getRepository().lookupClass(
				usageRuleclass);
		assertEquals(matches, new ThrowingPredicate(filterRule).evaluate(clazz,
				null));
	}

}
