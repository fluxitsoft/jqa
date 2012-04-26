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

	public void add(Predicate predicate) {
		if (predicate.getName() == null) {
			throw new IllegalArgumentException("Global predicate must has a name");
		}
		globalPredicates.put(predicate.getName(), predicate);
	}

	public void add(RulesContext context) {
		addAll(context.getRuleSets());
		for (final Predicate predicate : context.getGlobalPredicates()) {
			add(predicate);
		}
	}

	public void add(RuleSet ruleSet) {
		ruleSets.add(ruleSet);
	}

	public void addAll(Collection<RuleSet> ruleSets) {
		this.ruleSets.addAll(ruleSets);
	}

	@Override
	public Predicate getGlobalPredicate(String name) {
		return globalPredicates.get(name);
	}

	@Override
	public Collection<Predicate> getGlobalPredicates() {
		return globalPredicates.values();
	}

	@Override
	public Collection<RuleSet> getRuleSets() {
		return ruleSets;
	}

}
