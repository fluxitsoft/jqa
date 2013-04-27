/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
package ar.com.fluxit.jqa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.management.IntrospectionException;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.bce.TypeFormatException;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.mock.ClassA;
import ar.com.fluxit.jqa.mock.logic.FalseCheckPredicate;
import ar.com.fluxit.jqa.mock.logic.TrueCheckPredicate;
import ar.com.fluxit.jqa.predicate.CheckPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.rule.Rule;
import ar.com.fluxit.jqa.rule.RuleImpl;
import ar.com.fluxit.jqa.rule.RuleSet;
import ar.com.fluxit.jqa.rule.RuleSetImpl;
import ar.com.fluxit.jqa.util.FileUtils;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextCheckerTest extends TestCase {

	private Logger log;

	public RulesContextCheckerTest() {
		BCERepositoryLocator.init(null, "1.5", null);
	}

	private Rule createRule(Predicate filterPredicate, CheckPredicate checkPredicate) {
		final RuleImpl ruleImpl = new RuleImpl(filterPredicate, checkPredicate, "", "");
		return ruleImpl;
	}

	private RulesContext createRulesContext(Collection<RuleSet> configuration) {
		final RulesContextImpl result = new RulesContextImpl();
		result.addAll(configuration);
		return result;
	}

	private RuleSet createRuleSet(Predicate filterPredicate, CheckPredicate checkPredicate) {
		final RuleSetImpl result = new RuleSetImpl();
		result.addRule(createRule(filterPredicate, checkPredicate));
		return result;
	}

	private Collection<RuleSet> createRuleSets(Predicate filterPredicate, CheckPredicate checkPredicate) {
		final Collection<RuleSet> result = new ArrayList<RuleSet>();
		result.add(createRuleSet(filterPredicate, checkPredicate));
		return result;
	}

	public RulesContextChecker getChecker() {
		return RulesContextChecker.INSTANCE;
	}

	protected Logger getLog() {
		return this.log;
	}

	private File getSourceDir() {
		return new File(System.getProperty("user.dir") + "/src/test/java");
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.log = LoggerFactory.getLogger(RulesContextCheckerTest.class);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		this.log = null;
	}

	public final void testCheckPredicateFail() throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final Collection<File> classFiles = FileUtils.INSTANCE.getClassFiles(ClassA.class);
		final Collection<RuleSet> configuration = createRuleSets(TruePredicate.INSTANCE, FalseCheckPredicate.INSTANCE);
		final RulesContext context = createRulesContext(configuration);
		final CheckingResult result = getChecker().check("", classFiles, Collections.<File> emptyList(), context, getSourceDir(), "1.6", getLog());
		assertNotNull(result);
		assertNotNull(result.getDate());
		assertNotNull(result.getRuleChecksFailed());
		assertEquals(1, result.getRuleChecksFailed().size());
	}

	public final void testCheckPredicateSuccess() throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final Collection<File> classFiles = FileUtils.INSTANCE.getClassFiles(ClassA.class);
		final Collection<RuleSet> configuration = createRuleSets(TruePredicate.INSTANCE, TrueCheckPredicate.INSTANCE);
		final RulesContext context = createRulesContext(configuration);
		final CheckingResult result = getChecker().check("", classFiles, Collections.<File> emptyList(), context, getSourceDir(), "1.6", getLog());
		assertNotNull(result);
		assertNotNull(result.getDate());
		assertNotNull(result.getRuleChecksFailed());
		assertTrue(result.getRuleChecksFailed().isEmpty());
	}

	public final void testCheckWithNoFiles() throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final Collection<File> classFiles = new ArrayList<File>();
		final Collection<RuleSet> configuration = createRuleSets(TruePredicate.INSTANCE, TrueCheckPredicate.INSTANCE);
		final RulesContext context = createRulesContext(configuration);
		final CheckingResult result = getChecker().check("", classFiles, Collections.<File> emptyList(), context, getSourceDir(), "1.6", getLog());
		assertNotNull(result);
		assertNotNull(result.getDate());
		assertNotNull(result.getRuleChecksFailed());
		assertTrue(result.getRuleChecksFailed().isEmpty());
	}

	public final void testFilterPredicateFail() throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final Collection<File> classFiles = FileUtils.INSTANCE.getClassFiles(ClassA.class);
		final Collection<RuleSet> configuration = createRuleSets(TruePredicate.INSTANCE, FalseCheckPredicate.INSTANCE);
		final RulesContext context = createRulesContext(configuration);
		final CheckingResult result = getChecker().check("", classFiles, Collections.<File> emptyList(), context, getSourceDir(), "1.6", getLog());
		assertNotNull(result);
		assertNotNull(result.getDate());
		assertNotNull(result.getRuleChecksFailed());
		assertEquals(1, result.getRuleChecksFailed().size());
	}

	public final void testFilterPredicateSuccess() throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final Collection<File> classFiles = FileUtils.INSTANCE.getClassFiles(ClassA.class);
		final Collection<RuleSet> configuration = createRuleSets(TruePredicate.INSTANCE, TrueCheckPredicate.INSTANCE);
		final RulesContext context = createRulesContext(configuration);
		final CheckingResult result = getChecker().check("", classFiles, Collections.<File> emptyList(), context, getSourceDir(), "1.6", getLog());
		assertNotNull(result);
		assertNotNull(result.getDate());
		assertNotNull(result.getRuleChecksFailed());
		assertTrue(result.getRuleChecksFailed().isEmpty());
	}

}
