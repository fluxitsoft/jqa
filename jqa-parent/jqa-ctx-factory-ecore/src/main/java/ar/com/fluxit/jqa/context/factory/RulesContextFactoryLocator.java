package ar.com.fluxit.jqa.context.factory;

import ar.com.fluxit.jqa.context.factory.ecore.EcoreRulesContextFactory;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextFactoryLocator {

	private static RulesContextFactory instance = new EcoreRulesContextFactory();

	public static RulesContextFactory getRulesContextFactory() {
		return instance;
	}

}
