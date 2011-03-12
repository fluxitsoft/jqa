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
package ar.com.fluxit.jqa.predicate.logic;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.AbstractPredicate;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NotPredicate extends AbstractPredicate {

	private Predicate rule;

	public NotPredicate() {
		super();
	}

	public NotPredicate(Predicate rule) {
		this.rule = rule;
	}

	@Override
	public boolean evaluate(JavaClass clazz, RulesContext context) {
		return !getRule().evaluate(clazz, context);
	}

	public Predicate getRule() {
		return rule;
	}

	public void setRule(Predicate rule) {
		this.rule = rule;
	}

}
