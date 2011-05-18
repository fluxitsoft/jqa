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
package ar.com.fluxit.jqa.predicate.lang;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.Type;
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

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ThrowingPredicateTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final String filterPredicateParentClass = ExceptionA.class.getName();
		// No exceptions
		testMatches(filterPredicateParentClass, ClassA.class, false);
		testMatches(filterPredicateParentClass, ClassThatDoesntThrowsExceptionA.class, false);
		// Checked exceptions
		testMatches(filterPredicateParentClass, ClassThatThrowsExceptionAOnConstructor.class, true);
		testMatches(filterPredicateParentClass, ClassThatThrowsExceptionAOnMethod.class, true);
		testMatches(filterPredicateParentClass, ClassThatThrowsExceptionAOnStaticMethod.class, true);
		// Unchecked exceptions
		final String runtimeExceptionClassName = RuntimeException.class.getName();
		testMatches(runtimeExceptionClassName, ClassThatThrowsUncheckedExceptionOnMethod.class, true);
		testMatches(runtimeExceptionClassName, ClassThatThrowsUncheckedExceptionOnConstructor.class, true);
		testMatches(runtimeExceptionClassName, ClassThatThrowsUncheckedExceptionOnStaticMethod.class, true);
	}

	private void testMatches(String filterPredicateParentClass, Class<?> usagePredicateClass, boolean matches) throws ClassNotFoundException {
		final TypingPredicate filterPredicate = new TypingPredicate();
		filterPredicate.setFilterPredicate(new NamingPredicate(filterPredicateParentClass));
		final Type type = RepositoryLocator.getRepository().lookupType(usagePredicateClass);
		final ThrowingPredicate throwingPredicate = new ThrowingPredicate();
		throwingPredicate.setFilterPredicate(filterPredicate);
		assertEquals(matches, throwingPredicate.evaluate(type, null));
	}
}
