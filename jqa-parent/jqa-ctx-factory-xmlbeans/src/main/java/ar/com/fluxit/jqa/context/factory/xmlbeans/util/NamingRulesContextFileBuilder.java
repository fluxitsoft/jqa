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
import ar.com.fluxit.jqa.schema.ruleset.CheckPredicate;
import ar.com.fluxit.jqa.schema.ruleset.Predicate;
import ar.com.fluxit.jqa.schema.ruleset.Rule;
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class NamingRulesContextFileBuilder implements RulesContextFileBuilder {

	private static final int DEFAULT_NAMING_PRIORITY = 4;
	public static RulesContextFileBuilder INSTANCE = new NamingRulesContextFileBuilder();

	private NamingRulesContextFileBuilder() {
		// hides the constructor
	}

	private void buildAPINamingRule(Ruleset ruleSet, LayerDescriptor layer,
			String packageImplSuffix, String classImplSuffix) {
		Rule rule = ruleSet.addNewRule();

	}

	private void buildNamingRule(Ruleset ruleSet, LayerDescriptor layer,
			String packageImplSuffix, String classImplSuffix) {
		if (layer.getNamingPattern() != null) {
			if (layer.isHasApi()) {
				buildSimpleNamingRule(ruleSet, layer);
			} else {
				buildAPINamingRule(ruleSet, layer, packageImplSuffix,
						classImplSuffix);
			}
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
			rulesContext.setName("Naming rules context");
			Ruleset ruleSet = rulesContext.addNewRuleSet();
			ruleSet.setName("Naming ruleset");
			for (LayerDescriptor layer : archDescriptor.getLayers()) {
				buildNamingRule(ruleSet, layer,
						archDescriptor.getPackageImplSuffix(),
						archDescriptor.getClassImplSuffix());
			}
			rulesContextDoc.save(new File(targetFile.getParentFile(),
					"naming.xml"));
		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

	private void buildSimpleNamingRule(Ruleset ruleSet, LayerDescriptor layer) {
		Rule rule = ruleSet.addNewRule();
		rule.setName(layer.getName() + " naming");
		rule.setMessage("The " + layer.getName()
				+ " '${type.name}' must be named like '"
				+ layer.getNamingPattern() + "'");
		rule.setPriority(DEFAULT_NAMING_PRIORITY);
		CheckPredicate checkPredicate = null;
		Predicate filterPredicate = null;
		rule.setCheckPredicate(checkPredicate);
		rule.setFilterPredicate(filterPredicate);
	}
}