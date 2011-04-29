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
package ar.com.fluxit.jqa.mock.usage;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithPrimitiveTypes {

	private boolean booleanField;
	private char charField;
	private float floatField;
	private double doubleField;
	private byte byteField;
	private short shortField;
	private int intField;
	private long longField;

	public ClassWithPrimitiveTypes() {
		super();
	}

	void dummy() {
		System.out.println(booleanField);
		System.out.println(charField);
		System.out.println(floatField);
		System.out.println(doubleField);
		System.out.println(byteField);
		System.out.println(shortField);
		System.out.println(intField);
		System.out.println(longField);
	}
}
