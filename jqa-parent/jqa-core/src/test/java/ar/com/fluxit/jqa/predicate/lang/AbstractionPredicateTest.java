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

import java.io.Serializable;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.bce.Type;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AbstractionPredicateTest extends TestCase {

	private AbstractionPredicate createPredicate(AbstractionType abstractionType) {
		final AbstractionPredicate result = new AbstractionPredicate();
		result.setAbstractionType(abstractionType);
		return result;
	}

	public final void testCheck() throws ClassNotFoundException {
		final Repository repository = RepositoryLocator.getRepository();
		final Type concreteType = repository.lookupType(Integer.class);
		final Type interfaceType = repository.lookupType(Serializable.class);
		final Type abstractType = repository.lookupType(Number.class);

		// Is Abstract ?
		assertFalse(createPredicate(AbstractionType.ABSTRACT).evaluate(concreteType));
		assertFalse(createPredicate(AbstractionType.ABSTRACT).evaluate(interfaceType));
		assertTrue(createPredicate(AbstractionType.ABSTRACT).evaluate(abstractType));
		// Is Interface ?
		assertFalse(createPredicate(AbstractionType.INTERFACE).evaluate(concreteType));
		assertTrue(createPredicate(AbstractionType.INTERFACE).evaluate(interfaceType));
		assertFalse(createPredicate(AbstractionType.INTERFACE).evaluate(abstractType));
		// Is Concrete ?
		assertTrue(createPredicate(AbstractionType.CONCRETE).evaluate(concreteType));
		assertFalse(createPredicate(AbstractionType.CONCRETE).evaluate(interfaceType));
		assertFalse(createPredicate(AbstractionType.CONCRETE).evaluate(abstractType));
	}

}
