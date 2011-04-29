package ar.com.fluxit.jqa.test.utils;

import java.util.Iterator;

import com.thoughtworks.xstream.converters.DataHolder;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CustomHolder implements DataHolder {

	public CustomHolder() {
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
