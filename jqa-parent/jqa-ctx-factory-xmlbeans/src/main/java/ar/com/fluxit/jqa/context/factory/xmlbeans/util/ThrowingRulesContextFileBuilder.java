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
import ar.com.fluxit.jqa.schema.ruleset.Rule;
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;
import ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class ThrowingRulesContextFileBuilder extends AbstractRulesContextFileBuilder {

	private static final int DEFAULT_THROWING_PRIORITY = 3;
	public static RulesContextFileBuilder INSTANCE = new ThrowingRulesContextFileBuilder();

	private ThrowingRulesContextFileBuilder() {
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
			rulesContext.setName("Throwing rules context");
			Ruleset ruleSet = rulesContext.addNewRuleSet();
			ruleSet.setName("Throwing ruleset");
			for (LayerDescriptor layer : archDescriptor.getLayers()) {
				buildThrowingRule(ruleSet, layer);
			}
			rulesContextDoc.save(new File(targetFile.getParentFile(),
					"throwing.xml"));
		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

	private void buildThrowingRule(Ruleset ruleSet, LayerDescriptor layer) {
		if (layer.getExceptionSuperType() != null
				&& !layer.getExceptionSuperType().equals(
						Exception.class.getName())) {
			Rule rule = ruleSet.addNewRule();
			rule.setName(layer.getName() + " throwing");
			rule.setMessage("The " + layer.getName()
					+ " '${type.name}' has an invalid throwing. A "
					+ layer.getName()
					+ " must throws only exceptions that extend to '"
					+ layer.getExceptionSuperType() + "'");
			rule.setPriority(DEFAULT_THROWING_PRIORITY);
			rule.setFilterPredicate(getLayerFilterPredicate(layer));
			ThrowingPredicate throwingPredicate = ThrowingPredicate.Factory
					.newInstance();
			throwingPredicate.setPredicate(getNamingPredicate(layer
					.getExceptionSuperType()));
			rule.setCheckPredicate(throwingPredicate);
		}
	}

}
