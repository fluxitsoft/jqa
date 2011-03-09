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
import ar.com.fluxit.jqa.mock.allocation.ClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassThatStaticReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassThatStaticReturnsClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithStaticFieldArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithStaticFieldClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithStaticParameterArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithStaticParameterClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithoutClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.InnerClassWithParameterClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassThatExtendsClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassThatReturnsArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassThatReturnsClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassWithFieldArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassWithFieldClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassWithParameterArrayClassA;
import ar.com.fluxit.jqa.mock.allocation.StaticInnerClassWithParameterClassA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class UsageRuleTest extends TestCase {

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

	public final void testCheck() throws ClassNotFoundException {
		final String filterRuleParentClass = ClassA.class.getName();
		
		// Simple class
		testMatches(filterRuleParentClass, ClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithoutClassA.class, false);
		testMatches(filterRuleParentClass, ClassThatExtendsClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithFieldClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithFieldArrayClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithParameterClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithParameterArrayClassA.class, true);
		testMatches(filterRuleParentClass, ClassThatReturnsClassA.class, true);	
		testMatches(filterRuleParentClass, ClassThatReturnsArrayClassA.class, true);
		// Inner class
		testMatches(filterRuleParentClass, InnerClassThatExtendsClassA.B.class, true); 
		testMatches(filterRuleParentClass, InnerClassWithFieldClassA.B.class, true);
		testMatches(filterRuleParentClass, InnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterRuleParentClass, InnerClassWithParameterClassA.B.class, true);
		testMatches(filterRuleParentClass, InnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterRuleParentClass, InnerClassThatReturnsClassA.B.class, true);	
		testMatches(filterRuleParentClass, InnerClassThatReturnsArrayClassA.B.class, true);
		// Inner static class
		testMatches(filterRuleParentClass, StaticInnerClassThatExtendsClassA.B.class, true);
		testMatches(filterRuleParentClass, StaticInnerClassWithFieldClassA.B.class, true);
		testMatches(filterRuleParentClass, StaticInnerClassWithFieldArrayClassA.B.class, true);
		testMatches(filterRuleParentClass, StaticInnerClassWithParameterClassA.B.class, true);
		testMatches(filterRuleParentClass, StaticInnerClassWithParameterArrayClassA.B.class, true);
		testMatches(filterRuleParentClass, StaticInnerClassThatReturnsClassA.B.class, true);	
		testMatches(filterRuleParentClass, StaticInnerClassThatReturnsArrayClassA.B.class, true);
		// Static methods
		testMatches(filterRuleParentClass, ClassWithStaticFieldClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithStaticFieldArrayClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithStaticParameterClassA.class, true);
		testMatches(filterRuleParentClass, ClassWithStaticParameterArrayClassA.class, true);
		testMatches(filterRuleParentClass, ClassThatStaticReturnsClassA.class, true);	
		testMatches(filterRuleParentClass, ClassThatStaticReturnsArrayClassA.class, true);
	}

	private void testMatches(String filterRuleParentClass,
			Class<?> usageRuleclass, boolean matches)
			throws ClassNotFoundException {
		final Rule filterRule = new TypingRule(filterRuleParentClass);
		final JavaClass clazz = RepositoryLocator.getRepository().lookupClass(
				usageRuleclass);
		assertEquals(matches, new UsageRule(filterRule).check(clazz, getCheckingContext()));
	}

}
