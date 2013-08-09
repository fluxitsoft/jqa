/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.predicate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class AbstractPredicate implements Predicate {

	private String name;

	public AbstractPredicate() {
		super();
	}

	protected Collection<Integer> getDeclarationLineNumber(Type type,
			File[] sourcesDir) {
		Collection<Integer> result = new ArrayList<Integer>();
		result.add(BCERepositoryLocator.getRepository()
				.getDeclarationLineNumber(type));
		return result;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
