/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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
package ar.com.fluxit.jqa.mock.sub;

import java.awt.AWTException;
import java.awt.Choice;
import java.awt.IllegalComponentStateException;
import java.awt.PopupMenu;
import java.lang.instrument.UnmodifiableClassException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import java.util.prefs.BackingStoreException;
import java.util.zip.DataFormatException;

import javax.crypto.BadPaddingException;
import javax.print.attribute.UnmodifiableSetException;
import javax.xml.transform.TransformerException;

import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.ExceptionA;
import ar.com.fluxit.jqa.mock.Helper;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithMultipleThrows {

	public static class Inner {

		public class InnerException extends Exception {
			private static final long serialVersionUID = 1L;
		}

		public class NestedInner {

			public NestedInner() {
				throw new IllegalArgumentException();
			}

			public void dummy() throws ExceptionA {
				throw new ExceptionA();
			}

			public void dummy2() {
				new Choice() {

					private static final long serialVersionUID = 1L;

					@Override
					public synchronized void add(PopupMenu popup) {
						throw new IllegalAccessError();
					}

				}.toString();
			}

			public void dummy3() throws AWTException {
				try {
					throw new IllegalComponentStateException();
				} catch (Exception e) {
					throw new AWTException("");
				}
			}

			public void dummy4() throws Exception {
				if (true) {
					throw new Exception();
				}
			}

			public void dummy5() throws InstantiationError {
				for (int i = 0; true;) {
					System.out.println(i);
					throw new InstantiationError();
				}
			}
		}

		public Inner() throws InnerException {
			throw new InnerException();
		}

		public void dummy() throws AWTException {
			throw new AWTException("");
		}

		public void dummy2() {
			new Iterator<String>() {

				@Override
				public boolean hasNext() {
					try {
						throw new BackingStoreException("");
					} catch (BackingStoreException e) {
						e.printStackTrace();
					}
					return false;
				}

				@Override
				public String next() {
					throw new IllegalStateException();
				}

				@Override
				public void remove() {
					throw new IllegalArgumentException();
				}

			};
		}

		public void dummy3() {
			try {
				throw new BadPaddingException();
			} catch (Exception e) {
				throw new IllegalAccessError();
			}
		}

		public void dummy4() throws CloneNotSupportedException {
			if (true) {
				throw new CloneNotSupportedException();
			}
		}

		public void dummy5() throws UnsupportedClassVersionError {
			for (; true;) {
				throw new UnsupportedOperationException();
			}
		}

		public void dummy6() {
			Helper.dummy();
		}
	}

	public ClassWithMultipleThrows() throws DataFormatException {
		throw new DataFormatException();
	}

	public void dummy() throws UnmodifiableClassException {
		throw new UnmodifiableSetException();
	}

	public void dummy2() throws UnsupportedClassVersionError {
		new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				System.out.println(new ClassA());
				new Comparable<String>() {

					@Override
					public int compareTo(String o) {
						throw new IllegalArgumentException();
					}

				}.compareTo(null);
				throw new IllegalArgumentException();
			}

		};
	}

	public void dummy3() throws TransformerException {
		try {
			System.out.println(new DecimalFormat()); // isnt a throw
		} catch (Exception e) {
			throw new TransformerException("");
		}
	}

	public void dummy4() throws TimeoutException {
		if (true) {
			throw new TimeoutException();
		}
	}

	public void dummy5() throws SQLException {
		for (int i = 0; true; new Double("")) {
			System.out.println(i);
		}
	}

	public void dummy6() {
		Helper.dummy2();
	}
}
