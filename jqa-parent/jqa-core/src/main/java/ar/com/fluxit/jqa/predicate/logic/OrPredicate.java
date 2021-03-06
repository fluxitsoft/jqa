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

import java.util.Arrays;
import java.util.Collection;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class OrPredicate extends VarArgsLogicPredicate {

	public OrPredicate() {
		super();
	}

	public OrPredicate(Collection<Predicate> predicates) {
		super(predicates);
	}

	public OrPredicate(Predicate... predicates) {
		super(Arrays.asList(predicates));
	}

	@Override
	public boolean evaluate(Type type, RulesContext context) {
		for (final Predicate predicate : getPredicates()) {
			if (predicate.evaluate(type, context)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer predicates = new StringBuffer();
		for (Predicate predicate : getPredicates()) {
			if (predicates.length() != 0) {
				predicates.append(", ");
			}
			predicates.append(predicate);
		}
		return "OrPredicate: [" + predicates + "]";
	}

}
