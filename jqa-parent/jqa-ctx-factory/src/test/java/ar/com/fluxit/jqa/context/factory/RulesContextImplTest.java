package ar.com.fluxit.jqa.context.factory;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextImplTest extends TestCase {

	public static void testA() throws RulesContextFactoryException {
		RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		URL resource = RulesContextImplTest.class
				.getResource("/sample_rulescontext.xml");
		rulesContextFactory.getRulesContext(new File(resource.getPath()));
	}

}
