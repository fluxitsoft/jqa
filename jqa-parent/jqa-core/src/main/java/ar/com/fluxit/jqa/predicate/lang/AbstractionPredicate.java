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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.predicate.lang;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.predicate.IgnoringContextPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AbstractionPredicate extends IgnoringContextPredicate {

	public enum AbstractionType {
		ABSTRACT() {
			@Override
			public boolean evaluate(JavaClass clazz) {
				return clazz.isAbstract();
			}
		},
		INTERFACE() {
			@Override
			public boolean evaluate(JavaClass clazz) {
				return clazz.isInterface();
			}
		},
		CONCRETE() {
			@Override
			public boolean evaluate(JavaClass clazz) {
				return !(clazz.isAbstract() || clazz.isInterface());
			}
		};

		abstract boolean evaluate(JavaClass clazz);
	}

	private AbstractionType abstractionType;

	public AbstractionPredicate(AbstractionType abstractionType) {
		super();
		this.abstractionType = abstractionType;
	}

	@Override
	public boolean evaluate(JavaClass clazz) {
		return getAbstractionType().evaluate(clazz);
	}

	public AbstractionType getAbstractionType() {
		return abstractionType;
	}

	public void setAbstractionType(AbstractionType abstractionType) {
		this.abstractionType = abstractionType;
	}

}
