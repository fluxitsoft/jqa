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
public class ClassWithAnonymousClassAllocation {

	public static class Inner {

		public Inner() {
			new Iterable<String>() {

				@Override
				public Iterator<String> iterator() {
					return null;
				}
			};
		}

		public void dummy() {
			new Iterable<String>() {

				@Override
				public Iterator<String> iterator() {
					return null;
				}
			};
		}
	}

	Iterable<String> anonymous = new Iterable<String>() {

		@Override
		public Iterator<String> iterator() {
			return null;
		}
	};

	public ClassWithAnonymousClassAllocation() {
		new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				return null;
			}
		};
	}

	public void dummy() {
		new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				return null;
			}
		};
	}

}
