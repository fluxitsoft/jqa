package ar.com.fluxit.jqa.mock;

public class ExceptionA extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionA() {
		super();
	}

	public ExceptionA(String message) {
		super(message);
	}

	public ExceptionA(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionA(Throwable cause) {
		super(cause);
	}

}
