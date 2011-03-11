package ar.com.fluxit.jqa.rule;

import java.util.Collection;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface RuleSet {

	String getName();

	Collection<Rule> getRules();

}
