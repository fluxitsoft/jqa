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
import ar.com.fluxit.jqa.mock.usage.ClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticFieldClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticParameterClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithoutClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithParameterClassA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class UsagePredicateTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final String filterPredicateParentClass = ClassA.class.getName();

		// Simple class
		testMatches(filterPredicateParentClass, ClassA.class, true);
		testMatches(filterPredicateParentClass, ClassWithoutClassA.class, false);
		testMatches(filterPredicateParentClass, ClassThatExtendsClassA.class,
				true);
		testMatches(filterPredicateParentClass, ClassWithFieldClassA.class,
				true);
		testMatches(filterPredicateParentClass,
				ClassWithFieldArrayClassA.class, true);
		testMatches(filterPredicateParentClass, ClassWithParameterClassA.class,
				true);
		testMatches(filterPredicateParentClass,
				ClassWithParameterArrayClassA.class, true);
		testMatches(filterPredicateParentClass, ClassThatReturnsClassA.class,
				true);
		testMatches(filterPredicateParentClass,
				ClassThatReturnsArrayClassA.class, true);
		// Inner class
		testMatches(filterPredicateParentClass,
				InnerClassThatExtendsClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassWithFieldClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassWithParameterClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatReturnsClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				InnerClassThatReturnsArrayClassA.B.class, true);
		// Inner static class
		testMatches(filterPredicateParentClass,
				StaticInnerClassThatExtendsClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassWithFieldClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassWithParameterClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassThatReturnsClassA.B.class, true);
		testMatches(filterPredicateParentClass,
				StaticInnerClassThatReturnsArrayClassA.B.class, true);
		// Static methods
		testMatches(filterPredicateParentClass,
				ClassWithStaticFieldClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassWithStaticFieldArrayClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassWithStaticParameterClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassWithStaticParameterArrayClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassThatStaticReturnsClassA.class, true);
		testMatches(filterPredicateParentClass,
				ClassThatStaticReturnsArrayClassA.class, true);
	}

	private void testMatches(String filterPredicateParentClass,
			Class<?> usagePredicateClass, boolean matches)
			throws ClassNotFoundException {
		final TypingPredicate filterPredicate = new TypingPredicate();
		filterPredicate.setParentClassName(filterPredicateParentClass);
		final JavaClass clazz = RepositoryLocator.getRepository().lookupClass(
				usagePredicateClass);
		final UsagePredicate usagePredicate = new UsagePredicate();
		usagePredicate.setFilterPredicate(filterPredicate);
		assertEquals(matches, usagePredicate.evaluate(clazz, null));
	}

}
