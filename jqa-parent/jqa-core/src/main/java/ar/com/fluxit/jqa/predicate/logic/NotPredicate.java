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
package ar.com.fluxit.jqa.predicate.logic;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.AbstractPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NotPredicate extends AbstractPredicate {

	private Predicate predicate;

	public NotPredicate() {
		super();
	}

	public NotPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof NotPredicate) {
			NotPredicate other = (NotPredicate) obj;
			return new EqualsBuilder().append(getName(), other.getName())
					.append(getPredicate(), other.getPredicate()).isEquals();
		} else {
			return false;
		}
	}

	@Override
	public boolean evaluate(Type type, RulesContext context) {
		return !getPredicate().evaluate(type, context);
	}

	public Predicate getPredicate() {
		return predicate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getPredicate())
				.hashCode();
	}

	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

}
