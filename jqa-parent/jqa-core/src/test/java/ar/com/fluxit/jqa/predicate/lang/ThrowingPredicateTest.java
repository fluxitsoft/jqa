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
package ar.com.fluxit.jqa.predicate.lang;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.ClassE;
import ar.com.fluxit.jqa.mock.ClassG;
import ar.com.fluxit.jqa.mock.ExceptionA;
import ar.com.fluxit.jqa.mock.ExceptionB;
import ar.com.fluxit.jqa.mock.throwing.ClassThatDoesNotThrowsExceptionA;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionAOnStaticMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsExceptionB;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassThatThrowsUncheckedExceptionOnStaticMethod;
import ar.com.fluxit.jqa.mock.throwing.ClassWithFinallyBlock;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsExceptionAOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsExceptionAOnMethod;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsExceptionAOnStaticMethod;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsUncheckedExceptionOnConstructor;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsUncheckedExceptionOnMethod;
import ar.com.fluxit.jqa.mock.throwing.InnerClassThatThrowsUncheckedExceptionOnStaticMethod;
import ar.com.fluxit.jqa.mock.throwing.InnerClassWithFinallyBlock;
import ar.com.fluxit.jqa.mock.throwing.InterfaceThatThrowsExceptionA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ThrowingPredicateTest extends TestCase {

	public ThrowingPredicateTest() {
		BCERepositoryLocator.init(null, "1.5", null);
	}

	public void testBugOnPrimitiveType() throws ClassNotFoundException {
		testMatches(ExceptionA.class.getName(), ClassG.class, true);
	}

	public void testBugOnSyntheticMethod() throws ClassNotFoundException {
		testMatches(ExceptionA.class.getName(), ClassE.class, true);
		testMatches(ExceptionB.class.getName(), ClassE.class, false);
	}

	public final void testCheck() throws ClassNotFoundException {
		final String filterPredicateParentClass = ExceptionB.class.getName();
		// No exceptions
		testMatches(filterPredicateParentClass, ClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassThatDoesNotThrowsExceptionA.class, true);
		testMatches(filterPredicateParentClass,
				ClassThatThrowsExceptionB.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnConstructor.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnMethod.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnStaticMethod.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassWithFinallyBlock.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnMethod.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnConstructor.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnStaticMethod.class,
				true);

		// Checked exceptions
		testMatches(filterPredicateParentClass,
				ClassThatThrowsExceptionAOnConstructor.class, false);
		testMatches(filterPredicateParentClass,
				ClassThatThrowsExceptionAOnMethod.class, false);
		testMatches(filterPredicateParentClass,
				ClassThatThrowsExceptionAOnStaticMethod.class, false);
		testMatches(filterPredicateParentClass,
				InterfaceThatThrowsExceptionA.class, false);
		testMatches(filterPredicateParentClass, ClassWithFinallyBlock.class,
				false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnConstructor.B.class, false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnMethod.B.class, false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsExceptionAOnStaticMethod.B.class, false);
		testMatches(filterPredicateParentClass,
				InnerClassWithFinallyBlock.B.class, false);
		// Unchecked exceptions
		testMatches(filterPredicateParentClass,
				ClassThatThrowsUncheckedExceptionOnMethod.class, false);
		testMatches(filterPredicateParentClass,
				ClassThatThrowsUncheckedExceptionOnConstructor.class, false);
		testMatches(filterPredicateParentClass,
				ClassThatThrowsUncheckedExceptionOnStaticMethod.class, false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnMethod.B.class, false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnConstructor.B.class,
				false);
		testMatches(filterPredicateParentClass,
				InnerClassThatThrowsUncheckedExceptionOnStaticMethod.B.class,
				false);
	}

	private void testMatches(String filterPredicateParentClass,
			Class<?> usagePredicateClass, boolean matches)
			throws ClassNotFoundException {
		final TypingPredicate filterPredicate = new TypingPredicate();
		filterPredicate.setFilterPredicate(new NamingPredicate(
				filterPredicateParentClass));
		final Type type = BCERepositoryLocator.getRepository().lookupType(
				usagePredicateClass);
		final ThrowingPredicate throwingPredicate = new ThrowingPredicate();
		throwingPredicate.setFilterPredicate(filterPredicate);
		assertEquals(matches, throwingPredicate.evaluate(type, null));
	}
}
