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

import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.descriptor.ArchitectureDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;
import ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate;
import ar.com.fluxit.jqa.schema.ruleset.NotPredicate;
import ar.com.fluxit.jqa.schema.ruleset.Rule;
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;
import ar.com.fluxit.jqa.schema.ruleset.TruePredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class AllocationRulesContextFileBuilder extends AbstractRulesContextFileBuilder {

	private static final int DEFAULT_ALLOCATION_PRIORITY = 2;
	public static RulesContextFileBuilder INSTANCE = new AllocationRulesContextFileBuilder();

	private AllocationRulesContextFileBuilder() {
		// hides the constructor
	}

	private void buildAllocationRule(Ruleset ruleSet, LayerDescriptor layer) {
		if (!layer.isAllocable()) {
			Rule rule = ruleSet.addNewRule();
			rule.setName(layer.getName() + " allocation");
			rule.setMessage("The " + layer.getName()
					+ " '${type.name}' can not be allocated'");
			rule.setPriority(DEFAULT_ALLOCATION_PRIORITY);
			rule.setFilterPredicate(TruePredicate.Factory.newInstance());
			AllocationPredicate allocationPredicate = AllocationPredicate.Factory
					.newInstance();
			NotPredicate notPredicate = NotPredicate.Factory.newInstance();
			notPredicate.setPredicate(getLayerFilterPredicate(layer));
			allocationPredicate.setPredicate(notPredicate);
			rule.setCheckPredicate(allocationPredicate);
		}
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
			rulesContext.setName("Allocation rules context");
			Ruleset ruleSet = rulesContext.addNewRuleSet();
			ruleSet.setName("Allocation ruleset");
			for (LayerDescriptor layer : archDescriptor.getLayers()) {
				buildAllocationRule(ruleSet, layer);
			}
			rulesContextDoc.save(new File(targetFile.getParentFile(),
					"allocation.xml"));
		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

}
