package ar.com.fluxit.jqa.bce.bcel;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class ByteSequence {

	private final org.apache.bcel.util.ByteSequence wrapped;
	private Method method;

	public ByteSequence(byte[] code) {
		wrapped = new org.apache.bcel.util.ByteSequence(code);
	}

	public int available() throws IOException {
		return wrapped.available();
	}

	private Method getUnreadByteMethod() throws NoSuchMethodException {
		if (method == null) {
			method = wrapped.getClass().getDeclaredMethod("unreadByte",
					new Class[0]);
			method.setAccessible(true);
		}
		return method;
	}

	public int readUnsignedByte() throws IOException {
		return wrapped.readUnsignedByte();
	}

	public int readUnsignedShort() throws IOException {
		return wrapped.readUnsignedShort();
	}

	public void unreadByte() throws IllegalStateException {
		try {
			getUnreadByteMethod().invoke(wrapped, new Object[0]);
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
