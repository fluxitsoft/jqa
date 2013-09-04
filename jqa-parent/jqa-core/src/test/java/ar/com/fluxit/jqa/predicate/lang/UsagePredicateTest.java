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

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.ClassB;
import ar.com.fluxit.jqa.mock.ClassC;
import ar.com.fluxit.jqa.mock.ClassF;
import ar.com.fluxit.jqa.mock.ClassH;
import ar.com.fluxit.jqa.mock.InterfaceA;
import ar.com.fluxit.jqa.mock.usage.ClassThatDeclaresExceptionA;
import ar.com.fluxit.jqa.mock.usage.ClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatExtendsList;
import ar.com.fluxit.jqa.mock.usage.ClassThatExtendsListOfClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatImplementsInterfaceA;
import ar.com.fluxit.jqa.mock.usage.ClassThatInvokesArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatInvokesClassThatInvokesArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatInvokesClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticInvokesClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatStaticReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.ClassThatThrowsExceptionA;
import ar.com.fluxit.jqa.mock.usage.ClassWithClassB;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldInterfaceA;
import ar.com.fluxit.jqa.mock.usage.ClassWithFieldList;
import ar.com.fluxit.jqa.mock.usage.ClassWithGenericClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithPrimitiveTypes;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticFieldClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithStaticParameterClassA;
import ar.com.fluxit.jqa.mock.usage.ClassWithoutClassA;
import ar.com.fluxit.jqa.mock.usage.GenericClassA;
import ar.com.fluxit.jqa.mock.usage.GenericClassB;
import ar.com.fluxit.jqa.mock.usage.GenericClassC;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatInvokesClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.InnerClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.usage.InterfaceThatDeclaresExceptionA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatInvokesClassThatInvokesClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.usage.StaticInnerClassWithParameterClassA;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.predicate.logic.OrPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class UsagePredicateTest extends TestCase {

	public UsagePredicateTest() {
		BCERepositoryLocator.init(null, "1.5", null);
	}

	public void testBugClassNotFound() throws ClassNotFoundException {
		final Type type = BCERepositoryLocator.getRepository().lookupType(
				ClassH.class);
		final UsagePredicate usagePredicate = new UsagePredicate();
		usagePredicate.setFilterPredicate(new OrPredicate(new NamingPredicate(
				"java.util.HashMap"), new NamingPredicate("java.util.Map"),
				new NamingPredicate("ar.com.fluxit.jqa.mock.ClassA"),
				new NamingPredicate("ar.com.fluxit.jqa.mock.ClassB"),
				new NamingPredicate("ar.com.fluxit.jqa.mock.InterfaceC"),
				new NamingPredicate("long"), new NamingPredicate(
						"java.lang.Object"), new NamingPredicate(
						"java.lang.String")));
		assertTrue(usagePredicate.evaluate(type, null));
	}

	public void testBugMethodNotFound() throws ClassNotFoundException {
		final Type type = BCERepositoryLocator.getRepository().lookupType(
				ClassF.class);
		final UsagePredicate usagePredicate = new UsagePredicate();
		usagePredicate.setFilterPredicate(new OrPredicate(new NamingPredicate(
				"java.lang.Class"), new NamingPredicate("java.lang.Object")));
		assertTrue(usagePredicate.evaluate(type, null));
	}

	public final void testCheck() throws ClassNotFoundException {
		// Simple class
		testMatches(ClassB.class.getName(), ClassA.class, true);
		testMatches(ClassB.class.getName(), ClassWithoutClassA.class, true);
		testMatches(ClassB.class.getName(), ClassC.class, true);
		testMatches(ClassB.class.getName(), ClassB.class, false);
		testMatches(ClassB.class.getName(), ClassWithClassB.class, true);
		testMatches(ClassB.class.getName(), ClassThatExtendsClassA.class, false);
		testMatches(ClassB.class.getName(), ClassWithFieldClassA.class, false);
		testMatches(ClassB.class.getName(), ClassWithFieldArrayClassA.class,
				false);
		testMatches(ClassB.class.getName(), ClassWithParameterClassA.class,
				false);
		testMatches(ClassB.class.getName(),
				ClassWithParameterArrayClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatReturnsClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatReturnsArrayClassA.class,
				false);
		testMatches(ClassB.class.getName(), ClassThatInvokesClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatInvokesArrayClassA.class,
				false);
		testMatches(ClassB.class.getName(),
				ClassThatInvokesClassThatInvokesClassA.class, false);
		testMatches(ClassB.class.getName(),
				ClassThatInvokesClassThatInvokesArrayClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatDeclaresExceptionA.class,
				false);
		testMatches(ClassB.class.getName(), ClassThatThrowsExceptionA.class,
				false);
		testMatches(ClassB.class.getName(), ClassWithGenericClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatExtendsList.class, true);
		testMatches(ClassB.class.getName(), GenericClassA.class, true);
		testMatches(ClassB.class.getName(), GenericClassB.class, true);
		testMatches(ClassB.class.getName(), GenericClassC.class, false);
		testMatches(ClassB.class.getName(), ClassThatExtendsListOfClassA.class,
				false);
		// Inner class
		testMatches(ClassB.class.getName(),
				InnerClassThatExtendsClassA.B.class, false);
		testMatches(ClassB.class.getName(), InnerClassWithFieldClassA.B.class,
				false);
		testMatches(ClassB.class.getName(),
				InnerClassWithFieldArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassWithParameterClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassWithParameterArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassThatReturnsClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassThatReturnsArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassThatInvokesClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				InnerClassThatInvokesClassThatInvokesClassA.B.class, false);
		// Inner static class
		testMatches(ClassB.class.getName(),
				StaticInnerClassThatExtendsClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassWithFieldClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassWithFieldArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassWithParameterClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassWithParameterArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassThatReturnsClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassThatReturnsArrayClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassThatInvokesClassA.B.class, false);
		testMatches(ClassB.class.getName(),
				StaticInnerClassThatInvokesClassThatInvokesClassA.B.class,
				false);
		// Static methods
		testMatches(ClassB.class.getName(), ClassWithStaticFieldClassA.class,
				false);
		testMatches(ClassB.class.getName(),
				ClassWithStaticFieldArrayClassA.class, false);
		testMatches(ClassB.class.getName(),
				ClassWithStaticParameterClassA.class, false);
		testMatches(ClassB.class.getName(),
				ClassWithStaticParameterArrayClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatStaticReturnsClassA.class,
				false);
		testMatches(ClassB.class.getName(),
				ClassThatStaticReturnsArrayClassA.class, false);
		testMatches(ClassB.class.getName(), ClassThatStaticInvokesClassA.class,
				false);
		testMatches(ClassB.class.getName(),
				ClassThatStaticInvokesClassThatInvokesClassA.class, false);
		// Primitive fields
		testMatches(ClassB.class.getName(), ClassWithPrimitiveTypes.class, true);
		// Interface usage
		testMatches(ClassB.class.getName(), ClassWithFieldInterfaceA.class,
				false);
		testMatches(InterfaceA.class.getName(), ClassWithFieldInterfaceA.class,
				true);
		testMatches(List.class.getName(), ClassWithFieldList.class, true);
		testMatches(ClassB.class.getName(),
				InterfaceThatDeclaresExceptionA.class, false);
		testMatches(ClassB.class.getName(),
				ClassThatImplementsInterfaceA.class, false);
	}

	private void testMatches(String filterPredicateParentClass,
			Class<?> usagePredicateClass, boolean matches)
			throws ClassNotFoundException {

		final TypingPredicate filterPredicate2 = new TypingPredicate();
		filterPredicate2.setFilterPredicate(new NamingPredicate(
				filterPredicateParentClass));

		final OrPredicate filterPredicate = new OrPredicate();
		filterPredicate.setPredicates(Arrays.asList(new Predicate[] {
				filterPredicate2, new NamingPredicate("java.**"),
				new NamingPredicate("long"), new NamingPredicate("short"),
				new NamingPredicate("byte"), new NamingPredicate("char"),
				new NamingPredicate("int"), new NamingPredicate("boolean"),
				new NamingPredicate("double"), new NamingPredicate("float") }));

		final Type type = BCERepositoryLocator.getRepository().lookupType(
				usagePredicateClass);

		final UsagePredicate usagePredicate = new UsagePredicate();
		usagePredicate.setFilterPredicate(filterPredicate);
		assertEquals(matches, usagePredicate.evaluate(type, null));
	}

}
