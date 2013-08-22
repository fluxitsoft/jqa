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

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class FilteredPredicate extends AbstractPredicate {

	protected Predicate filterPredicate;

	public FilteredPredicate() {
		super();
	}

	public FilteredPredicate(Predicate filterPredicate) {
		super();
		this.filterPredicate = filterPredicate;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!obj.getClass().equals(this.getClass())) {
			return false;
		}
		FilteredPredicate other = (FilteredPredicate) obj;
		return new EqualsBuilder().append(getName(), other.getName())
				.append(getFilterPredicate(), other.getFilterPredicate())
				.isEquals();
	}

	public Predicate getFilterPredicate() {
		return filterPredicate;
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(getName())
				.append(getFilterPredicate()).hashCode();
	}

	public void setFilterPredicate(Predicate filterPredicate) {
		this.filterPredicate = filterPredicate;
	}

}
