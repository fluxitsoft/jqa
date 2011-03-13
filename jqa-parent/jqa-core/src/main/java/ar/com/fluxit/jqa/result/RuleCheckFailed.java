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
package ar.com.fluxit.jqa.result;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleCheckFailed {

	private Predicate predicate;
	private String targetClassName;

	public RuleCheckFailed() {

	}

	public RuleCheckFailed(Predicate predicate, String targetClassName) {
		super();
		this.predicate = predicate;
		this.targetClassName = targetClassName;
	}

	protected Predicate getPredicate() {
		return predicate;
	}

	protected String getTargetClassName() {
		return targetClassName;
	}

	protected void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}

	protected void setTargetClassName(String className) {
		targetClassName = className;
	}

}
