package ar.com.fluxit.jqa.test.dummy;

import hidden.org.codehaus.plexus.interpolation.ValueSource;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ProblematicClass implements ValueSource {

	public ProblematicClass() {
		super();
	}

	@Override
	public Object getValue(String paramString) {
		return "";
	}
}
