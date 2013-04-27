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

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.PopupMenu;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.parsers.FactoryConfigurationError;

import net.sourceforge.pmd.FileDataSource;
import nu.xom.Attribute;
import nu.xom.DocType;

import org.apache.bcel.verifier.GraphicalVerifier;
import org.apache.tools.ant.filters.ConcatFilter;
import org.apache.wml.dom.WMLAnchorElementImpl;
import org.apache.wml.dom.WMLImgElementImpl;

import ar.com.fluxit.jqa.mock.ClassA;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ClassWithMultipleAllocations {

	public static class Inner {

		public class NestedInner {
			Frame aFrame = new Frame();

			public NestedInner() {
				System.out.print(new Canvas());
			}

			public void dummy() {
				System.out.println(new Checkbox());
			}

			public void dummy2() {
				new Choice() {

					private static final long serialVersionUID = 1L;

					@Override
					public synchronized void add(PopupMenu popup) {
						new Color(1);
					}

				}.toString();
			}

			public void dummy3() throws AWTException {
				try {
					System.out.println(new BasicStroke());
				} catch (IllegalStateException e) {
					throw new AWTException("");
				}
			}

			public void dummy4() {
				if (true) {
					System.out.println(new BufferedInputStream(null));
				}
			}

			public void dummy5() {
				for (int i = 0; true; new InstantiationError()) {
					new ClassA().toString();
					System.out.println(i);
				}
			}

		}

		static Boolean aBoolean = new Boolean("");
		WMLAnchorElementImpl anElement = new WMLAnchorElementImpl(null, null);

		public Inner() {
			new ClassA().toString();
			System.out.println(new StringBuffer(""));
		}

		public void dummy() {
			System.out.println(new ConcatFilter(null));
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

		public void dummy3() {
			try {
				System.out.println(new Vector<Object>());
			} catch (Exception e) {
				System.out.println(new Font(null));
			}
		}

		public void dummy4() {
			if (true) {
				System.out.println(new FileDescriptor());
			}
		}

		public void dummy5() {
			for (int i = 0; true; new Socket()) {
				System.out.println(i);
			}
		}
	}

	static File aFile = new File("");

	WMLImgElementImpl anElement = new WMLImgElementImpl(null, null);

	public ClassWithMultipleAllocations() {
		System.out.println(new FactoryConfigurationError(""));
	}

	public void dummy() {
		System.out.println(new Attribute(null));
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

	public void dummy3() {
		try {
			System.out.println(new DecimalFormat());
		} catch (IllegalArgumentException e) {
			System.out.println(new Label());
		}
	}

	public void dummy4() {
		if (true) {
			System.out.println(new FileDataSource(null));
		}
	}

	public void dummy4(String a) {
		for (int i = 0; true; new Double("")) {
			System.out.println(i);
		}
	}

}
