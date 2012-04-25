/*******************************************************************************
 * JQA (http://github.com/jbaris/jqa)
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
package ar.com.fluxit.jqa.bce.asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import javax.management.IntrospectionException;

import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.bce.TypeFormatException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RepositoryImpl implements Repository {

	@Override
	public Collection<Type> getAllocations(Type type) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Integer getDeclarationLineNumber(Type type) {
		return ((AsmType) type).getDeclarationLineNumber();
	}

	@Override
	public Collection<Type> getInterfaces(Type type) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Collection<Type> getSuperClasses(Type type) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Collection<Type> getThrows(Type type) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Collection<Type> getUses(Type type) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Type lookupType(Class<?> clazz) throws ClassNotFoundException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Type lookupType(String typeName) throws ClassNotFoundException {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Type parse(FileInputStream classFile, String typeName) throws TypeFormatException, IOException {
		Type result = new AsmType(classFile);
		return result;
	}

	@Override
	public void setClassPath(Collection<File> classPathFiles) throws IntrospectionException, FileNotFoundException, TypeFormatException, IOException {
		// do nothing
	}

}
