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
package ar.com.fluxit.jqa.bce.bcel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.IllegalComponentStateException;
import java.awt.Label;
import java.io.BufferedInputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.Serializable;
import java.lang.instrument.UnmodifiableClassException;
import java.net.Socket;
import java.rmi.server.RemoteRef;
import java.rmi.server.ServerRef;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeoutException;
import java.util.prefs.BackingStoreException;
import java.util.zip.DataFormatException;

import javax.print.attribute.UnmodifiableSetException;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.transform.TransformerException;

import net.sourceforge.pmd.FileDataSource;
import nu.xom.Attribute;
import nu.xom.DocType;

import org.apache.bcel.verifier.GraphicalVerifier;
import org.apache.tools.ant.filters.ConcatFilter;
import org.apache.wml.dom.WMLAnchorElementImpl;
import org.apache.wml.dom.WMLImgElementImpl;
import org.junit.Test;

import sun.awt.image.BadDepthException;
import ar.com.fluxit.jqa.bce.BCERepository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.EnumA;
import ar.com.fluxit.jqa.mock.ExceptionA;
import ar.com.fluxit.jqa.mock.sub.ClassWithInnerTypes;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleAllocations;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleThrows;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleThrows.Inner.InnerException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BCERepositoryImplTest {

	private final BCERepository repository;

	public BCERepositoryImplTest() {
		this.repository = new BCERepositoryImpl(Collections.<File> emptyList(), "1.5", System.getProperty("user.dir") + File.separatorChar + "src"
				+ File.separatorChar + "test" + File.separatorChar + "java");
	}

	private void assertContainsAll(Integer[] expecteds, Collection<Integer> actuals) {
		for (Integer expected : expecteds) {
			if (!actuals.contains(expected)) {
				fail(String.format("Actual [%s] not contains [%s]. Expected is [%s]", actuals.toString(), expected.toString(), Arrays.toString(expecteds)));
			}
		}
	}

	private void assertContainsAllocation(Map<Type, Collection<Integer>> actuals, Class<?> allocatedClass, Integer[] expecteds) {
		try {
			Type allocatedType = this.repository.lookupType(allocatedClass);
			assertContainsAllocation(actuals, allocatedType, expecteds);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private void assertContainsAllocation(Map<Type, Collection<Integer>> actuals, Type allocatedType, Integer[] expecteds) {
		Collection<Integer> actualLineNumbers = actuals.get(allocatedType);
		assertNotNull(actualLineNumbers);
		assertContainsAll(expecteds, actualLineNumbers);
	}

	@Test
	public void testGetAllocations() throws ClassNotFoundException {
		// Main class
		Type type = this.repository.lookupType(ClassWithMultipleAllocations.class);
		Map<Type, Collection<Integer>> allocations = this.repository.getAllocations(type);
		assertEquals(12, allocations.size());
		assertContainsAllocation(allocations, File.class, new Integer[] { 163 });
		assertContainsAllocation(allocations, WMLImgElementImpl.class, new Integer[] { 165 });
		assertContainsAllocation(allocations, FactoryConfigurationError.class, new Integer[] { 168 });
		assertContainsAllocation(allocations, Attribute.class, new Integer[] { 172 });
		assertContainsAllocation(allocations, this.repository.lookupType(ClassWithMultipleAllocations.class.getName() + "$1"), new Integer[] { 176 });
		assertContainsAllocation(allocations, ClassA.class, new Integer[] { 180 });
		assertContainsAllocation(allocations, this.repository.lookupType(ClassWithMultipleAllocations.class.getName() + "$1$1"), new Integer[] { 181 });
		assertContainsAllocation(allocations, GraphicalVerifier.class, new Integer[] { 185 });
		assertContainsAllocation(allocations, DecimalFormat.class, new Integer[] { 198 });
		assertContainsAllocation(allocations, Label.class, new Integer[] { 200 });
		assertContainsAllocation(allocations, FileDataSource.class, new Integer[] { 206 });
		assertContainsAllocation(allocations, Double.class, new Integer[] { 211 });
		// Inner class
		Type type2 = this.repository.lookupType(ClassWithMultipleAllocations.Inner.class);
		Map<Type, Collection<Integer>> allocations2 = this.repository.getAllocations(type2);
		assertEquals(11, allocations2.size());
		assertContainsAllocation(allocations2, Boolean.class, new Integer[] { 109 });
		assertContainsAllocation(allocations2, WMLAnchorElementImpl.class, new Integer[] { 110 });
		assertContainsAllocation(allocations2, ClassA.class, new Integer[] { 113 });
		assertContainsAllocation(allocations2, StringBuffer.class, new Integer[] { 114 });
		assertContainsAllocation(allocations2, ConcatFilter.class, new Integer[] { 118 });
		assertContainsAllocation(allocations2, DocType.class, new Integer[] { 131 });
		assertContainsAllocation(allocations2, this.repository.lookupType(ClassWithMultipleAllocations.class.getName() + "$Inner$1"), new Integer[] { 122 });
		assertContainsAllocation(allocations2, Vector.class, new Integer[] { 144 });
		assertContainsAllocation(allocations2, Font.class, new Integer[] { 146 });
		assertContainsAllocation(allocations2, FileDescriptor.class, new Integer[] { 152 });
		assertContainsAllocation(allocations2, Socket.class, new Integer[] { 157 });
		// Nested inner class
		Type type3 = this.repository.lookupType(ClassWithMultipleAllocations.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> allocations3 = this.repository.getAllocations(type3);
		assertEquals(10, allocations3.size());
		assertContainsAllocation(allocations3, Frame.class, new Integer[] { 63 });
		assertContainsAllocation(allocations3, Canvas.class, new Integer[] { 66 });
		assertContainsAllocation(allocations3, Checkbox.class, new Integer[] { 70 });
		assertContainsAllocation(allocations3, this.repository.lookupType(ClassWithMultipleAllocations.class.getName() + "$Inner$NestedInner$1"),
				new Integer[] { 74 });
		assertContainsAllocation(allocations3, Color.class, new Integer[] { 80 });
		assertContainsAllocation(allocations3, BasicStroke.class, new Integer[] { 88 });
		assertContainsAllocation(allocations3, AWTException.class, new Integer[] { 90 });
		assertContainsAllocation(allocations3, BufferedInputStream.class, new Integer[] { 96 });
		assertContainsAllocation(allocations3, InstantiationError.class, new Integer[] { 101 });
		assertContainsAllocation(allocations3, ClassA.class, new Integer[] { 102 });
	}

	@Test
	public void testGetDeclarationLineNumber() throws ClassNotFoundException {
		assertEquals(38, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.class)));
		assertEquals(40, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.EnumA.class)));
		assertEquals(44, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.Inner.class)));
		assertEquals(46, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.Inner.NestedInner.class)));
		assertEquals(49,
				(int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.class.getName() + "$Inner$NestedInner$1")));
		assertEquals(64, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.class.getName() + "$Inner$1")));
		assertEquals(87, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.class.getName() + "$1")));
		assertEquals(92, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(ClassWithInnerTypes.class.getName() + "$1$1")));
		assertEquals(4, (int) this.repository.getDeclarationLineNumber(this.repository.lookupType(EnumA.class)));
	}

	@Test
	public void testGetInterfaces() throws ClassNotFoundException {
		// Class
		Collection<Type> longTypeInterfaces = this.repository.getInterfaces(this.repository.lookupType(Long.class));
		assertEquals(2, longTypeInterfaces.size());
		assertTrue(longTypeInterfaces.contains(this.repository.lookupType(Comparable.class)));
		assertTrue(longTypeInterfaces.contains(this.repository.lookupType(Serializable.class)));
		// Interface
		Collection<Type> serverRefTypeInterfaces = this.repository.getInterfaces(this.repository.lookupType(ServerRef.class));
		assertEquals(4, serverRefTypeInterfaces.size());
		assertTrue(serverRefTypeInterfaces.contains(this.repository.lookupType(RemoteRef.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository.lookupType(ServerRef.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository.lookupType(Externalizable.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository.lookupType(Serializable.class)));
		// Enum
		Collection<Type> enumTypeInterfaces = this.repository.getInterfaces(this.repository.lookupType(EnumA.class));
		assertEquals(2, enumTypeInterfaces.size());
		assertTrue(enumTypeInterfaces.contains(this.repository.lookupType(Comparable.class)));
		assertTrue(enumTypeInterfaces.contains(this.repository.lookupType(Serializable.class)));
	}

	@Test
	public void testGetSuperClasses() throws ClassNotFoundException {
		// Class
		Collection<Type> arrayListTypeInterfaces = this.repository.getSuperClasses(this.repository.lookupType(ArrayList.class));
		assertEquals(3, arrayListTypeInterfaces.size());
		assertTrue(arrayListTypeInterfaces.contains(this.repository.lookupType(AbstractList.class)));
		assertTrue(arrayListTypeInterfaces.contains(this.repository.lookupType(AbstractCollection.class)));
		assertTrue(arrayListTypeInterfaces.contains(this.repository.lookupType(Object.class)));
		// Interface
		Collection<Type> serverRefTypeInterfaces = this.repository.getSuperClasses(this.repository.lookupType(ServerRef.class));
		assertEquals(1, serverRefTypeInterfaces.size());
		assertTrue(serverRefTypeInterfaces.contains(this.repository.lookupType(Object.class)));
		// Enum
		Collection<Type> enumTypeInterfaces = this.repository.getSuperClasses(this.repository.lookupType(EnumA.class));
		assertEquals(2, enumTypeInterfaces.size());
		assertTrue(enumTypeInterfaces.contains(this.repository.lookupType(Enum.class)));
		assertTrue(enumTypeInterfaces.contains(this.repository.lookupType(Object.class)));
	}

	@Test
	public void testGetThrows() throws ClassNotFoundException {
		// Main class
		Type type = this.repository.lookupType(ClassWithMultipleThrows.class);
		Map<Type, Collection<Integer>> allocations = this.repository.getThrows(type);
		assertEquals(8, allocations.size());
		assertContainsAllocation(allocations, DataFormatException.class, new Integer[] { 158, 159 });
		assertContainsAllocation(allocations, UnmodifiableClassException.class, new Integer[] { 162 });
		assertContainsAllocation(allocations, UnmodifiableSetException.class, new Integer[] { 163 });
		assertContainsAllocation(allocations, UnsupportedClassVersionError.class, new Integer[] { 166 });
		assertContainsAllocation(allocations, TransformerException.class, new Integer[] { 190, 186 });
		assertContainsAllocation(allocations, IllegalArgumentException.class, new Integer[] { 176, 180 });
		assertContainsAllocation(allocations, TimeoutException.class, new Integer[] { 194, 196 });
		assertContainsAllocation(allocations, SQLException.class, new Integer[] { 200 });
		// Inner class
		Type type2 = this.repository.lookupType(ClassWithMultipleThrows.Inner.class);
		Map<Type, Collection<Integer>> allocations2 = this.repository.getThrows(type2);
		assertEquals(10, allocations2.size());
		assertContainsAllocation(allocations2, InnerException.class, new Integer[] { 100, 99 });
		assertContainsAllocation(allocations2, AWTException.class, new Integer[] { 103, 104 });
		assertContainsAllocation(allocations2, BackingStoreException.class, new Integer[] { 113 });
		assertContainsAllocation(allocations2, IllegalStateException.class, new Integer[] { 122 });
		assertContainsAllocation(allocations2, IllegalArgumentException.class, new Integer[] { 127 });
		assertContainsAllocation(allocations2, BadDepthException.class, new Integer[] { 135 });
		assertContainsAllocation(allocations2, IllegalAccessError.class, new Integer[] { 137 });
		assertContainsAllocation(allocations2, CloneNotSupportedException.class, new Integer[] { 141, 143 });
		assertContainsAllocation(allocations2, UnsupportedClassVersionError.class, new Integer[] { 147 });
		assertContainsAllocation(allocations2, UnsupportedOperationException.class, new Integer[] { 149 });
		// Nested inner class
		Type type3 = this.repository.lookupType(ClassWithMultipleThrows.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> allocations3 = this.repository.getThrows(type3);
		assertEquals(7, allocations3.size());
		assertContainsAllocation(allocations3, IllegalArgumentException.class, new Integer[] { 57 });
		assertContainsAllocation(allocations3, ExceptionA.class, new Integer[] { 61, 60 });
		assertContainsAllocation(allocations3, IllegalAccessError.class, new Integer[] { 71 });
		assertContainsAllocation(allocations3, AWTException.class, new Integer[] { 81, 77 });
		assertContainsAllocation(allocations3, IllegalComponentStateException.class, new Integer[] { 79 });
		assertContainsAllocation(allocations3, Exception.class, new Integer[] { 85, 87 });
		assertContainsAllocation(allocations3, InstantiationError.class, new Integer[] { 94, 91 });
	}
	//
	// @Test
	// public void testGetUseLineNumbers() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetUses() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testHasImport() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testLookupTypeClassOfQ() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testLookupTypeString() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testParse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetClassPath() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSetJavaVersion() {
	// fail("Not yet implemented");
	// }

}
