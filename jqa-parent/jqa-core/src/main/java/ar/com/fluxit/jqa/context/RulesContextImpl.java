package ar.com.fluxit.jqa.context;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImpl implements RulesContext {

	private final Collection<RuleSet> ruleSets;

	public RulesContextImpl() {
		ruleSets = new ArrayList<RuleSet>();
	}

	public void addAll(Collection<RuleSet> configuration) {
		ruleSets.addAll(configuration);
	}

	@Override
	public Predicate getGlobalPredicate(String name) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Collection<RuleSet> getRuleSets() {
		return ruleSets;
	}

}
