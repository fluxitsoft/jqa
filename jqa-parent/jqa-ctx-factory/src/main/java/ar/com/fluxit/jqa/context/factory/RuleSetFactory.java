package ar.com.fluxit.jqa.context.factory;

import ar.com.fluxit.jqa.context.factory.exception.RuleSetFactoryException;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface RuleSetFactory {

	RuleSet getRuleSet(Object source) throws RuleSetFactoryException;

}
