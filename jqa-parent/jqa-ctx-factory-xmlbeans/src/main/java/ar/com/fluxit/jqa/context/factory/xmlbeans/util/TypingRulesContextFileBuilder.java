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
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class TypingRulesContextFileBuilder extends AbstractRulesContextFileBuilder {

	private static final int DEFAULT_TYPING_PRIORITY = 3;
	public static RulesContextFileBuilder INSTANCE = new TypingRulesContextFileBuilder();

	private TypingRulesContextFileBuilder() {
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
			rulesContext.setName("Typing rules context");
			Ruleset ruleSet = rulesContext.addNewRuleSet();
			ruleSet.setName("Typing ruleset");
			for (LayerDescriptor layer : archDescriptor.getLayers()) {
				buildTypingRule(ruleSet, layer);
			}
			rulesContextDoc.save(new File(targetFile.getParentFile(),
					"typing.xml"));
		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

	private void buildTypingRule(Ruleset ruleSet, LayerDescriptor layer) {
		// TODO Auto-generated method stub
	}
}
