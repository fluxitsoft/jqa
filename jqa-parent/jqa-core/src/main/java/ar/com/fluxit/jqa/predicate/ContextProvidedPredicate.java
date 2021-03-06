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
package ar.com.fluxit.jqa.predicate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ContextProvidedPredicate extends AbstractPredicate {

	private String providedPredicateName;

	public ContextProvidedPredicate() {
		super();
	}

	public ContextProvidedPredicate(String providedPredicateName) {
		super();
		this.providedPredicateName = providedPredicateName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof ContextProvidedPredicate) {
			ContextProvidedPredicate other = (ContextProvidedPredicate) obj;
			return new EqualsBuilder()
					.append(this.getProvidedPredicateName(),
							other.getProvidedPredicateName())
					.append(this.getName(), other.getName()).isEquals();
		} else {
			return false;
		}
	}

	@Override
	public final boolean evaluate(Type type, RulesContext context) {
		final Predicate providedPredicate = context
				.getGlobalPredicate(getProvidedPredicateName());
		if (providedPredicate == null) {
			throw new IllegalStateException(
					"Inexistent global predicate with name: "
							+ getProvidedPredicateName());
		}
		return providedPredicate.evaluate(type, context);
	}

	public String getProvidedPredicateName() {
		return providedPredicateName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getName())
				.append(getProvidedPredicateName()).hashCode();
	}

	public void setProvidedPredicateName(String providedPredicateName) {
		this.providedPredicateName = providedPredicateName;
	}

	@Override
	public String toString() {
		return "ContextProvidedPredicate [providedPredicateName="
				+ providedPredicateName + ", name=" + getName() + "]";
	}

}
