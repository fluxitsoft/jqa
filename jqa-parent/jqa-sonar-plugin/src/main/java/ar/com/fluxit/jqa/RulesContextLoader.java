/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
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
package ar.com.fluxit.jqa;

import java.io.InputStream;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextLoader {

	public static RulesContextLoader INSTANCE = new RulesContextLoader();

	private RulesContextLoader() {

	}

	public RulesContext load() {
		return load(getClass().getResourceAsStream("/ar/com/fluxit/jqa/rulesContext.xml"), "/ar/com/fluxit/jqa");
	}

	public RulesContext load(InputStream inputStream, String packageBase) {
		ClassLoader classLoader = null;
		try {
			classLoader = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
			final RulesContext rulesContext = RulesContextFactoryLocator.getRulesContextFactory().getRulesContext(inputStream, packageBase);
			return rulesContext;
		} catch (final RulesContextFactoryException e) {
			throw new IllegalStateException(e);
		} finally {
			Thread.currentThread().setContextClassLoader(classLoader);
		}
	}

}
