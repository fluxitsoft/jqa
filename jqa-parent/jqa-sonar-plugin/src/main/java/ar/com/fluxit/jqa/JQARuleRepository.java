package ar.com.fluxit.jqa;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.sonar.api.resources.Java;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RulePriority;
import org.sonar.api.rules.RuleRepository;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.rule.RuleSet;

public class JQARuleRepository extends RuleRepository {

	private static final String REPOSITORY_KEY = "jqa";

	public JQARuleRepository() {
		super(REPOSITORY_KEY, Java.KEY);
	}

	@Override
	public List<Rule> createRules() {
		List<Rule> result = new ArrayList<Rule>();
		try {
			final InputStream rulesStream = getClass().getResourceAsStream("/ar/com/fluxit/jqa/rulesContext.xml");
			final RulesContext rulesContext = RulesContextFactoryLocator.getRulesContextFactory().getRulesContext(
					rulesStream);
			for (RuleSet ruleSet : rulesContext.getRuleSets()) {
				for (ar.com.fluxit.jqa.rule.Rule jqaRule : ruleSet.getRules()) {
					Rule rule = Rule.create();
					result.add(processRule(rule, jqaRule));
				}
			}
			return result;
		} catch (RulesContextFactoryException e) {
			throw new IllegalStateException(e);
		}
	}

	private Rule processRule(Rule rule, ar.com.fluxit.jqa.rule.Rule jqaRule) {
		rule.setKey(jqaRule.getName());
		rule.setSeverity(RulePriority.valueOf(getPriority(jqaRule.getPriority())));
		rule.setName(jqaRule.getName());
		rule.setDescription(jqaRule.getMessage());
		return rule;
	}

	private String getPriority(int priority) {
		switch (priority) {
		case 1:
			return "BLOCKER";
		case 2:
			return "CRITICAL";
		case 3:
			return "MAJOR";
		case 4:
			return "MINOR";
		case 5:
			return "INFO";
		}
		throw new IllegalArgumentException("Priority must be a numerical value between 1 and 5");
	}

	public static void main(String[] args) {
		new JQARuleRepository().createRules();
	}
}
