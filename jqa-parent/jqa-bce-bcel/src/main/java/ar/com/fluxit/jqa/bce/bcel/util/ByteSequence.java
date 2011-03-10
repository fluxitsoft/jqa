package ar.com.fluxit.jqa.bce.bcel.util;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ByteSequence {

	private org.apache.bcel.util.ByteSequence wrapped;
	private Method method;

	public ByteSequence(byte[] code) {
		this.wrapped = new org.apache.bcel.util.ByteSequence(code);
	}

	public int available() throws IOException {
		return wrapped.available();
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
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private Method getUnreadByteMethod() throws NoSuchMethodException {
		if (method == null) {
			method = wrapped.getClass().getDeclaredMethod("unreadByte", new Class[0]);
			method.setAccessible(true); 
		}
		return method;
	}
}
