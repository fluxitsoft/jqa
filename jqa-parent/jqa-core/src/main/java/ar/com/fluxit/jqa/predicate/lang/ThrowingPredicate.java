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
public class ThrowingPredicate extends FilteredPredicate implements CheckPredicate {

	public ThrowingPredicate() {
		super();
	}

	@Override
	public boolean evaluate(Type type, RulesContext context) {
		final Collection<Type> throwedClasses = BCERepositoryLocator.getRepository().getThrows(type);
		for (final Type throwedClass : throwedClasses) {
			if (!getFilterPredicate().evaluate(throwedClass, context)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Collection<Integer> getViolationLineIds(Type type, File sourcesDir, RulesContext context) {
		// FIXME complete
		return getDeclarationLineNumber(type, sourcesDir);
	}

}
