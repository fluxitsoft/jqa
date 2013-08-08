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
import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.context.factory.xmlbeans.util.MainRulesContextFileBuilder;
import ar.com.fluxit.jqa.descriptor.ArchitectureDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;
import ar.com.fluxit.jqa.predicate.logic.OrPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class MainRulesContextFileBuilderTest extends TestCase {

	private File targetDir;

	private Collection<String> buildPackages(String... string) {
		return Arrays.asList(string);
	}

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
		File targetFile = new File(targetDir, "rulesContext.xml");
		// Builds an archdescriptor
		ArchitectureDescriptor archDescriptor = new ArchitectureDescriptor();
		archDescriptor.getLayers().clear();
		LayerDescriptor entityLayer = new LayerDescriptor("Entity", false,
				null, true);
		entityLayer.addPackages(buildPackages("com.acme.foo.entity"));
		archDescriptor.getLayers().add(entityLayer);
		LayerDescriptor daoLayer = new LayerDescriptor("DAO", true, "*DAO",
				false);
		daoLayer.addPackages(buildPackages("com.acme.foo.dao",
				"com.acme.foo.dao.impl"));
		archDescriptor.getLayers().add(daoLayer);
		// Run
		MainRulesContextFileBuilder.INSTANCE.buildRulesContextFile(targetFile,
				archDescriptor);
		// Do asserts
		RulesContext rulesContext = RulesContextFactoryLocator
				.getRulesContextFactory().getRulesContext(targetFile.getPath());
		assertNotNull(rulesContext);
		Predicate entityGlobalPredicate = rulesContext
				.getGlobalPredicate("entity-layer");
		assertEquals(1, ((OrPredicate) entityGlobalPredicate).getPredicates()
				.size());
		assertTrue(((OrPredicate) entityGlobalPredicate).getPredicates()
				.contains(new NamingPredicate("com.acme.foo.entity.**")));
		Predicate daoGlobalPredicate = rulesContext
				.getGlobalPredicate("dao-layer");
		assertEquals(2, ((OrPredicate) daoGlobalPredicate).getPredicates()
				.size());
		assertTrue(((OrPredicate) daoGlobalPredicate).getPredicates().contains(
				new NamingPredicate("com.acme.foo.dao.impl.**")));
		assertTrue(((OrPredicate) daoGlobalPredicate).getPredicates().contains(
				new NamingPredicate("com.acme.foo.dao.**")));
	}

}
