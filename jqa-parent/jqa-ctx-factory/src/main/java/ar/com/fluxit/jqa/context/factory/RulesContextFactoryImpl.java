package ar.com.fluxit.jqa.context.factory;

import java.io.File;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;
import ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport;
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;
import ar.com.fluxit.jqa.schema.ruleset.FalsePredicate;
import ar.com.fluxit.jqa.schema.ruleset.NotPredicate;
import ar.com.fluxit.jqa.schema.ruleset.TruePredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextFactoryImpl implements RulesContextFactory {

	@Override
	public RulesContext getRulesContext(Object source)
			throws RulesContextFactoryException {
		if (source instanceof File) {
			try {
				File sourceFile = (File) source;
				RulesContextDocument document = RulesContextDocument.Factory
						.parse(sourceFile);
				return parse(document.getRulesContext());
			} catch (Exception e) {
				throw new RulesContextFactoryException(e);
			}
		} else {
			throw new IllegalArgumentException("Source must be a File object");
		}
	}

	private RulesContext parse(
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext rulesContext) {
		final RulesContextImpl result = new RulesContextImpl();
		for (ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate : rulesContext
				.getGlobalPredicateList()) {
			result.add((Predicate) parse(globalPredicate));
		}
		for (RuleSetImport ruleSetImport : rulesContext.getRuleSetImportList()) {
			result.add(parse(ruleSetImport));
		}
		return result;
	}

	Predicate parse(FalsePredicate predicate) {
		return ar.com.fluxit.jqa.predicate.logic.FalsePredicate.INSTANCE;
	}

	Predicate parse(NotPredicate predicate) {
		ar.com.fluxit.jqa.predicate.logic.NotPredicate result = new ar.com.fluxit.jqa.predicate.logic.NotPredicate();
		result.setPredicate((Predicate) parse(predicate.getPredicate()));
		result.setName(predicate.getName());
		return result;
	}

	private Object parse(Object source) {
		try {
			return getClass().getDeclaredMethod("parse",
					new Class[] { source.getClass().getInterfaces()[0] })
					.invoke(this, new Object[] { source });
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot parse object: " + source);
		}
	}

	private RuleSet parse(RuleSetImport ruleSetImport) {
		return null;
	}

	Predicate parse(TruePredicate predicate) {
		return ar.com.fluxit.jqa.predicate.logic.TruePredicate.INSTANCE;
	}

}
