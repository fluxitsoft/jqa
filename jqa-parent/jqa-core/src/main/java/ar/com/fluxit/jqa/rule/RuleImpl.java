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
package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleImpl implements Rule {

	private static final int DEFAULT_PRIORITY = 5;
	private static final boolean DEFAULT_BIDIRECTIONAL_CHECK = false;
	private Predicate filterPredicate;
	private Predicate checkPredicate;
	private String name;
	private String message;
	private int priority;
	private boolean bidirectionalCheck;

	public RuleImpl(Predicate filterPredicate, Predicate checkPredicate, String name, String message) {
		super();
		this.filterPredicate = filterPredicate;
		this.checkPredicate = checkPredicate;
		this.name = name;
		this.message = message;
		this.bidirectionalCheck = DEFAULT_BIDIRECTIONAL_CHECK;
		this.priority = DEFAULT_PRIORITY;
	}

	public boolean getBidirectionalCheck() {
		return this.bidirectionalCheck;
	}

	@Override
	public Predicate getCheckPredicate() {
		return this.checkPredicate;
	}

	@Override
	public Predicate getFilterPredicate() {
		return this.filterPredicate;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setBidirectionalCheck(boolean bidirectionalCheck) {
		this.bidirectionalCheck = bidirectionalCheck;
	}

	public void setCheckPredicate(Predicate checkPredicate) {
		this.checkPredicate = checkPredicate;
	}

	public void setFilterPredicate(Predicate filterPredicate) {
		this.filterPredicate = filterPredicate;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(int priority) {
		if (priority < 1 || priority > 5) {
			throw new IllegalArgumentException("Priority must be a numerical value between 1 and 5");
		}
		this.priority = priority;
	}
}
