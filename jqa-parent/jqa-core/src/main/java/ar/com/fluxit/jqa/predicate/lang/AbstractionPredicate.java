/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
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
package ar.com.fluxit.jqa.predicate.lang;

import java.io.File;
import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.CheckPredicate;
import ar.com.fluxit.jqa.predicate.IgnoringContextPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AbstractionPredicate extends IgnoringContextPredicate implements
		CheckPredicate {

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
		CLASS() {
			@Override
			public boolean evaluate(Type type) {
				return !type.isInterface();
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

	public AbstractionPredicate() {

	}

	public AbstractionPredicate(AbstractionType abstractionType) {
		this.abstractionType = abstractionType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof AbstractionPredicate) {
			AbstractionPredicate other = (AbstractionPredicate) obj;
			return new EqualsBuilder().append(getName(), other.getName())
					.append(getAbstractionType(), other.getAbstractionType())
					.isEquals();
		} else {
			return false;
		}
	}

	@Override
	public boolean evaluate(Type type) {
		return getAbstractionType().evaluate(type);
	}

	public AbstractionType getAbstractionType() {
		return this.abstractionType;
	}

	@Override
	public Collection<Integer> getViolationLineIds(Type type,
			File[] sourcesDir, RulesContext context) {
		return getDeclarationLineNumber(type, sourcesDir);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName())
				.append(getAbstractionType()).hashCode();
	}

	public void setAbstractionType(AbstractionType abstractionType) {
		this.abstractionType = abstractionType;
	}

	@Override
	public String toString() {
		return "AbstractionPredicate [abstractionType=" + abstractionType
				+ ", name=" + getName() + "]";
	}

}
