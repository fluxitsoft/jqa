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
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class MainRulesContextFileBuilder extends
		AbstractRulesContextFileBuilder {

	public static RulesContextFileBuilder INSTANCE = new MainRulesContextFileBuilder();

	private MainRulesContextFileBuilder() {
		// hides the constructor
	}

	@Override
	public void buildRulesContextFile(File targetFile,
			ArchitectureDescriptor archDescriptor)
			throws RulesContextFactoryException {
		try {
			// Builds the main rules context file
			RulesContextDocument rulesContextDoc = RulesContextDocument.Factory
					.newInstance();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext rulesContext = rulesContextDoc
					.addNewRulesContext();
			rulesContext.setName("JQA Eclipse Plugin generated rules context");
			rulesContext.addNewRulesContextImport().setResource("layers.xml");
			rulesContext.addNewRulesContextImport().setResource("naming.xml");
			rulesContext.addNewRulesContextImport().setResource("typing.xml");
			rulesContext.addNewRulesContextImport().setResource("throwing.xml");
			rulesContext.addNewRulesContextImport().setResource("usage.xml");
			// rulesContext.addNewRulesContextImport().setResource(
			// "allocation.xml");
			// rulesContext.addNewRulesContextImport().setResource(
			// "abstraction.xml");
			rulesContextDoc.save(targetFile);
			// Builds the aspect rules context files
			LayersRulesContextFileBuilder.INSTANCE.buildRulesContextFile(
					targetFile, archDescriptor);
			NamingRulesContextFileBuilder.INSTANCE.buildRulesContextFile(
					targetFile, archDescriptor);
			TypingRulesContextFileBuilder.INSTANCE.buildRulesContextFile(
					targetFile, archDescriptor);
			ThrowingRulesContextFileBuilder.INSTANCE.buildRulesContextFile(
					targetFile, archDescriptor);
			UsageRulesContextFileBuilder.INSTANCE.buildRulesContextFile(
					targetFile, archDescriptor);

		} catch (IOException e) {
			throw new RulesContextFactoryException(
					"Error while saving rules context file", e);
		}
	}

}
