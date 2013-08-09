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
package ar.com.fluxit.jqa.context.factory.xmlbeans.util;

import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate;
import ar.com.fluxit.jqa.schema.ruleset.AbstractionType;
import ar.com.fluxit.jqa.schema.ruleset.AndPredicate;
import ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate;
import ar.com.fluxit.jqa.schema.ruleset.NamingPredicate;
import ar.com.fluxit.jqa.schema.ruleset.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
abstract class AbstractRulesContextFileBuilder implements
		RulesContextFileBuilder {

	Predicate getAbstractAbstractionPredicate() {
		AbstractionPredicate result = AbstractionPredicate.Factory
				.newInstance();
		result.setAbstractionType(AbstractionType.ABSTRACT);
		return result;
	}

	AndPredicate getAndPredicate(Predicate... predicates) {
		AndPredicate result = AndPredicate.Factory.newInstance();
		result.setPredicateArray(predicates);
		return result;
	}

	Predicate getConcreteAbstractionPredicate() {
		AbstractionPredicate result = AbstractionPredicate.Factory
				.newInstance();
		result.setAbstractionType(AbstractionType.CONCRETE);
		return result;
	}

	Predicate getInterfaceAbstractionPredicate() {
		AbstractionPredicate result = AbstractionPredicate.Factory
				.newInstance();
		result.setAbstractionType(AbstractionType.INTERFACE);
		return result;
	}

	ContextProvidedPredicate getLayerFilterPredicate(LayerDescriptor layer) {
		ContextProvidedPredicate checkPredicate = ContextProvidedPredicate.Factory
				.newInstance();
		checkPredicate.setPredicateName(getLayerPredicateName(layer));
		return checkPredicate;
	}

	String getLayerPredicateName(LayerDescriptor layer) {
		return layer.getName().toLowerCase().trim() + "-layer";
	}

	NamingPredicate getNamingPredicate(String pattern) {
		NamingPredicate checkPredicate = NamingPredicate.Factory.newInstance();
		checkPredicate.setNamePattern(pattern);
		return checkPredicate;
	}

}
