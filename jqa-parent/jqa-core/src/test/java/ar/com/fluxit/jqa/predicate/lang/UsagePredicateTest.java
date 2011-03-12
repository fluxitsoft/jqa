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
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class UsagePredicateTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final String filterRuleParentClass = ClassA.class.getName();

		// Simple class
		testMatches(filterRuleParentClass, ClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithoutClassA.class, false);
		testMatches(filterRuleParentClass, ClassThatExtendsClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithFieldClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithFieldArrayClassA.class,
				true);
		testMatches(filterRuleParentClass, ClassWithParameterClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithParameterArrayClassA.class,
				true);
		testMatches(filterRuleParentClass, ClassThatReturnsClassA.class, true);
		testMatches(filterRuleParentClass, ClassThatReturnsArrayClassA.class,
				true);
		// Inner class
		testMatches(filterRuleParentClass, InnerClassThatExtendsClassA.B.class,
				true);
		testMatches(filterRuleParentClass, InnerClassWithFieldClassA.B.class,
				true);
		testMatches(filterRuleParentClass,
				InnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterRuleParentClass,
				InnerClassWithParameterClassA.B.class, true);
		testMatches(filterRuleParentClass,
				InnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterRuleParentClass, InnerClassThatReturnsClassA.B.class,
				true);
		testMatches(filterRuleParentClass,
				InnerClassThatReturnsArrayClassA.B.class, true);
		// Inner static class
		testMatches(filterRuleParentClass,
				StaticInnerClassThatExtendsClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassWithFieldClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassWithParameterClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassThatReturnsClassA.B.class, true);
		testMatches(filterRuleParentClass,
				StaticInnerClassThatReturnsArrayClassA.B.class, true);
		// Static methods
		testMatches(filterRuleParentClass, ClassWithStaticFieldClassA.class,
				true);
		testMatches(filterRuleParentClass,
				ClassWithStaticFieldArrayClassA.class, true);
		testMatches(filterRuleParentClass,
				ClassWithStaticParameterClassA.class, true);
		testMatches(filterRuleParentClass,
				ClassWithStaticParameterArrayClassA.class, true);
		testMatches(filterRuleParentClass, ClassThatStaticReturnsClassA.class,
				true);
		testMatches(filterRuleParentClass,
				ClassThatStaticReturnsArrayClassA.class, true);
	}

	private void testMatches(String filterRuleParentClass,
			Class<?> usageRuleclass, boolean matches)
			throws ClassNotFoundException {
		final Predicate filterRule = new TypingPredicate(filterRuleParentClass);
		final JavaClass clazz = RepositoryLocator.getRepository().lookupClass(
				usageRuleclass);
		assertEquals(matches, new UsagePredicate(filterRule).evaluate(clazz,
				null));
	}

}
