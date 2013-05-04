/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
import java.io.PrintStream;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeoutException;
import java.util.zip.DataFormatException;

import javax.crypto.BadPaddingException;
import javax.print.attribute.UnmodifiableSetException;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.transform.TransformerException;

import net.sourceforge.pmd.FileDataSource;
import nu.xom.Attribute;
import nu.xom.DocType;

import org.apache.bcel.verifier.GraphicalVerifier;
import org.apache.tools.ant.filters.ConcatFilter;
import org.apache.wml.dom.WMLAnchorElementImpl;
import org.apache.wml.dom.WMLElementImpl;
import org.apache.wml.dom.WMLImgElementImpl;
import org.junit.Test;

import ar.com.fluxit.jqa.bce.BCERepository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.EnumA;
import ar.com.fluxit.jqa.mock.ExceptionA;
import ar.com.fluxit.jqa.mock.Helper;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleAllocations;
import ar.com.fluxit.jqa.mock.sub.ClassWithMultipleFields;
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
		final File[] sourcesDir = new File[] { new File(
				System.getProperty("user.dir") + File.separatorChar + "src"
						+ File.separatorChar + "test" + File.separatorChar
						+ "java") };
		this.repository = new BCERepositoryImpl(Collections.<File> emptyList(),
				"1.5", sourcesDir);
	}

	private void assertContainsAll(Integer[] expecteds,
			Collection<Integer> actuals) {
		if (expecteds.length != actuals.size()) {
			fail(String.format(
					"Size is not equals. Actual [%s] but expected is [%s]",
					actuals.toString(), Arrays.toString(expecteds)));
		}
		for (Integer expected : expecteds) {
			if (!actuals.contains(expected)) {
				fail(String.format(
						"Actual [%s] not contains [%s]. Expected is [%s]",
						actuals.toString(), expected.toString(),
						Arrays.toString(expecteds)));
			}
		}
	}

	private void assertContainsSourceLine(
			Map<Type, Collection<Integer>> actuals, Class<?> allocatedClass,
			Integer[] expecteds) {
		try {
			Type allocatedType = this.repository.lookupType(allocatedClass);
			assertContainsSourceLine(actuals, allocatedType, expecteds);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private void assertContainsSourceLine(
			Map<Type, Collection<Integer>> actuals, String allocatedClass,
			Integer[] expecteds) {
		try {
			Type allocatedType = this.repository.lookupType(allocatedClass);
			assertContainsSourceLine(actuals, allocatedType, expecteds);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private void assertContainsSourceLine(
			Map<Type, Collection<Integer>> actuals, Type allocatedType,
			Integer[] expecteds) {
		Collection<Integer> actualLineNumbers = actuals.get(allocatedType);
		assertNotNull(
				String.format("Expected [%s] but was null",
						Arrays.toString(expecteds)), actualLineNumbers);
		assertContainsAll(expecteds, actualLineNumbers);
	}

	@Test
	public void testGetAllocations() throws ClassNotFoundException {
		// TODO test new array
		// Main class
		Type type = this.repository
				.lookupType(ClassWithMultipleAllocations.class);
		Map<Type, Collection<Integer>> allocations = this.repository
				.getAllocations(type);
		assertEquals(12, allocations.size());
		assertContainsSourceLine(allocations, File.class, new Integer[] { 162 });
		assertContainsSourceLine(allocations, WMLImgElementImpl.class,
				new Integer[] { 164 });
		assertContainsSourceLine(allocations, FactoryConfigurationError.class,
				new Integer[] { 167 });
		assertContainsSourceLine(allocations, Attribute.class,
				new Integer[] { 171 });
		assertContainsSourceLine(allocations,
				ClassWithMultipleAllocations.class.getName() + "$1",
				new Integer[] { 175 });
		assertContainsSourceLine(allocations, ClassA.class,
				new Integer[] { 179 });
		assertContainsSourceLine(allocations,
				ClassWithMultipleAllocations.class.getName() + "$1$1",
				new Integer[] { 180 });
		assertContainsSourceLine(allocations, GraphicalVerifier.class,
				new Integer[] { 184 });
		assertContainsSourceLine(allocations, DecimalFormat.class,
				new Integer[] { 197 });
		assertContainsSourceLine(allocations, Label.class,
				new Integer[] { 199 });
		assertContainsSourceLine(allocations, FileDataSource.class,
				new Integer[] { 205 });
		assertContainsSourceLine(allocations, Double.class,
				new Integer[] { 210 });
		// Inner class
		Type type2 = this.repository
				.lookupType(ClassWithMultipleAllocations.Inner.class);
		Map<Type, Collection<Integer>> allocations2 = this.repository
				.getAllocations(type2);
		assertEquals(11, allocations2.size());
		assertContainsSourceLine(allocations2, Boolean.class,
				new Integer[] { 108 });
		assertContainsSourceLine(allocations2, WMLAnchorElementImpl.class,
				new Integer[] { 109 });
		assertContainsSourceLine(allocations2, ClassA.class,
				new Integer[] { 112 });
		assertContainsSourceLine(allocations2, StringBuffer.class,
				new Integer[] { 113 });
		assertContainsSourceLine(allocations2, ConcatFilter.class,
				new Integer[] { 117 });
		assertContainsSourceLine(allocations2, DocType.class,
				new Integer[] { 130 });
		assertContainsSourceLine(allocations2,
				ClassWithMultipleAllocations.class.getName() + "$Inner$1",
				new Integer[] { 121 });
		assertContainsSourceLine(allocations2, Vector.class,
				new Integer[] { 143 });
		assertContainsSourceLine(allocations2, Font.class,
				new Integer[] { 145 });
		assertContainsSourceLine(allocations2, FileDescriptor.class,
				new Integer[] { 151 });
		assertContainsSourceLine(allocations2, Socket.class,
				new Integer[] { 156 });
		// Nested inner class
		Type type3 = this.repository
				.lookupType(ClassWithMultipleAllocations.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> allocations3 = this.repository
				.getAllocations(type3);
		assertEquals(10, allocations3.size());
		assertContainsSourceLine(allocations3, Frame.class,
				new Integer[] { 62 });
		assertContainsSourceLine(allocations3, Canvas.class,
				new Integer[] { 65 });
		assertContainsSourceLine(allocations3, Checkbox.class,
				new Integer[] { 69 });
		assertContainsSourceLine(allocations3,
				ClassWithMultipleAllocations.class.getName()
						+ "$Inner$NestedInner$1", new Integer[] { 73 });
		assertContainsSourceLine(allocations3, Color.class,
				new Integer[] { 79 });
		assertContainsSourceLine(allocations3, BasicStroke.class,
				new Integer[] { 87 });
		assertContainsSourceLine(allocations3, AWTException.class,
				new Integer[] { 89 });
		assertContainsSourceLine(allocations3, BufferedInputStream.class,
				new Integer[] { 95 });
		assertContainsSourceLine(allocations3, InstantiationError.class,
				new Integer[] { 100 });
		assertContainsSourceLine(allocations3, ClassA.class,
				new Integer[] { 101 });
	}

	@Test
	public void testGetInterfaces() throws ClassNotFoundException {
		// Class
		Collection<Type> longTypeInterfaces = this.repository
				.getInterfaces(this.repository.lookupType(Long.class));
		assertEquals(2, longTypeInterfaces.size());
		assertTrue(longTypeInterfaces.contains(this.repository
				.lookupType(Comparable.class)));
		assertTrue(longTypeInterfaces.contains(this.repository
				.lookupType(Serializable.class)));
		// Interface
		Collection<Type> serverRefTypeInterfaces = this.repository
				.getInterfaces(this.repository.lookupType(ServerRef.class));
		assertEquals(4, serverRefTypeInterfaces.size());
		assertTrue(serverRefTypeInterfaces.contains(this.repository
				.lookupType(RemoteRef.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository
				.lookupType(ServerRef.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository
				.lookupType(Externalizable.class)));
		assertTrue(serverRefTypeInterfaces.contains(this.repository
				.lookupType(Serializable.class)));
		// Enum
		Collection<Type> enumTypeInterfaces = this.repository
				.getInterfaces(this.repository.lookupType(EnumA.class));
		assertEquals(2, enumTypeInterfaces.size());
		assertTrue(enumTypeInterfaces.contains(this.repository
				.lookupType(Comparable.class)));
		assertTrue(enumTypeInterfaces.contains(this.repository
				.lookupType(Serializable.class)));
	}

	@Test
	public void testGetSuperClasses() throws ClassNotFoundException {
		// Class
		Collection<Type> arrayListTypeInterfaces = this.repository
				.getSuperClasses(this.repository.lookupType(ArrayList.class));
		assertEquals(3, arrayListTypeInterfaces.size());
		assertTrue(arrayListTypeInterfaces.contains(this.repository
				.lookupType(AbstractList.class)));
		assertTrue(arrayListTypeInterfaces.contains(this.repository
				.lookupType(AbstractCollection.class)));
		assertTrue(arrayListTypeInterfaces.contains(this.repository
				.lookupType(Object.class)));
		// Interface
		Collection<Type> serverRefTypeInterfaces = this.repository
				.getSuperClasses(this.repository.lookupType(ServerRef.class));
		assertEquals(1, serverRefTypeInterfaces.size());
		assertTrue(serverRefTypeInterfaces.contains(this.repository
				.lookupType(Object.class)));
		// Enum
		Collection<Type> enumTypeInterfaces = this.repository
				.getSuperClasses(this.repository.lookupType(EnumA.class));
		assertEquals(2, enumTypeInterfaces.size());
		assertTrue(enumTypeInterfaces.contains(this.repository
				.lookupType(Enum.class)));
		assertTrue(enumTypeInterfaces.contains(this.repository
				.lookupType(Object.class)));
	}

	@Test
	public void testGetThrows() throws ClassNotFoundException {
		// Main class
		Type type = this.repository.lookupType(ClassWithMultipleThrows.class);
		Map<Type, Collection<Integer>> throwz = this.repository.getThrows(type);
		assertEquals(7, throwz.size());
		assertContainsSourceLine(throwz, DataFormatException.class,
				new Integer[] { 158, 159 });
		assertContainsSourceLine(throwz, UnmodifiableClassException.class,
				new Integer[] { 162 });
		assertContainsSourceLine(throwz, UnmodifiableSetException.class,
				new Integer[] { 163 });
		assertContainsSourceLine(throwz, UnsupportedClassVersionError.class,
				new Integer[] { 166 });
		assertContainsSourceLine(throwz, TransformerException.class,
				new Integer[] { 190, 186 });
		assertContainsSourceLine(throwz, TimeoutException.class, new Integer[] {
				194, 196 });
		assertContainsSourceLine(throwz, SQLException.class,
				new Integer[] { 200 });
		// Inner class
		Type type2 = this.repository
				.lookupType(ClassWithMultipleThrows.Inner.class);
		Map<Type, Collection<Integer>> throwz2 = this.repository
				.getThrows(type2);
		assertEquals(7, throwz2.size());
		assertContainsSourceLine(throwz2, InnerException.class, new Integer[] {
				100, 99 });
		assertContainsSourceLine(throwz2, AWTException.class, new Integer[] {
				103, 104 });
		assertContainsSourceLine(throwz2, BadPaddingException.class,
				new Integer[] { 135 });
		assertContainsSourceLine(throwz2, IllegalAccessError.class,
				new Integer[] { 137 });
		assertContainsSourceLine(throwz2, CloneNotSupportedException.class,
				new Integer[] { 141, 143 });
		assertContainsSourceLine(throwz2, UnsupportedClassVersionError.class,
				new Integer[] { 147 });
		assertContainsSourceLine(throwz2, UnsupportedOperationException.class,
				new Integer[] { 149 });
		// Nested inner class
		Type type3 = this.repository
				.lookupType(ClassWithMultipleThrows.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> throwz3 = this.repository
				.getThrows(type3);
		assertEquals(6, throwz3.size());
		assertContainsSourceLine(throwz3, IllegalArgumentException.class,
				new Integer[] { 57 });
		assertContainsSourceLine(throwz3, ExceptionA.class, new Integer[] { 61,
				60 });
		assertContainsSourceLine(throwz3, AWTException.class, new Integer[] {
				81, 77 });
		assertContainsSourceLine(throwz3, IllegalComponentStateException.class,
				new Integer[] { 79 });
		assertContainsSourceLine(throwz3, Exception.class, new Integer[] { 85,
				87 });
		assertContainsSourceLine(throwz3, InstantiationError.class,
				new Integer[] { 94, 91 });
	}

	@Test
	public void testGetUses() throws ClassNotFoundException {
		// Main class fields
		Type type = this.repository.lookupType(ClassWithMultipleFields.class);
		Map<Type, Collection<Integer>> uses = this.repository.getUses(type);
		assertEquals(4 + 1, uses.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses, File.class, new Integer[] { 104 });
		assertContainsSourceLine(uses, Iterator.class, new Integer[] { 108 });
		assertContainsSourceLine(uses, EnumA.class, new Integer[] { 105 });
		assertContainsSourceLine(uses, ClassWithMultipleFields.class.getName()
				+ "$1", new Integer[] { 108 });
		// Inner class fields
		Type type2 = this.repository
				.lookupType(ClassWithMultipleFields.Inner.class);
		Map<Type, Collection<Integer>> uses2 = this.repository.getUses(type2);
		assertEquals(4 + 1, uses2.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses2, Boolean.class, new Integer[] { 75 });
		assertContainsSourceLine(uses2, WMLAnchorElementImpl.class,
				new Integer[] { 77 });
		assertContainsSourceLine(uses2, String.class, new Integer[] { 80 });
		assertContainsSourceLine(uses2,
				ClassWithMultipleFields.Inner.class.getName() + "$1",
				new Integer[] { 80 });
		// Nested inner class fields
		Type type3 = this.repository
				.lookupType(ClassWithMultipleFields.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> uses3 = this.repository.getUses(type3);
		assertEquals(3 + 1, uses3.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses3, Frame.class, new Integer[] { 50 });
		assertContainsSourceLine(uses3, String.class, new Integer[] { 53 });
		assertContainsSourceLine(uses3,
				ClassWithMultipleFields.Inner.NestedInner.class.getName()
						+ "$1", new Integer[] { 53 });
		// Nested inner class fields
		Type type4 = this.repository
				.lookupType(ClassWithMultipleFields.Inner.NestedInnerStatic.class);
		Map<Type, Collection<Integer>> uses4 = this.repository.getUses(type4);
		assertEquals(2 + 1, uses4.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses4, WMLElementImpl.class,
				new Integer[] { 70 });
		assertContainsSourceLine(uses4, ConcatFilter.class,
				new Integer[] { 71 });
		// Main class allocations
		Type type5 = this.repository
				.lookupType(ClassWithMultipleAllocations.class);
		Map<Type, Collection<Integer>> uses5 = this.repository.getUses(type5);
		assertEquals(14 + 1, uses5.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses5, File.class, new Integer[] { 162 });
		assertContainsSourceLine(uses5, WMLImgElementImpl.class,
				new Integer[] { 164 });
		assertContainsSourceLine(uses5, FactoryConfigurationError.class,
				new Integer[] { 167 });
		assertContainsSourceLine(uses5, Attribute.class, new Integer[] { 171 });
		assertContainsSourceLine(uses5,
				ClassWithMultipleAllocations.class.getName() + "$1",
				new Integer[] { 175 });
		assertContainsSourceLine(uses5, DecimalFormat.class,
				new Integer[] { 197 });
		assertContainsSourceLine(uses5, Label.class, new Integer[] { 199 });
		assertContainsSourceLine(uses5, FileDataSource.class,
				new Integer[] { 205 });
		assertContainsSourceLine(uses5, Double.class, new Integer[] { 210 });
		assertContainsSourceLine(uses5, System.class, new Integer[] { 167, 171,
				197, 205, 211, 199 });
		assertContainsSourceLine(uses5, PrintStream.class, new Integer[] { 167,
				171, 197, 205, 211, 199 });
		assertContainsSourceLine(uses5, int.class.getName(), new Integer[] {
				210, 211 });
		assertContainsSourceLine(uses5, String.class, new Integer[] { 209 });
		assertContainsSourceLine(uses5, IllegalArgumentException.class,
				new Integer[] { 198 });
		// Inner class allocations
		Type type6 = this.repository
				.lookupType(ClassWithMultipleAllocations.Inner.class);
		Map<Type, Collection<Integer>> uses6 = this.repository.getUses(type6);
		assertEquals(15 + 1, uses6.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses6, Boolean.class, new Integer[] { 108 });
		assertContainsSourceLine(uses6, WMLAnchorElementImpl.class,
				new Integer[] { 109 });
		assertContainsSourceLine(uses6, ClassA.class, new Integer[] { 112 });
		assertContainsSourceLine(uses6, StringBuffer.class,
				new Integer[] { 113 });
		assertContainsSourceLine(uses6, ConcatFilter.class,
				new Integer[] { 117 });
		assertContainsSourceLine(uses6,
				ClassWithMultipleAllocations.class.getName() + "$Inner$1",
				new Integer[] { 121 });
		assertContainsSourceLine(uses6, Vector.class, new Integer[] { 143 });
		assertContainsSourceLine(uses6, Font.class, new Integer[] { 145 });
		assertContainsSourceLine(uses6, FileDescriptor.class,
				new Integer[] { 151 });
		assertContainsSourceLine(uses6, Socket.class, new Integer[] { 156 });
		assertContainsSourceLine(uses6, String.class, new Integer[] { 112 });
		assertContainsSourceLine(uses6, System.class, new Integer[] { 113, 117,
				143, 145, 151, 157 });
		assertContainsSourceLine(uses6, PrintStream.class, new Integer[] { 113,
				117, 143, 145, 151, 157 });
		assertContainsSourceLine(uses6, int.class.getName(), new Integer[] {
				156, 157 });
		assertContainsSourceLine(uses6, Exception.class, new Integer[] { 144 });
		// Nested inner class allocations
		Type type7 = this.repository
				.lookupType(ClassWithMultipleAllocations.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> uses7 = this.repository.getUses(type7);
		assertEquals(14 + 1, uses7.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses7, Frame.class, new Integer[] { 62 });
		assertContainsSourceLine(uses7, Canvas.class, new Integer[] { 65 });
		assertContainsSourceLine(uses7, Checkbox.class, new Integer[] { 69 });
		assertContainsSourceLine(uses7,
				ClassWithMultipleAllocations.class.getName()
						+ "$Inner$NestedInner$1", new Integer[] { 73 });
		assertContainsSourceLine(uses7, BasicStroke.class, new Integer[] { 87 });
		assertContainsSourceLine(uses7, AWTException.class, new Integer[] { 85,
				89 });
		assertContainsSourceLine(uses7, BufferedInputStream.class,
				new Integer[] { 95 });
		assertContainsSourceLine(uses7, InstantiationError.class,
				new Integer[] { 100 });
		assertContainsSourceLine(uses7, System.class, new Integer[] { 65, 69,
				87, 95, 102 });
		assertContainsSourceLine(uses7, PrintStream.class, new Integer[] { 65,
				69, 87, 95, 102 });
		assertContainsSourceLine(uses7, String.class, new Integer[] { 101, 73 });
		assertContainsSourceLine(uses7, IllegalStateException.class,
				new Integer[] { 88 });
		assertContainsSourceLine(uses7, int.class.getName(), new Integer[] {
				100, 102 });
		assertContainsSourceLine(uses7, ClassA.class, new Integer[] { 101 });
		// Main class throws
		Type type8 = this.repository.lookupType(ClassWithMultipleThrows.class);
		Map<Type, Collection<Integer>> uses8 = this.repository.getUses(type8);
		assertEquals(15 + 1, uses8.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses8, DataFormatException.class,
				new Integer[] { 158, 159 });
		assertContainsSourceLine(uses8, UnmodifiableClassException.class,
				new Integer[] { 162 });
		assertContainsSourceLine(uses8, UnmodifiableSetException.class,
				new Integer[] { 163 });
		assertContainsSourceLine(uses8, UnsupportedClassVersionError.class,
				new Integer[] { 166 });
		assertContainsSourceLine(
				uses8,
				ar.com.fluxit.jqa.mock.sub.ClassWithMultipleThrows.class
						.getName() + "$1", new Integer[] { 167 });
		assertContainsSourceLine(uses8, System.class,
				new Integer[] { 188, 202 });
		assertContainsSourceLine(uses8, PrintStream.class, new Integer[] { 188,
				202 });
		assertContainsSourceLine(uses8, int.class.getName(), new Integer[] {
				201, 202 });
		assertContainsSourceLine(uses8, TransformerException.class,
				new Integer[] { 186, 190 });
		assertContainsSourceLine(uses8, DecimalFormat.class,
				new Integer[] { 188 });
		assertContainsSourceLine(uses8, Exception.class, new Integer[] { 189 });
		assertContainsSourceLine(uses8, TimeoutException.class, new Integer[] {
				194, 196 });
		assertContainsSourceLine(uses8, SQLException.class,
				new Integer[] { 200 });
		assertContainsSourceLine(uses8, Double.class, new Integer[] { 201 });
		assertContainsSourceLine(uses8, Helper.class, new Integer[] { 207 });
		// Inner class throws
		Type type9 = this.repository
				.lookupType(ClassWithMultipleThrows.Inner.class);
		Map<Type, Collection<Integer>> uses9 = this.repository.getUses(type9);
		assertEquals(10 + 1, uses9.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses9, InnerException.class, new Integer[] {
				99, 100 });
		assertContainsSourceLine(uses9, AWTException.class, new Integer[] {
				103, 104 });
		assertContainsSourceLine(uses9, ClassWithMultipleThrows.class.getName()
				+ "$Inner$1", new Integer[] { 108 });
		assertContainsSourceLine(uses9, BadPaddingException.class,
				new Integer[] { 135 });
		assertContainsSourceLine(uses9, Exception.class, new Integer[] { 136 });
		assertContainsSourceLine(uses9, IllegalAccessError.class,
				new Integer[] { 137 });
		assertContainsSourceLine(uses9, CloneNotSupportedException.class,
				new Integer[] { 141, 143 });
		assertContainsSourceLine(uses9, UnsupportedClassVersionError.class,
				new Integer[] { 147 });
		assertContainsSourceLine(uses9, UnsupportedOperationException.class,
				new Integer[] { 149 });
		assertContainsSourceLine(uses9, Helper.class, new Integer[] { 154 });
		// Nested inner class throws
		Type type10 = this.repository
				.lookupType(ClassWithMultipleThrows.Inner.NestedInner.class);
		Map<Type, Collection<Integer>> uses10 = this.repository.getUses(type10);
		assertEquals(11 + 1, uses10.size()); // 1 is java.lang.Object
		assertContainsSourceLine(uses10, IllegalArgumentException.class,
				new Integer[] { 57 });
		assertContainsSourceLine(uses10, ExceptionA.class, new Integer[] { 60,
				61 });
		assertContainsSourceLine(uses10, String.class, new Integer[] { 65 });
		assertContainsSourceLine(uses10,
				ClassWithMultipleThrows.class.getName()
						+ "$Inner$NestedInner$1", new Integer[] { 65 });
		assertContainsSourceLine(uses10, AWTException.class, new Integer[] {
				77, 81 });
		assertContainsSourceLine(uses10, IllegalComponentStateException.class,
				new Integer[] { 79 });
		assertContainsSourceLine(uses10, Exception.class, new Integer[] { 80,
				85, 87 });
		assertContainsSourceLine(uses10, InstantiationError.class,
				new Integer[] { 91, 94 });
		assertContainsSourceLine(uses10, System.class, new Integer[] { 93 });
		assertContainsSourceLine(uses10, PrintStream.class,
				new Integer[] { 93 });
		assertContainsSourceLine(uses10, int.class.getName(), new Integer[] {
				92, 93 });
	}

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

}
