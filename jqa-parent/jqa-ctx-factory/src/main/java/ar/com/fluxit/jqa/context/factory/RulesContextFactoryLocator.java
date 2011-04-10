package ar.com.fluxit.jqa.context.factory;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextFactoryLocator {

	private static RulesContextFactory instance = new RulesContextFactoryImpl();

	public static RulesContextFactory getRulesContextFactory() {
		return instance;
	}

}
