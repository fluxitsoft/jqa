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
package ar.com.fluxit.jqa.context.factory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.AbstractPredicate;
import ar.com.fluxit.jqa.predicate.FilteredPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;
import ar.com.fluxit.jqa.predicate.logic.VarArgsLogicPredicate;
import ar.com.fluxit.jqa.rule.Rule;
import ar.com.fluxit.jqa.rule.RuleImpl;
import ar.com.fluxit.jqa.rule.RuleSet;
import ar.com.fluxit.jqa.rule.RuleSetImpl;
import ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport;
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;
import ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate;
import ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate;
import ar.com.fluxit.jqa.schema.ruleset.AndPredicate;
import ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate;
import ar.com.fluxit.jqa.schema.ruleset.FalsePredicate;
import ar.com.fluxit.jqa.schema.ruleset.NamingPredicate;
import ar.com.fluxit.jqa.schema.ruleset.NotPredicate;
import ar.com.fluxit.jqa.schema.ruleset.OrPredicate;
import ar.com.fluxit.jqa.schema.ruleset.Ruleset;
import ar.com.fluxit.jqa.schema.ruleset.RulesetDocument;
import ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate;
import ar.com.fluxit.jqa.schema.ruleset.TruePredicate;
import ar.com.fluxit.jqa.schema.ruleset.TypingPredicate;
import ar.com.fluxit.jqa.schema.ruleset.UsagePredicate;
import ar.com.fluxit.jqa.schema.ruleset.XORPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextFactoryImpl implements RulesContextFactory {

	private String getFilePath(String fileName, String basePath) {
		if (fileName.startsWith("/")) {
			return fileName;
		} else {
			return basePath + "/" + fileName;
		}
	}

	@Override
	public RulesContext getRulesContext(Object source) throws RulesContextFactoryException {
		if (source instanceof File) {
			try {
				final File sourceFile = (File) source;
				final RulesContextDocument document = RulesContextDocument.Factory.parse(sourceFile);
				validate(document, sourceFile.toString());
				return parse(document.getRulesContext(), sourceFile.getParent());
			} catch (final RulesContextFactoryException e) {
				throw e;
			} catch (final XmlException e) {
				throw new RulesContextFactoryException("Invalid rules context file: " + source, e);
			} catch (final IOException e) {
				throw new RulesContextFactoryException("Error reading rules context file: " + source, e);
			} catch (final Exception e) {
				throw new RulesContextFactoryException(e);
			}
		} else {
			throw new IllegalArgumentException("Source (" + source + ") must be a File object");
		}
	}

	private RuleSet importRuleSet(File sourceFile) throws RulesContextFactoryException {
		try {
			final RulesetDocument document = RulesetDocument.Factory.parse(sourceFile);
			validate(document, sourceFile.toString());
			return parse(document.getRuleset());
		} catch (final Exception e) {
			throw new RulesContextFactoryException(e);
		}
	}

	private RuleSet importRuleSetByFileName(String fileName, String basePath) throws RulesContextFactoryException {
		final File sourceFile = new File(getFilePath(fileName, basePath));
		return importRuleSet(sourceFile);
	}

	private RuleSet importRuleSetByName(String name) throws RulesContextFactoryException {
		final File sourceFile = new File(ClassLoader.getSystemResource("rulesets/" + name + ".xml").getFile());
		return importRuleSet(sourceFile);
	}

	Predicate parse(AbstractionPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate result = new ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate();
		parse(predicate, result);
		result.setAbstractionType(parse(predicate.getAbstractionType()));
		return result;
	}

	Predicate parse(AllocationPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.AllocationPredicate result = new ar.com.fluxit.jqa.predicate.lang.AllocationPredicate();
		parse(predicate, result);
		return result;
	}

	Predicate parse(AndPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.logic.AndPredicate result = new ar.com.fluxit.jqa.predicate.logic.AndPredicate();
		parse(predicate, result);
		return result;
	}

	private RulesContext parse(ar.com.fluxit.jqa.schema.rulescontext.RulesContext rulesContext, String basePath) throws RulesContextFactoryException {
		final RulesContextImpl result = new RulesContextImpl();
		for (final ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate : rulesContext.getGlobalPredicateList()) {
			result.add((Predicate) parse(globalPredicate));
		}
		for (final RuleSetImport ruleSetImport : rulesContext.getRuleSetImportList()) {
			result.add(parse(ruleSetImport, basePath));
		}
		return result;
	}

	AbstractionType parse(ar.com.fluxit.jqa.schema.ruleset.AbstractionType.Enum type) {
		return AbstractionType.valueOf(type.toString());
	}

	private void parse(ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate predicate, FilteredPredicate result) {
		result.setFilterPredicate((Predicate) parse(predicate.getFilterPredicate()));
		parse(predicate, (AbstractPredicate) result);
	}

	private void parse(ar.com.fluxit.jqa.schema.ruleset.Predicate predicate, AbstractPredicate result) {
		result.setName(predicate.getName());
	}

	private Rule parse(ar.com.fluxit.jqa.schema.ruleset.Rule rule) {
		final String name = rule.getName();
		final String message = rule.getMessage();
		final boolean bidirectionalCheck = rule.getBidirectionalCheck();
		final int priority = rule.getPriority();
		final Predicate filterPredicate = (Predicate) parse(rule.getFilterPredicate());
		final Predicate checkPredicate = (Predicate) parse(rule.getCheckPredicate());
		final RuleImpl result = new RuleImpl(filterPredicate, checkPredicate, name, message);
		result.setBidirectionalCheck(bidirectionalCheck);
		if (priority > 0) {
			result.setPriority(priority);
		}
		return result;
	}

	private void parse(ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate predicate, VarArgsLogicPredicate result) {
		final Predicate[] predicates = new Predicate[predicate.getPredicateList().size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = (Predicate) parse(predicate.getPredicateArray(i));
		}
		result.setPredicates(predicates);
		parse(predicate, (AbstractPredicate) result);
	}

	Predicate parse(ContextProvidedPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.ContextProvidedPredicate result = new ar.com.fluxit.jqa.predicate.ContextProvidedPredicate();
		parse(predicate, result);
		result.setProvidedPredicateName(predicate.getProvidedPredicateName());
		return result;
	}

	Predicate parse(FalsePredicate predicate) {
		return ar.com.fluxit.jqa.predicate.logic.FalsePredicate.INSTANCE;
	}

	Predicate parse(NamingPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.NamingPredicate result = new ar.com.fluxit.jqa.predicate.lang.NamingPredicate();
		parse(predicate, result);
		result.setClassNamePattern(predicate.getClassNamePattern());
		return result;
	}

	Predicate parse(NotPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.logic.NotPredicate result = new ar.com.fluxit.jqa.predicate.logic.NotPredicate();
		result.setPredicate((Predicate) parse(predicate.getPredicate()));
		parse(predicate, result);
		return result;
	}

	private Object parse(Object source) {
		try {
			return getClass().getDeclaredMethod("parse", new Class[] { source.getClass().getInterfaces()[0] }).invoke(this, new Object[] { source });
		} catch (final Exception e) {
			throw new IllegalArgumentException("Cannot parse object: " + source);
		}
	}

	Predicate parse(OrPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.logic.OrPredicate result = new ar.com.fluxit.jqa.predicate.logic.OrPredicate();
		parse(predicate, result);
		return result;
	}

	private RuleSet parse(Ruleset rulesetDocument) {
		final RuleSetImpl result = new RuleSetImpl();
		result.setName(rulesetDocument.getName());
		final List<Rule> rules = new ArrayList<Rule>(rulesetDocument.getRuleList().size());
		for (final ar.com.fluxit.jqa.schema.ruleset.Rule rule : rulesetDocument.getRuleList()) {
			rules.add(parse(rule));
		}
		result.setRules(rules);
		return result;
	}

	private RuleSet parse(RuleSetImport ruleSetImport, String basePath) throws RulesContextFactoryException {
		RuleSet result;
		if (ruleSetImport.getFileName() != null) {
			result = importRuleSetByFileName(ruleSetImport.getFileName(), basePath);
		} else {
			result = importRuleSetByName(ruleSetImport.getName());
		}
		if (result == null) {
			throw new IllegalArgumentException("Invalid Ruleset import " + ruleSetImport);
		}
		return result;
	}

	Predicate parse(ThrowingPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate result = new ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate();
		parse(predicate, result);
		return result;
	}

	Predicate parse(TruePredicate predicate) {
		return ar.com.fluxit.jqa.predicate.logic.TruePredicate.INSTANCE;
	}

	Predicate parse(TypingPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.TypingPredicate result = new ar.com.fluxit.jqa.predicate.lang.TypingPredicate();
		parse(predicate, result);
		result.setParentClassName(predicate.getParentClassName());
		return result;
	}

	Predicate parse(UsagePredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.UsagePredicate result = new ar.com.fluxit.jqa.predicate.lang.UsagePredicate();
		parse(predicate, result);
		return result;
	}

	Predicate parse(XORPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.logic.XorPredicate result = new ar.com.fluxit.jqa.predicate.logic.XorPredicate();
		parse(predicate, result);
		return result;
	}

	private void validate(XmlObject document, String sourceFile) throws RulesContextFactoryException {
		final List<Object> validationErrors = new ArrayList<Object>();
		final XmlOptions voptions = new XmlOptions();
		voptions.setErrorListener(validationErrors);
		if (!document.validate(voptions)) {
			final StringBuilder errors = new StringBuilder();
			for (final Object error : validationErrors) {
				errors.append(error);
				errors.append("\n");
			}
			throw new RulesContextFactoryException("Invalid rules context file :" + sourceFile + "\n" + errors);
		}
	}

}
