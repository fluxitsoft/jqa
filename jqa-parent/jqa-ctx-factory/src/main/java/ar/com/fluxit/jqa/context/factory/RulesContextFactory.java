package ar.com.fluxit.jqa.context.factory;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public interface RulesContextFactory {

	RulesContext getRulesContext(Object source)
			throws RulesContextFactoryException;

}
