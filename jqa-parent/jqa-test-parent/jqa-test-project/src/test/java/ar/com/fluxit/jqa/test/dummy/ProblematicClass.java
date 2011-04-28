package ar.com.fluxit.jqa.test.dummy;

import java.util.Iterator;

import com.thoughtworks.xstream.converters.DataHolder;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ProblematicClass implements DataHolder {

	public ProblematicClass() {
		super();
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public Iterator<?> keys() {
		return null;
	}

	@Override
	public void put(Object key, Object value) {

	}

}
