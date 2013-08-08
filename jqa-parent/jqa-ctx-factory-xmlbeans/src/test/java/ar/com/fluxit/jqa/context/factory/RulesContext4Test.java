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
package ar.com.fluxit.jqa.context.factory;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.descriptor.ArchitectureDescriptor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContext4Test extends TestCase {

	private File targetDir;

	@Override
	protected void setUp() throws Exception {
		File tempDir = new File(System.getProperty("user.dir"));
		targetDir = new File(tempDir, "testBuildRulesContextFile");
		FileUtils.deleteDirectory(targetDir);
		targetDir.mkdir();
	}

	@Override
	protected void tearDown() throws Exception {
		FileUtils.deleteDirectory(targetDir);
	}

	public void testBuildRulesContextFile() throws RulesContextFactoryException {
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		File targetFile = new File(targetDir, "rulesContext.xml");
		ArchitectureDescriptor archDescriptor = new ArchitectureDescriptor();
		rulesContextFactory.buildRulesContextFile(targetFile, archDescriptor);

		// TODO
		// RulesContext rulesContext = rulesContextFactory
		// .getRulesContext(targetFile.getPath());
		// assertNotNull(rulesContext);
	}

}
