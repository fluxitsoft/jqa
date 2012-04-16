package ar.com.fluxit.jqa.context.factory.jibx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.context.factory.RulesContextFactory;
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
import ar.com.fluxit.jqa.schema.AbstractionPredicate;
import ar.com.fluxit.jqa.schema.AllocationPredicate;
import ar.com.fluxit.jqa.schema.AndPredicate;
import ar.com.fluxit.jqa.schema.ContextProvidedPredicate;
import ar.com.fluxit.jqa.schema.FalsePredicate;
import ar.com.fluxit.jqa.schema.NamingPredicate;
import ar.com.fluxit.jqa.schema.NotPredicate;
import ar.com.fluxit.jqa.schema.OrPredicate;
import ar.com.fluxit.jqa.schema.RuleSetImport;
import ar.com.fluxit.jqa.schema.RulesContextImport;
import ar.com.fluxit.jqa.schema.Ruleset;
import ar.com.fluxit.jqa.schema.ThrowingPredicate;
import ar.com.fluxit.jqa.schema.TruePredicate;
import ar.com.fluxit.jqa.schema.TypingPredicate;
import ar.com.fluxit.jqa.schema.UsagePredicate;
import ar.com.fluxit.jqa.schema.XORPredicate;

public class RulesContextFactoryImpl implements RulesContextFactory {

	private static Logger LOGGER = LoggerFactory.getLogger(RulesContextFactoryImpl.class);

	@Override
	public RulesContext getRulesContext(File source) throws RulesContextFactoryException {
		try {
			IBindingFactory bindingFactory = BindingDirectory.getFactory(ar.com.fluxit.jqa.schema.RulesContext.class);
			IUnmarshallingContext unmarschallingCtx = bindingFactory.createUnmarshallingContext();
			ar.com.fluxit.jqa.schema.RulesContext rulesContext = (ar.com.fluxit.jqa.schema.RulesContext) unmarschallingCtx.unmarshalDocument(
					new FileInputStream(source), null);
			return parse(rulesContext);
		} catch (JiBXException e) {
			throw new RulesContextFactoryException("Invalid rules context file: " + source, e);
		} catch (FileNotFoundException e) {
			throw new RulesContextFactoryException("Error reading rules context file: " + source, e);
		}
	}

	@Override
	public RulesContext getRulesContext(InputStream source) throws RulesContextFactoryException {
		try {
			IBindingFactory bindingFactory = BindingDirectory.getFactory(ar.com.fluxit.jqa.schema.RulesContext.class);
			IUnmarshallingContext unmarschallingCtx = bindingFactory.createUnmarshallingContext();
			ar.com.fluxit.jqa.schema.RulesContext rulesContext = (ar.com.fluxit.jqa.schema.RulesContext) unmarschallingCtx.unmarshalDocument(source, null);
			return parse(rulesContext);
		} catch (JiBXException e) {
			throw new RulesContextFactoryException("Invalid rules context file: " + source, e);
		}
	}

	private RuleSet importRuleSetByFileName(String source) throws RulesContextFactoryException {
		try {
			IBindingFactory bindingFactory = BindingDirectory.getFactory(ar.com.fluxit.jqa.schema.Ruleset.class);
			IUnmarshallingContext unmarschallingCtx = bindingFactory.createUnmarshallingContext();
			ar.com.fluxit.jqa.schema.Ruleset ruleset = (ar.com.fluxit.jqa.schema.Ruleset) unmarschallingCtx
					.unmarshalDocument(new FileInputStream(source), null);
			return parse(ruleset);
		} catch (JiBXException e) {
			throw new RulesContextFactoryException("Invalid ruleset file: " + source, e);
		} catch (FileNotFoundException e) {
			throw new RulesContextFactoryException("Error reading ruleset file: " + source, e);
		}
	}

