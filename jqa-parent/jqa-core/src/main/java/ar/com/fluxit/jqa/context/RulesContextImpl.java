/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImpl implements RulesContext {

	private final Collection<RuleSet> ruleSets;
	private final Map<String, String> variables;
	private final Map<String, Predicate> globalPredicates;

	public RulesContextImpl() {
		this.ruleSets = new ArrayList<RuleSet>();
		this.globalPredicates = new HashMap<String, Predicate>();
		this.variables = new HashMap<String, String>();
	}

	public void add(Predicate predicate) {
		if (predicate.getName() == null) {
			throw new IllegalArgumentException(
					"Global predicate must has a name");
		}
		this.globalPredicates.put(predicate.getName(), predicate);
	}

	public void add(RulesContext context) {
		addAll(context.getRuleSets());
		for (final Predicate predicate : context.getGlobalPredicates()) {
			add(predicate);
		}
		for (final Entry<String, String> variable : context
				.getGlobalVariables().entrySet()) {
			add(variable.getKey(), variable.getValue());
		}
	}

	public void add(RuleSet ruleSet) {
		this.ruleSets.add(ruleSet);
	}

	public void add(String name, String value) {
		this.variables.put(name, value);
	}

	public void addAll(Collection<RuleSet> ruleSets) {
		this.ruleSets.addAll(ruleSets);
	}

	@Override
	public Predicate getGlobalPredicate(String name) {
		return this.globalPredicates.get(name);
	}

	@Override
	public Collection<Predicate> getGlobalPredicates() {
		return this.globalPredicates.values();
	}

	@Override
	public String getGlobalVariable(String name) {
		return this.variables.get(name);
	}

	@Override
	public Map<String, String> getGlobalVariables() {
		return this.variables;
	}

	@Override
	public RuleSet getRuleSet(String ruleSetName) {
		if (ruleSetName == null) {
			throw new IllegalArgumentException("RuleSet name can not be null");
		}
		for (RuleSet ruleSet : getRuleSets()) {
			if (ruleSetName.equals(ruleSet.getName())) {
				return ruleSet;
			}
		}
		return null;
	}

	@Override
	public Collection<RuleSet> getRuleSets() {
		return this.ruleSets;
	}

}
