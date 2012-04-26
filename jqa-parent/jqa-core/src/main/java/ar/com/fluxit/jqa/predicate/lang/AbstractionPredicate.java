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
package ar.com.fluxit.jqa.predicate.lang;

import ar.com.fluxit.jqa.bce.Type;
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
			public boolean evaluate(Type type) {
				return type.isAbstract();
			}
		},
		INTERFACE() {
			@Override
			public boolean evaluate(Type type) {
				return type.isInterface();
			}
		},
		CONCRETE() {
			@Override
			public boolean evaluate(Type type) {
				return !(type.isAbstract() || type.isInterface());
			}
		};

		abstract boolean evaluate(Type type);
	}

	private AbstractionType abstractionType;

	@Override
	public boolean evaluate(Type type) {
		return getAbstractionType().evaluate(type);
	}

	public AbstractionType getAbstractionType() {
		return abstractionType;
	}

	public void setAbstractionType(AbstractionType abstractionType) {
		this.abstractionType = abstractionType;
	}

}
