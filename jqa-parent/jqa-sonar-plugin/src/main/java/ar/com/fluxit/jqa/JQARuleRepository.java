package ar.com.fluxit.jqa;

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

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.resources.Java;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RulePriority;
import org.sonar.api.rules.RuleRepository;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQARuleRepository extends RuleRepository {

	public static final String REPOSITORY_KEY = "JQA";

	public JQARuleRepository() {
		super(REPOSITORY_KEY, Java.KEY);
	}

	@Override
	public List<Rule> createRules() {
		List<Rule> result = new ArrayList<Rule>();
		RulesContext rulesContext = RulesContextLoader.INSTANCE.load();
		for (RuleSet ruleSet : rulesContext.getRuleSets()) {
			for (ar.com.fluxit.jqa.rule.Rule jqaRule : ruleSet.getRules()) {
				Rule rule = Rule.create();
				result.add(processRule(rule, jqaRule));
			}
		}
		return result;
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

	private Rule processRule(Rule rule, ar.com.fluxit.jqa.rule.Rule jqaRule) {
		rule.setKey(jqaRule.getName());
		rule.setSeverity(RulePriority.valueOf(getPriority(jqaRule.getPriority())));
		rule.setName(jqaRule.getName());
		rule.setDescription(jqaRule.getMessage());
		return rule;
	}

}
