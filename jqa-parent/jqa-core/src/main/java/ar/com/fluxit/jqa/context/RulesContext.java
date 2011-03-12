package ar.com.fluxit.jqa.context;

import java.util.Collection;

import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface RulesContext {

	Predicate getGlobalPredicate(String name);

	Collection<RuleSet> getRuleSets();

}
