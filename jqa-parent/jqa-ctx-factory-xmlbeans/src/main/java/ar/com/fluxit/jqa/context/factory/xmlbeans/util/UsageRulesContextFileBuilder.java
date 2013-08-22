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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.descriptor.ArchitectureDescriptor;
import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;
import ar.com.fluxit.jqa.schema.ruleset.OrPredicate;
import ar.com.fluxit.jqa.schema.ruleset.Predicate;
import ar.com.fluxit.jqa.schema.ruleset.Rule;
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;
import ar.com.fluxit.jqa.schema.ruleset.TypingPredicate;
import ar.com.fluxit.jqa.schema.ruleset.UsagePredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class UsageRulesContextFileBuilder extends AbstractRulesContextFileBuilder {

	private static final int DEFAULT_USAGE_PRIORITY = 2;
	public static RulesContextFileBuilder INSTANCE = new UsageRulesContextFileBuilder();

	private UsageRulesContextFileBuilder() {
		// hides the constructor
	}

	@Override
	public void buildRulesContextFile(File targetFile,
			ArchitectureDescriptor archDescriptor)
			throws RulesContextFactoryException {
		try {
			RulesContextDocument rulesContextDoc = RulesContextDocument.Factory
					.newInstance();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext rulesContext = rulesContextDoc
					.addNewRulesContext();
			rulesContext.setName("Usage rules context");
			Ruleset ruleSet = rulesContext.addNewRuleSet();
			ruleSet.setName("Usage ruleset");
			for (LayerDescriptor layer : archDescriptor.getLayers()) {
				buildTypingRule(ruleSet, layer);
			}
			rulesContextDoc.save(new File(targetFile.getParentFile(),
					"usage.xml"));
		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

	private void buildTypingRule(Ruleset ruleSet, LayerDescriptor layer) {
		Rule rule = ruleSet.addNewRule();
		rule.setName(layer.getName() + " usage");
		rule.setMessage("The " + layer.getName()
				+ " '${type.name}' has an invalid usage.");
		rule.setPriority(DEFAULT_USAGE_PRIORITY);
		rule.setFilterPredicate(getLayerFilterPredicate(layer));
		UsagePredicate usagePredicate = UsagePredicate.Factory.newInstance();
		OrPredicate orPredicate = OrPredicate.Factory.newInstance();
		orPredicate.setPredicateArray(getUsages(layer));
		usagePredicate.setPredicate(orPredicate);
		rule.setCheckPredicate(usagePredicate);
	}

	private Predicate[] getUsages(LayerDescriptor layer) {
		Collection<Predicate> result = new ArrayList<Predicate>();
		// JRE types
		result.add(getNamingPredicate("java.**"));
		// Reflection
		result.add(getLayerFilterPredicate(layer));
		// Common types
		for (CommonDescriptor common : layer.getCommons()) {
			if (common.isCommon()) {
				result.add(getNamingPredicate(common.getTypeName() + ".**"));
			}
		}
		// Layer usages
		for (LayerDescriptor layerUsage : layer.getUsages()) {
			if (layerUsage.isHasApi()) {
				result.add(getAndPredicate(getLayerFilterPredicate(layerUsage),
						getInterfaceAbstractionPredicate()));
			} else {
				result.add(getLayerFilterPredicate(layerUsage));
			}
			if (layerUsage.getExceptionSuperType() != null
					&& !"java.lang.Exception".equals(layerUsage
							.getExceptionSuperType())) {
				TypingPredicate typingPredicate = TypingPredicate.Factory
						.newInstance();
				typingPredicate.setPredicate(getNamingPredicate(layerUsage
						.getExceptionSuperType()));
				result.add(typingPredicate);
			}
		}
		// Layer supertype
		if (layer.getSuperType() != null
				&& !layer.getSuperType().equals(Object.class.getName())) {
			result.add(getNamingPredicate(layer.getSuperType()));
		}
		// Layer exception supertype
		if (layer.getExceptionSuperType() != null
				&& !layer.getExceptionSuperType().equals(
						Exception.class.getName())) {
			result.add(getNamingPredicate(layer.getExceptionSuperType()));
		}
		return result.toArray(new Predicate[result.size()]);
	}
}
