/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
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
import java.util.HashMap;
import java.util.Map;

import javax.management.IntrospectionException;

import org.slf4j.Logger;

import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.bce.TypeFormatException;
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
public class RulesContextChecker {

	public static final String CLASS_SUFFIX = "class";
	public static final RulesContextChecker INSTANCE = new RulesContextChecker();

	private RulesContextChecker() {
		super();
	}

	private String buildMessage(String ruleMessage, Type type) {
		final Map<String, String> values = new HashMap<String, String>();
		values.put("type.name", type.getName().replaceAll("\\$", "\\\\\\$"));
		values.put("type.abstract", type.isAbstract() ? "abstract" : "concrete");
		values.put("type.interface", type.isInterface() ? "interface" : "class");
		for (final Map.Entry<String, String> e : values.entrySet()) {
			ruleMessage = ruleMessage.replaceAll("\\$\\{" + e.getKey() + "\\}", e.getValue());
		}
		return ruleMessage;
	}

	private void check(Collection<File> classFiles, Predicate filterPredicate, Predicate checkPredicate, CheckingResult result, RulesContext context,
			int rulePriority, String ruleMessage, String ruleName, File sourceDir) throws TypeFormatException, IOException {
		// Iterate class files
		for (final File classFile : classFiles) {
			final FileInputStream fis = new FileInputStream(classFile);
			final Repository repository = RepositoryLocator.getRepository();
			final Type type = repository.parse(fis, null);
			fis.close();
			if (filterPredicate.evaluate(type, context)) {
				if (!checkPredicate.evaluate(type, context)) {
					final RuleCheckFailed failed = new RuleCheckFailed(ruleName, buildMessage(ruleMessage, type), type.getName(), rulePriority);
					failed.setLineId(repository.getDeclarationLineNumber(type, sourceDir));
					result.addRuleExecutionFailed(failed);
				}
			}
		}
	}

	public CheckingResult check(String project, Collection<File> classFiles, Collection<File> classPath, RulesContext context, File sourceDir,
			String sourceJavaVersion, Logger log) throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		final CheckingResult result = new CheckingResult(project);
		// Add files to classpath
		for (final File classPathFile : classPath) {
			log.debug("Adding to classpath: " + classPathFile);
		}
		RepositoryLocator.getRepository().setJavaVersion(sourceJavaVersion);
		RepositoryLocator.getRepository().setClassPath(classPath);
		// Iterate rulesets
		for (final RuleSet ruleset : context.getRuleSets()) {
			// Iterate rules
			for (final Rule rule : ruleset.getRules()) {
				log.debug("Checking rule (in normal mode): " + rule.getName());
				check(classFiles, rule.getFilterPredicate(), rule.getCheckPredicate(), result, context, rule.getPriority(), rule.getMessage(), rule.getName(),
						sourceDir);
				if (rule.getBidirectionalCheck()) {
					log.debug("Checking rule (in inverse mode): " + rule.getName());
					check(classFiles, rule.getCheckPredicate(), rule.getFilterPredicate(), result, context, rule.getPriority(), rule.getMessage(),
							rule.getName(), sourceDir);
				}
			}
		}
		return result;
	}
}
