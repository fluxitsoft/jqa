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
package ar.com.fluxit.jqa.bce.bcel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.bcel.classfile.JavaClass;
import org.junit.Test;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleAllocations;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BcelJavaTypeTest {

	private void doAsserts(Type stringType) {
		assertNotNull(stringType);
		assertEquals("java.lang.String", stringType.getName());
		assertEquals("String", stringType.getShortName());
	}

	@Test
	public void testCreateJavaClass() throws ClassNotFoundException {
		try {
			BcelJavaType.create((JavaClass) null);
			fail("Must throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// ok
		}
		JavaClass stringJavaClass = org.apache.bcel.Repository.lookupClass(String.class);
		BcelJavaType stringType = BcelJavaType.create(stringJavaClass);
		doAsserts(stringType);
		assertEquals(stringJavaClass, stringType.getWrapped());
	}

	@Test
	public void testCreateString() throws ClassNotFoundException {
		try {
			BcelJavaType.create((String) null);
			fail("Must throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// ok
		}
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		doAsserts(stringType);
	}

	@Test
	public void testCreateType() {
		try {
			BcelJavaType.create((org.apache.bcel.generic.Type) null);
			fail("Must throw an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// ok
		}
		BcelJavaType stringType = BcelJavaType.create(org.apache.bcel.generic.Type.getType(String.class));
		doAsserts(stringType);
	}

	@Test
	public void testEqualsObject() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		BcelJavaType stringType2 = BcelJavaType.create("java.lang.String");
		BcelJavaType numberType = BcelJavaType.create("java.lang.Number");
		assertTrue(stringType.equals(stringType));
		assertTrue(stringType.equals(stringType2));
		assertFalse(stringType.equals(numberType));
		assertFalse(stringType.equals("java.lang.String"));
		assertFalse(stringType.equals(null));
	}

	@Test
	public void testGetName() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		assertEquals("java.lang.String", stringType.getName());
	}

	@Test
	public void testGetPackage() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		assertEquals("java.lang", stringType.getPackage());
	}

	@Test
	public void testGetShortName() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		assertEquals("String", stringType.getShortName());
	}

	@Test
	public void testHashCode() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		BcelJavaType stringType2 = BcelJavaType.create("java.lang.String");
		BcelJavaType numberType = BcelJavaType.create("java.lang.Number");
		assertNotNull(stringType.hashCode());
		assertNotNull(stringType2.hashCode());
		assertNotNull(numberType.hashCode());
		assertTrue(stringType.hashCode() == stringType2.hashCode());
		assertFalse(stringType.hashCode() == numberType.hashCode());
	}

	@Test
	public void testIsAbstract() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		BcelJavaType listType = BcelJavaType.create("java.util.List");
		BcelJavaType numberType = BcelJavaType.create("java.lang.Number");
		assertFalse(stringType.isAbstract());
		assertFalse(listType.isAbstract());
		assertTrue(numberType.isAbstract());
	}

	@Test
	public void testIsAnonymous() {
		assertTrue(BcelJavaType.create(ClassWithMultipleAllocations.class.getName() + "$1").isAnonymous());
		assertFalse(BcelJavaType.create(ClassWithMultipleAllocations.class.getName()).isAnonymous());
		assertTrue(BcelJavaType.create(ClassWithMultipleAllocations.class.getName() + "$Inner$1").isAnonymous());
		assertFalse(BcelJavaType.create(org.apache.bcel.generic.Type.getType(ClassWithMultipleAllocations.Inner.class)).isAnonymous());
	}

	@Test
	public void testIsInterface() {
		BcelJavaType stringType = BcelJavaType.create("java.lang.String");
		BcelJavaType listType = BcelJavaType.create("java.util.List");
		BcelJavaType numberType = BcelJavaType.create("java.lang.Number");
		assertFalse(stringType.isInterface());
		assertTrue(listType.isInterface());
		assertFalse(numberType.isInterface());
	}

	@Test
	public void testToString() {
		assertEquals("java.lang.String", BcelJavaType.create("java.lang.String").toString());
		assertEquals("long", BcelJavaType.create("long").toString());
	}

}
