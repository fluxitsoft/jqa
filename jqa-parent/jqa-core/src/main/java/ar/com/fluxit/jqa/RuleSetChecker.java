/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import javax.management.IntrospectionException;

import org.slf4j.Logger;

import ar.com.fluxit.jqa.bce.ClassFormatException;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.result.RuleCheckFailed;
import ar.com.fluxit.jqa.rule.Rule;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleSetChecker {

	public static final RuleSetChecker INSTANCE = new RuleSetChecker();

	private RuleSetChecker() {
		super();
	}

	public CheckingResult check(Collection<File> classFiles, Collection<File> classPath, RulesContext context, Logger log) throws IntrospectionException,
			FileNotFoundException, ClassFormatException, IOException {
		final CheckingResult result = new CheckingResult();
		// Add files to classpath
		for (final File classPathFile : classPath) {
			log.debug("Adding to classpath: " + classPathFile);
		}
		RepositoryLocator.getRepository().setClassPath(classPath);
		// Iterate rulesets
		for (final RuleSet ruleset : context.getRuleSets()) {
			// Iterate rules
			for (final Rule rule : ruleset.getRules()) {
				log.debug("Checking rule (in normal mode): " + rule.getName());
				check(classFiles, rule.getFilterPredicate(), rule.getCheckPredicate(), result, context, rule.getPriority(), rule.getMessage(), rule.getName());
				if (rule.getBidirectionalCheck()) {
					log.debug("Checking rule (in inverse mode): " + rule.getName());
					check(classFiles, rule.getCheckPredicate(), rule.getFilterPredicate(), result, context, rule.getPriority(), rule.getMessage(), rule
							.getName());
				}
			}
		}
		return result;
	}

	private void check(Collection<File> classFiles, Predicate filterPredicate, Predicate checkPredicate, CheckingResult result, RulesContext context,
			int rulePriority, String ruleMessage, String ruleName) throws ClassFormatException, IOException {
		// Iterate class files
		for (final File classFile : classFiles) {
			final FileInputStream fis = new FileInputStream(classFile);
			final JavaClass clazz = RepositoryLocator.getRepository().parse(fis, null);
			fis.close();
			if (filterPredicate.evaluate(clazz, null)) {
				if (!checkPredicate.evaluate(clazz, context)) {
					result.addRuleExecutionFailed(new RuleCheckFailed(ruleName, ruleMessage, clazz.getClassName(), rulePriority));
				}
			}
		}
	}
}
