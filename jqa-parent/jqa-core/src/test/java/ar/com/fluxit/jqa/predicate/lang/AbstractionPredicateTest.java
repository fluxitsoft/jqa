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

import java.io.Serializable;

import junit.framework.TestCase;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.Repository;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate;
import ar.com.fluxit.jqa.predicate.lang.AbstractionPredicate.AbstractionType;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class AbstractionPredicateTest extends TestCase {

	public final void testCheck() throws ClassNotFoundException {
		final Repository repository = RepositoryLocator.getRepository();
		final JavaClass concreteClazz = repository.lookupClass(Integer.class);
		final JavaClass interfaceClazz = repository
				.lookupClass(Serializable.class);
		final JavaClass abstractClazz = repository.lookupClass(Number.class);

		// Is Abstract ?
		assertFalse(new AbstractionPredicate(AbstractionType.ABSTRACT).evaluate(concreteClazz));
		assertFalse(new AbstractionPredicate(AbstractionType.ABSTRACT).evaluate(interfaceClazz));
		assertTrue(new AbstractionPredicate(AbstractionType.ABSTRACT).evaluate(abstractClazz));
		// Is Interface ?
		assertFalse(new AbstractionPredicate(AbstractionType.INTERFACE).evaluate(concreteClazz));
		assertTrue(new AbstractionPredicate(AbstractionType.INTERFACE).evaluate(interfaceClazz));
		assertFalse(new AbstractionPredicate(AbstractionType.INTERFACE).evaluate(abstractClazz));
		// Is Concrete ?
		assertTrue(new AbstractionPredicate(AbstractionType.CONCRETE).evaluate(concreteClazz));
		assertFalse(new AbstractionPredicate(AbstractionType.CONCRETE).evaluate(interfaceClazz));
		assertFalse(new AbstractionPredicate(AbstractionType.CONCRETE).evaluate(abstractClazz));
	}

}