	private RuleSet importRuleSetByName(String source) throws RulesContextFactoryException {
		try {
			InputStream stream = getClass().getResourceAsStream(source);
			IBindingFactory bindingFactory = BindingDirectory.getFactory(ar.com.fluxit.jqa.schema.Ruleset.class);
			IUnmarshallingContext unmarschallingCtx = bindingFactory.createUnmarshallingContext();
			ar.com.fluxit.jqa.schema.Ruleset ruleset = (ar.com.fluxit.jqa.schema.Ruleset) unmarschallingCtx.unmarshalDocument(stream, null);
			return parse(ruleset);
		} catch (JiBXException e) {
			throw new RulesContextFactoryException("Invalid rules context file: " + source, e);
		}
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

	AbstractionType parse(ar.com.fluxit.jqa.schema.AbstractionType type) {
		return AbstractionType.valueOf(type.toString());
	}

	private void parse(ar.com.fluxit.jqa.schema.FilteredPredicate predicate, FilteredPredicate result) {
		result.setFilterPredicate((Predicate) parse(predicate.getPredicate1()));
		parse(predicate, (AbstractPredicate) result);
	}

	private void parse(ar.com.fluxit.jqa.schema.Predicate predicate, AbstractPredicate result) {
		result.setName(predicate.getName());
	}

	private Rule parse(ar.com.fluxit.jqa.schema.Rule rule) {
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

	private RulesContext parse(ar.com.fluxit.jqa.schema.RulesContext rulesContext) throws RulesContextFactoryException {
		final RulesContextImpl result = new RulesContextImpl();
		for (final ar.com.fluxit.jqa.schema.Predicate globalPredicate : rulesContext.getGlobalPredicateList()) {
			result.add((Predicate) parse(globalPredicate));
		}
		for (final RulesContextImport rulesContextImport : rulesContext.getRulesContextImportList()) {
			result.add(parse(rulesContextImport));
		}
		for (final RuleSetImport ruleSetImport : rulesContext.getRuleSetImportList()) {
			result.add(parse(ruleSetImport));
		}
		for (final Ruleset ruleSet : rulesContext.getRuleSetList()) {
			result.add(parse(ruleSet));
		}
		return result;
	}

	private void parse(ar.com.fluxit.jqa.schema.VarArgsLogicPredicate predicate, VarArgsLogicPredicate result) {
		final Predicate[] predicates = new Predicate[predicate.getPredicateList().size()];
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = (Predicate) parse(predicate.getPredicateList().get(i));
		}
		result.setPredicates(predicates);
		parse(predicate, (AbstractPredicate) result);
	}

	Predicate parse(ContextProvidedPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.ContextProvidedPredicate result = new ar.com.fluxit.jqa.predicate.ContextProvidedPredicate();
		parse(predicate, result);
		result.setProvidedPredicateName(predicate.getPredicateName());
		return result;
	}

	Predicate parse(FalsePredicate predicate) {
		return ar.com.fluxit.jqa.predicate.logic.FalsePredicate.INSTANCE;
	}

	Predicate parse(NamingPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.lang.NamingPredicate result = new ar.com.fluxit.jqa.predicate.lang.NamingPredicate();
		parse(predicate, result);
		result.setClassNamePattern(predicate.getNamePattern());
		return result;
	}

	Predicate parse(NotPredicate predicate) {
		final ar.com.fluxit.jqa.predicate.logic.NotPredicate result = new ar.com.fluxit.jqa.predicate.logic.NotPredicate();
		result.setPredicate((Predicate) parse(predicate.getPredicate1()));
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

	private RulesContext parse(RulesContextImport rulesContextImport) throws RulesContextFactoryException {
		RulesContext result;
		if (rulesContextImport.getFileName() != null) {
			LOGGER.info("Parsing rules fileName = " + rulesContextImport.getFileName());
			result = getRulesContext(new File(rulesContextImport.getFileName()));
		} else {
			LOGGER.info("Parsing rules name = " + rulesContextImport.getName());
			result = getRulesContext(getClass().getResourceAsStream(rulesContextImport.getName()));
		}
		if (result == null) {
			throw new IllegalArgumentException("Invalid Ruleset import " + rulesContextImport);
		}
		return result;
	}

	private RuleSet parse(Ruleset rulesetDocument) {
		final RuleSetImpl result = new RuleSetImpl();
		result.setName(rulesetDocument.getName());
		final List<Rule> rules = new ArrayList<Rule>(rulesetDocument.getRuleList().size());
		for (final ar.com.fluxit.jqa.schema.Rule rule : rulesetDocument.getRuleList()) {
			rules.add(parse(rule));
		}
		result.setRules(rules);
		return result;
	}

	private RuleSet parse(RuleSetImport ruleSetImport) throws RulesContextFactoryException {
		RuleSet result;
		if (ruleSetImport.getFileName() != null) {
			result = importRuleSetByFileName(ruleSetImport.getFileName());
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

}
