package ar.com.fluxit.jqa;

import java.io.InputStream;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

public class RulesContextLoader {

	public static RulesContextLoader INSTANCE = new RulesContextLoader();

	private RulesContextLoader() {
	}

	public RulesContext load() {
		return load(getClass().getResourceAsStream("/ar/com/fluxit/jqa/rulesContext.xml"));
	}

	public RulesContext load(InputStream rulesStream) {
		ClassLoader classLoader = null;
		try {
			classLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
			final RulesContext rulesContext = RulesContextFactoryLocator.getRulesContextFactory().getRulesContext(rulesStream);
			return rulesContext;
		} catch (RulesContextFactoryException e) {
			throw new IllegalStateException(e);
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
		}
	}

}
