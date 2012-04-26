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

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.exception.RegExSyntaxException;
import ar.com.fluxit.jqa.predicate.IgnoringContextPredicate;
import ar.com.fluxit.jqa.util.RegEx;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NamingPredicate extends IgnoringContextPredicate {

	private String classNamePattern;
	// transient for XML serialization
	private transient RegEx regEx;

	public NamingPredicate() {
		super();
	}

	public NamingPredicate(String classNamePattern) {
		super();
		this.classNamePattern = classNamePattern;
	}

	@Override
	public boolean evaluate(Type type) {
		return evaluateClassName(type.getName());
	}

	protected boolean evaluateClassName(String className) {
		try {
			return getRegEx().matches(className);
		} catch (final RegExSyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	public String getClassNamePattern() {
		return classNamePattern;
	}

	private RegEx getRegEx() throws RegExSyntaxException {
		if (regEx == null) {
			regEx = new RegEx(getClassNamePattern());
		}
		return regEx;
	}

	public void setClassNamePattern(String pattern) {
		classNamePattern = pattern;
	}

	@Override
	public String toString() {
		return "NamingPredicate: " + classNamePattern;
	}
}
