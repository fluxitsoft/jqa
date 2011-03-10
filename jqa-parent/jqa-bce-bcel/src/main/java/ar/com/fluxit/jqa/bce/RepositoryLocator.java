package ar.com.fluxit.jqa.bce;

import ar.com.fluxit.jqa.bce.bcel.RepositoryImpl;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RepositoryLocator {

	private static Repository repository;

	static {
		repository = new RepositoryImpl();
	}

	public static Repository getRepository() {
		return repository;
	}
}
