package ar.com.fluxit.jqa.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleSetImpl implements RuleSet {

	private List<Rule> rules;
	private String name;

	public RuleSetImpl() {
		rules = new ArrayList<Rule>();
	}

	public void addRule(Rule rule) {
		getRules().add(rule);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Rule> getRules() {
		return rules;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
}
