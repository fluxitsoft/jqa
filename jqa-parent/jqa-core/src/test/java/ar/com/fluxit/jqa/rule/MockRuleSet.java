package ar.com.fluxit.jqa.rule;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class MockRuleSet implements RuleSet {

	private final Collection<Rule> rules;

	public MockRuleSet() {
		super();
		rules = new ArrayList<Rule>();
	}

	public void addRule(Rule rule) {
		getRules().add(rule);
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Collection<Rule> getRules() {
		return rules;
	}

}
