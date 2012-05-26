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
package ar.com.fluxit.jqa.mock.allocation;

import java.util.Iterator;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithInnerClassAllocations {

	public static class Inner {

		Inner inner = new Inner();

		public Inner() {
			System.out.println(new Inner());
		}

		public void dummy() {
			System.out.println(new Inner());
		}
	}

	static Inner inner2 = new Inner();

	Inner inner = new Inner();

	public ClassWithInnerClassAllocations() {
		System.out.println(new Inner());
	}

	public void dummy() {
		System.out.println(new Inner());
	}

	public void dummy2() {
		new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				System.out.println(new Inner());
				return null;
			}

		};
	}

	public void dummy3() {
		try {
			System.out.println(new Inner());
		} catch (Exception e) {
			System.out.println(new Inner());
		}
	}

	public void dummy4() {
		if (true) {
			System.out.println(new Inner());
		}
	}

	public void dummy5() {
		for (int i = 0; true; new Inner()) {
			System.out.println(i);
		}
	}

	public void dummy6() {
		System.out.println(new Inner[] {});
	}

}
