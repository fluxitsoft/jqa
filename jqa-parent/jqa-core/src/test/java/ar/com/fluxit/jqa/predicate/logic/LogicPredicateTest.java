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
package ar.com.fluxit.jqa.predicate.logic;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class LogicPredicateTest extends TestCase {

	protected Predicate[] getFalseFalse() {
		return new Predicate[] { FalsePredicate.INSTANCE, FalsePredicate.INSTANCE };
	}

	protected Predicate[] getFalseTrue() {
		return new Predicate[] { FalsePredicate.INSTANCE, TruePredicate.INSTANCE };
	}

	protected Predicate[] getTrueFalse() {
		return new Predicate[] { TruePredicate.INSTANCE, FalsePredicate.INSTANCE };
	}

	protected Predicate[] getTrueTrue() {
		return new Predicate[] { TruePredicate.INSTANCE, TruePredicate.INSTANCE };
	}

}
