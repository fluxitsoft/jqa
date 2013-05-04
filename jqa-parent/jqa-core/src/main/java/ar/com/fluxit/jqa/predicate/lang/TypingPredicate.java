/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
package ar.com.fluxit.jqa.predicate.lang;

import java.io.File;
import java.util.Collection;

import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.CheckPredicate;
import ar.com.fluxit.jqa.predicate.FilteredPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TypingPredicate extends FilteredPredicate implements
		CheckPredicate {

	public TypingPredicate() {
		super();
	}

	@Override
	public boolean evaluate(Type type, RulesContext context) {
		final Collection<Type> superClasses = BCERepositoryLocator
				.getRepository().getSuperClasses(type);
		// superclases
		for (final Type superClass : superClasses) {
			if (getFilterPredicate().evaluate(superClass, context)) {
				return true;
			}
		}
		// superinterfaces
		final Collection<Type> interfaces = BCERepositoryLocator
				.getRepository().getInterfaces(type);
		for (final Type interfaz : interfaces) {
			if (getFilterPredicate().evaluate(interfaz, context)) {
				return true;
			}
		}
		// the class
		return getFilterPredicate().evaluate(type, context);
	}

	@Override
	public Collection<Integer> getViolationLineIds(Type type,
			File[] sourcesDir, RulesContext context) {
		return getDeclarationLineNumber(type, sourcesDir);
	}

	@Override
	public String toString() {
		return "TypingPredicate: [" + getFilterPredicate().toString() + "]";
	}

}
