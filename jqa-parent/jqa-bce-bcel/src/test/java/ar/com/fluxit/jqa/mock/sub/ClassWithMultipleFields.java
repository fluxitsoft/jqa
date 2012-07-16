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
package ar.com.fluxit.jqa.mock.sub;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.PopupMenu;
import java.io.File;
import java.util.Iterator;

import javax.xml.parsers.FactoryConfigurationError;

import nu.xom.DocType;

import org.apache.tools.ant.filters.ConcatFilter;
import org.apache.wml.dom.WMLAnchorElementImpl;
import org.apache.wml.dom.WMLElementImpl;

import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.EnumA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithMultipleFields {

	public static class Inner {

		public class NestedInner {

			Frame aFrame;

			public void dummy2() {
				new Choice() {

					private static final long serialVersionUID = 1L;
					Checkbox checkbox;

					@Override
					public synchronized void add(PopupMenu popup) {
						this.checkbox.toString();
					}

				}.toString();
			}

		}

		public static class NestedInnerStatic {

			static WMLElementImpl wmlElementImpl;
			ConcatFilter a;

		}

		static Boolean aBoolean;

		WMLAnchorElementImpl anElement;

		public void dummy2() {
			new Iterator<String>() {

				DocType docType;

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public String next() {
					this.docType.toString();
					return "";
				}

				@Override
				public void remove() {

				}

			}.next();
		}
	}

	static File aFile;
	EnumA anElement;

	public void dummy2() {
		new Iterable<String>() {

			FactoryConfigurationError factoryConfigurationError;

			@Override
			public Iterator<String> iterator() {

				new Comparable<String>() {

					ClassA classA;

					@Override
					public int compareTo(String o) {
						this.classA.toString();
						return 0;
					}

				}.compareTo(null);
				this.factoryConfigurationError.toString();
				return null;
			}

		}.iterator();
	}

}