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

import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ar.com.fluxit.jqa.predicate.AbstractPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class VarArgsLogicPredicate extends AbstractPredicate {

	private Collection<Predicate> predicates;

	public VarArgsLogicPredicate() {
		super();
	}

	public VarArgsLogicPredicate(Collection<Predicate> predicates) {
		super();
		this.predicates = predicates;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		VarArgsLogicPredicate other = (VarArgsLogicPredicate) obj;
		return new EqualsBuilder().append(this.getName(), other.getName())
				.append(getPredicates(), other.getPredicates()).isEquals();
	}

	public Collection<Predicate> getPredicates() {
		return predicates;
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(getName()).append(getPredicates())
				.hashCode();
	}

	public void setPredicates(Collection<Predicate> predicates) {
		this.predicates = predicates;
	}

}
