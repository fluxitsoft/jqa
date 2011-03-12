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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.predicate.lang;

import java.util.Collection;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.FilteredPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ThrowingPredicate extends FilteredPredicate {

	public ThrowingPredicate() {
		super();
	}

	public ThrowingPredicate(Predicate filterRule) {
		super(filterRule);
	}

	@Override
	public boolean evaluate(JavaClass clazz, RulesContext context) {
		final Collection<JavaClass> throwedClasses = RepositoryLocator
				.getRepository().getThrows(clazz);
		for (final JavaClass throwedClass : throwedClasses) {
			if (getFilterRule().evaluate(throwedClass, context)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Predicate getFilterRule() {
		return filterRule;
	}

	@Override
	public void setFilterRule(Predicate filterRule) {
		this.filterRule = filterRule;
	}

}
