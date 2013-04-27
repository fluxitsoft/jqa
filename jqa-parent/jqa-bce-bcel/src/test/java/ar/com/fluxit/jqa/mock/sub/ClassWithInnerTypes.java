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
package ar.com.fluxit.jqa.mock.sub;

import java.awt.Choice;
import java.awt.Color;
import java.awt.PopupMenu;
import java.util.Iterator;

import nu.xom.DocType;

import org.apache.bcel.verifier.GraphicalVerifier;

import ar.com.fluxit.jqa.mock.ClassA;


/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithInnerTypes {

	public enum EnumA {

	}

	public static class Inner {

		public class NestedInner {

			public void dummy2() {
				new Choice() {

					private static final long serialVersionUID = 1L;

					@Override
					public synchronized void add(PopupMenu popup) {
						new Color(1);
					}

				}.toString();
			}

		}

		public void dummy2() {
			new Iterator<String>() {

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public String next() {
					return new DocType("").toString();
				}

				@Override
				public void remove() {

				}

			};
		}

	}

	public void dummy2() {
		new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				System.out.println(new ClassA());
				new Comparable<String>() {

					@Override
					public int compareTo(String o) {
						new GraphicalVerifier().hashCode();
						return 0;
					}

				}.compareTo(null);
				return null;
			}

		};
	}

}
