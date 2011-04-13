package ar.com.fluxit.jqa.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImpl implements RulesContext {

	private final Collection<RuleSet> ruleSets;
	private final Map<String, Predicate> globalPredicates;

	public RulesContextImpl() {
		ruleSets = new ArrayList<RuleSet>();
		globalPredicates = new HashMap<String, Predicate>();
	}

	public void addAll(Collection<RuleSet> ruleSets) {
		this.ruleSets.addAll(ruleSets);
	}

	public void add(RuleSet ruleSet) {
		this.ruleSets.add(ruleSet);
	}

	public void add(Predicate predicate) {
		if (predicate.getName() == null) {
			throw new IllegalArgumentException("Predicate must has a name");
		}
		globalPredicates.put(predicate.getName(), predicate);
	}

	@Override
	public Predicate getGlobalPredicate(String name) {
		return globalPredicates.get(name);
	}

	@Override
	public Collection<RuleSet> getRuleSets() {
		return ruleSets;
	}

}
