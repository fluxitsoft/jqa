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
package ar.com.fluxit.jqa.mock.logic;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.predicate.CheckPredicate;
import ar.com.fluxit.jqa.predicate.IgnoringContextPredicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TrueCheckPredicate extends IgnoringContextPredicate implements CheckPredicate {

	public static final CheckPredicate INSTANCE = new TrueCheckPredicate();

	private TrueCheckPredicate() {
		super();
		setName("AlwaysTruePredicate");
	}

	@Override
	public boolean evaluate(Type type) {
		return true;
	}

	@Override
	public Collection<Integer> getViolationLineIds(Type type, File sourcesDir, RulesContext context) {
		return Collections.emptyList();
	}

}
