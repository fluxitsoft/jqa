package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface Rule {

	Predicate getCheckPredicate();

	Predicate getFilterPredicate();

	String getMessage();

	String getName();

}
