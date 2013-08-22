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
import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.predicate.ContextProvidedPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;
import ar.com.fluxit.jqa.predicate.lang.AllocationPredicate;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;
import ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate;
import ar.com.fluxit.jqa.predicate.lang.TypingPredicate;
import ar.com.fluxit.jqa.predicate.lang.UsagePredicate;
import ar.com.fluxit.jqa.predicate.logic.AndPredicate;
import ar.com.fluxit.jqa.predicate.logic.NotPredicate;
import ar.com.fluxit.jqa.predicate.logic.OrPredicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;
import ar.com.fluxit.jqa.rule.RuleImpl;
import ar.com.fluxit.jqa.rule.RuleSetImpl;

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
		// Builds an ArchitectureDescriptor
		ArchitectureDescriptor archDescriptor = new ArchitectureDescriptor();
		archDescriptor.getLayers().clear();
		LayerDescriptor entityLayer = new LayerDescriptor("Entity", false,
				null, true);
		entityLayer.setSuperType("com.acme.foo.entity.Entity");
		entityLayer.addPackages(buildPackages("com.acme.foo.entity"));
		archDescriptor.getLayers().add(entityLayer);
		LayerDescriptor daoLayer = new LayerDescriptor("DAO", true, "*DAO",
				false);
		daoLayer.setSuperType("com.acme.foo.dao.DataAccessObject");
		daoLayer.setExceptionSuperType("com.acme.foo.dao.DataAccessObjectException");
		daoLayer.addPackages(buildPackages("com.acme.foo.dao",
				"com.acme.foo.dao.impl"));
		daoLayer.setCommons(new CommonDescriptor("org.hibernate", true),
				new CommonDescriptor("org.spring", true));
		daoLayer.addUsage(entityLayer);
		archDescriptor.getLayers().add(daoLayer);
		LayerDescriptor utilLayer = new LayerDescriptor("Util", false, "*Util",
				false);
		utilLayer.addPackages(buildPackages("com.acme.foo.util"));
		utilLayer.setSuperType("java.lang.Object");
		utilLayer.setExceptionSuperType("java.lang.Exception");
		utilLayer.setCommons(new CommonDescriptor("org.apache", true),
				new CommonDescriptor("org.spring", false));
		utilLayer.addUsage(daoLayer);
		archDescriptor.getLayers().add(utilLayer);
		// Run
		MainRulesContextFileBuilder.INSTANCE.buildRulesContextFile(targetFile,
				archDescriptor);
		// Do asserts
		RulesContext rulesContext = RulesContextFactoryLocator
				.getRulesContextFactory().getRulesContext(targetFile.getPath());
		assertNotNull(rulesContext);
		assertEquals(5, rulesContext.getRuleSets().size());
		// Layer definitions
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
		Predicate utilGlobalPredicate = rulesContext
				.getGlobalPredicate("util-layer");
		assertEquals(1, ((OrPredicate) utilGlobalPredicate).getPredicates()
				.size());
		assertTrue(((OrPredicate) utilGlobalPredicate).getPredicates()
				.contains(new NamingPredicate("com.acme.foo.util.**")));
		// Naming definitions
		RuleSetImpl namingRuleSet = new RuleSetImpl();
		namingRuleSet.setName("Naming ruleset");
		namingRuleSet.addRule(new RuleImpl(new AndPredicate(
				new ContextProvidedPredicate("dao-layer"),
				new AbstractionPredicate(AbstractionType.INTERFACE)),
				new NamingPredicate("**.*DAO"), "DAO API naming",
				"The DAO API '${type.name}' must be named like '**.*DAO'", 4));
		namingRuleSet
				.addRule(new RuleImpl(
						new AndPredicate(new ContextProvidedPredicate(
								"dao-layer"), new AbstractionPredicate(
								AbstractionType.CONCRETE)),
						new NamingPredicate("**.impl.*DAOImpl"),
						"DAO implementation naming",
						"The DAO implementation '${type.name}' must be named like '**.impl.*DAOImpl'",
						4));
		namingRuleSet
				.addRule(new RuleImpl(
						new AndPredicate(new ContextProvidedPredicate(
								"dao-layer"), new AbstractionPredicate(
								AbstractionType.ABSTRACT)),
						new NamingPredicate("**.Abstract*DAO"),
						"Abstract DAO naming",
						"The abstract DAO '${type.name}' must be named like '**.Abstract*DAO'",
						4));
		namingRuleSet.addRule(new RuleImpl(new ContextProvidedPredicate(
				"util-layer"), new NamingPredicate("**.*Util"), "Util naming",
				"The Util '${type.name}' must be named like '**.*Util'", 4));
		assertTrue(rulesContext.getRuleSets().contains(namingRuleSet));
		assertEquals(4, rulesContext.getRuleSet("Naming ruleset").getRules()
				.size());
		// Typing definitions
		RuleSetImpl typingRuleSet = new RuleSetImpl();
		typingRuleSet.setName("Typing ruleset");
		typingRuleSet
				.addRule(new RuleImpl(
						new ContextProvidedPredicate("entity-layer"),
						new TypingPredicate(new NamingPredicate(
								"com.acme.foo.entity.Entity")),
						"Entity typing",
						"The Entity '${type.name}' must be subtype of 'com.acme.foo.entity.Entity'",
						3));
		typingRuleSet
				.addRule(new RuleImpl(
						new ContextProvidedPredicate("dao-layer"),
						new TypingPredicate(new NamingPredicate(
								"com.acme.foo.dao.DataAccessObject")),
						"DAO typing",
						"The DAO '${type.name}' must be subtype of 'com.acme.foo.dao.DataAccessObject'",
						3));
		assertTrue(rulesContext.getRuleSets().contains(typingRuleSet));
		assertEquals(2, rulesContext.getRuleSet("Typing ruleset").getRules()
				.size());
		// Throwing definitions
		RuleSetImpl throwingRuleSet = new RuleSetImpl();
		throwingRuleSet.setName("Throwing ruleset");
		throwingRuleSet
				.addRule(new RuleImpl(
						new ContextProvidedPredicate("dao-layer"),
						new ThrowingPredicate(new NamingPredicate(
								"com.acme.foo.dao.DataAccessObjectException")),
						"DAO throwing",
						"The DAO '${type.name}' has an invalid throwing. A DAO must throws only exceptions that extend to 'com.acme.foo.dao.DataAccessObjectException'",
						3));
		assertTrue(rulesContext.getRuleSets().contains(throwingRuleSet));
		assertEquals(1, rulesContext.getRuleSet("Throwing ruleset").getRules()
				.size());
		// Usage definitions
		RuleSetImpl usageRuleSet = new RuleSetImpl();
		usageRuleSet.setName("Usage ruleset");
		usageRuleSet.addRule(new RuleImpl(new ContextProvidedPredicate(
				"entity-layer"), new UsagePredicate(new OrPredicate(
				new NamingPredicate("java.**"), new ContextProvidedPredicate(
						"entity-layer"), new NamingPredicate(
						"com.acme.foo.entity.Entity"))), "Entity usage",
				"The Entity '${type.name}' has an invalid usage.", 2));
		usageRuleSet
				.addRule(new RuleImpl(
						new ContextProvidedPredicate("dao-layer"),
						new UsagePredicate(
								new OrPredicate(
										new NamingPredicate("java.**"),
										new ContextProvidedPredicate(
												"dao-layer"),
										new NamingPredicate("org.hibernate.**"),
										new NamingPredicate("org.spring.**"),
										new ContextProvidedPredicate(
												"entity-layer"),
										new NamingPredicate(
												"com.acme.foo.dao.DataAccessObject"),
										new NamingPredicate(
												"com.acme.foo.dao.DataAccessObjectException"))),
						"DAO usage",
						"The DAO '${type.name}' has an invalid usage.", 2));
		usageRuleSet.addRule(new RuleImpl(new ContextProvidedPredicate(
				"util-layer"), new UsagePredicate(new OrPredicate(
				new NamingPredicate("java.**"), new ContextProvidedPredicate(
						"util-layer"), new NamingPredicate("org.apache.**"),
				new AndPredicate(new ContextProvidedPredicate("dao-layer"),
						new AbstractionPredicate(AbstractionType.INTERFACE)),
				new TypingPredicate(new NamingPredicate(
						"com.acme.foo.dao.DataAccessObjectException")))),
				"Util usage", "The Util '${type.name}' has an invalid usage.",
				2));
		assertTrue(rulesContext.getRuleSets().contains(usageRuleSet));
		assertEquals(3, rulesContext.getRuleSet("Usage ruleset").getRules()
				.size());

		// Allocation definitions
		RuleSetImpl allocationRuleSet = new RuleSetImpl();
		allocationRuleSet.setName("Allocation ruleset");
		allocationRuleSet.addRule(new RuleImpl(TruePredicate.INSTANCE,
				new AllocationPredicate(new NotPredicate(
						new ContextProvidedPredicate("dao-layer"))),
				"DAO allocation",
				"The DAO '${type.name}' can not be allocated'", 2));
		allocationRuleSet.addRule(new RuleImpl(TruePredicate.INSTANCE,
				new AllocationPredicate(new NotPredicate(
						new ContextProvidedPredicate("util-layer"))),
				"Util allocation",
				"The Util '${type.name}' can not be allocated'", 2));
		assertTrue(rulesContext.getRuleSets().contains(allocationRuleSet));
		assertEquals(2, rulesContext.getRuleSet("Allocation ruleset")
				.getRules().size());
	}

}
