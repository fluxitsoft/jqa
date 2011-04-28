/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
 * 
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * JQA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
			method = wrapped.getClass().getDeclaredMethod("unreadByte", new Class[0]);
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
