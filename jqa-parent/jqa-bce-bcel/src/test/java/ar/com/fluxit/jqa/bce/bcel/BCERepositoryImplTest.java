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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Font;
import java.awt.Label;
import java.io.File;
import java.io.FileDescriptor;
import java.net.Socket;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.xml.parsers.FactoryConfigurationError;

import net.sourceforge.pmd.FileDataSource;
import nu.xom.Attribute;
import nu.xom.DocType;

import org.apache.tools.ant.filters.ConcatFilter;
import org.apache.wml.dom.WMLAnchorElementImpl;
import org.apache.wml.dom.WMLImgElementImpl;
import org.junit.Test;

import ar.com.fluxit.jqa.bce.BCERepository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation;
import ar.com.fluxit.jqa.mock.allocation.ClassWithClassAAllocations;
import ar.com.fluxit.jqa.mock.allocation.ClassWithInnerClassAllocations;
import ar.com.fluxit.jqa.mock.allocation.ClassWithMultipleAllocations;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class BCERepositoryImplTest {

	private final BCERepository repository;
	private final File sourcesDir;

	public BCERepositoryImplTest() {
		this.repository = new BCERepositoryImpl();
		this.repository.setJavaVersion("1.5");
		this.sourcesDir = new File(System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar + "test" + File.separatorChar + "java");
	}

	@Test
	public void testGetAllocationLineNumbers() throws ClassNotFoundException, URISyntaxException {
		// Allocations of simple class
		final Type type = this.repository.lookupType(ClassWithClassAAllocations.class);
		final Type allocatedType = this.repository.lookupType(ClassA.class);
		final Collection<Integer> allocationLineNumbers = this.repository.getAllocationLineNumbers(type, allocatedType, this.sourcesDir);
		assertEquals(10, allocationLineNumbers.size());
		final Integer[] allocationLineNumbersArray = allocationLineNumbers.toArray(new Integer[] {});
		Arrays.sort(allocationLineNumbersArray);
		assertArrayEquals(allocationLineNumbersArray, new Integer[] { 45, 47, 50, 54, 62, 71, 73, 79, 84, 90 });
		// Allocations of inner class
		final Type type2 = this.repository.lookupType(ClassWithInnerClassAllocations.class);
		final Type allocatedType2 = this.repository.lookupType(ClassWithInnerClassAllocations.Inner.class);
		Collection<Integer> allocationLineNumbers2 = this.repository.getAllocationLineNumbers(type2, allocatedType2, this.sourcesDir);
		assertEquals(10, allocationLineNumbers2.size());
		final Integer[] allocationLineNumbersArray2 = allocationLineNumbers2.toArray(new Integer[] {});
		Arrays.sort(allocationLineNumbersArray2);
		assertArrayEquals(allocationLineNumbersArray2, new Integer[] { 43, 45, 48, 52, 60, 69, 71, 77, 82, 88 });
		// Allocations of anonymous class
		final Type type3 = this.repository.lookupType(ClassWithAnonymousClassAllocation.class);
		Collection<Integer> allocationLineNumbers3 = this.repository.getAllocationLineNumbers(type3,
				this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation$1"), this.sourcesDir);
		assertArrayEquals(allocationLineNumbers3.toArray(), new Integer[] { 53 });
		allocationLineNumbers3 = this.repository.getAllocationLineNumbers(type3,
				this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation$2"), this.sourcesDir);
		assertArrayEquals(allocationLineNumbers3.toArray(), new Integer[] { 62 });
		allocationLineNumbers3 = this.repository.getAllocationLineNumbers(type3,
				this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation$3"), this.sourcesDir);
		assertArrayEquals(allocationLineNumbers3.toArray(), new Integer[] { 72 });
		// Allocations of inner class
		final Type type4 = this.repository.lookupType(ClassWithAnonymousClassAllocation.Inner.class);
		Collection<Integer> allocationLineNumbers4 = this.repository.getAllocationLineNumbers(type4,
				this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation$Inner$1"), this.sourcesDir);
		assertArrayEquals(allocationLineNumbers4.toArray(), new Integer[] { 33 });
		allocationLineNumbers4 = this.repository.getAllocationLineNumbers(type4,
				this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithAnonymousClassAllocation$Inner$2"), this.sourcesDir);
		assertArrayEquals(allocationLineNumbers4.toArray(), new Integer[] { 43 });
	}

	@Test
	public void testGetAllocations() throws ClassNotFoundException {
		Type type = this.repository.lookupType(ClassWithMultipleAllocations.class);
		Collection<Type> allocations = this.repository.getAllocations(type);
		assertEquals(10, allocations.size());
		assertTrue(allocations.contains(this.repository.lookupType(File.class)));
		assertTrue(allocations.contains(this.repository.lookupType(WMLImgElementImpl.class)));
		assertTrue(allocations.contains(this.repository.lookupType(FactoryConfigurationError.class)));
		assertTrue(allocations.contains(this.repository.lookupType(Attribute.class)));
		assertTrue(allocations.contains(this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithMultipleAllocations$1")));
		assertTrue(allocations.contains(this.repository.lookupType(ClassA.class)));
		assertTrue(allocations.contains(this.repository.lookupType(DecimalFormat.class)));
		assertTrue(allocations.contains(this.repository.lookupType(Label.class)));
		assertTrue(allocations.contains(this.repository.lookupType(FileDataSource.class)));
		assertTrue(allocations.contains(this.repository.lookupType(Double.class)));

		Type type2 = this.repository.lookupType(ClassWithMultipleAllocations.Inner.class);
		Collection<Type> allocations2 = this.repository.getAllocations(type2);
		assertEquals(10, allocations2.size());
		assertTrue(allocations2.contains(this.repository.lookupType(Boolean.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(WMLAnchorElementImpl.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(StringBuffer.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(ConcatFilter.class)));
		assertTrue(allocations2.contains(this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithMultipleAllocations$Inner$1")));
		assertTrue(allocations2.contains(this.repository.lookupType(DocType.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(Vector.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(Font.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(FileDescriptor.class)));
		assertTrue(allocations2.contains(this.repository.lookupType(Socket.class)));
	}

	@Test
	public void testGetDeclarationLineNumber() throws ClassNotFoundException {
		Type type = this.repository.lookupType(ClassWithMultipleAllocations.class);
		assertEquals(47, (int) this.repository.getDeclarationLineNumber(type, this.sourcesDir));
		Type type2 = this.repository.lookupType(ClassWithMultipleAllocations.Inner.class);
		assertEquals(49, (int) this.repository.getDeclarationLineNumber(type2, this.sourcesDir));
		Type type3 = this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithMultipleAllocations$Inner$1");
		assertEquals(63, (int) this.repository.getDeclarationLineNumber(type3, this.sourcesDir));
		Type type4 = this.repository.lookupType("ar.com.fluxit.jqa.mock.allocation.ClassWithMultipleAllocations$1");
		assertEquals(116, (int) this.repository.getDeclarationLineNumber(type4, this.sourcesDir));
	}

	// @Test
	// public void testGetInterfaces() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetSourceFile() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetSuperClasses() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetThrowLineNumbers() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetThrows() {
	// fail("Not yet implemented");
	// }
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
