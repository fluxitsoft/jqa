package ar.com.fluxit.jqa.mock;

import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.context.CheckingContext;

public class MockCheckingContext implements CheckingContext {

	@Override
	public Repository getRepository() {
		return null;
	}

}
