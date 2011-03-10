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
package ar.com.fluxit.jqa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;

import ar.com.fluxit.jqa.bce.ClassFormatException;
import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.config.Check;
import ar.com.fluxit.jqa.config.Configuration;
import ar.com.fluxit.jqa.context.CheckingContext;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.result.RuleCheckFailed;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAChecker {

	public static final JQAChecker INSTANCE = new JQAChecker();

	private JQAChecker() {
		super();
	}

	public CheckingResult check(Collection<File> classFiles,
			Configuration configuration, Logger log) {
		final CheckingResult result = new CheckingResult();
		final CheckingContext checkingContext = null; // TODO
		for (final File classFile : classFiles) {
			try {
				final FileInputStream fis = new FileInputStream(classFile);
				final JavaClass clazz = RepositoryLocator.getRepository()
						.parse(fis, null);
				fis.close();
				for (final Check ruleset : configuration.getChecks()) {
					if (ruleset.getFilterRule().check(clazz, checkingContext)) {
						if (!ruleset.getCheckRule().check(clazz,
								checkingContext)) {
							result.addRuleExecutionFailed(new RuleCheckFailed(
									ruleset.getCheckRule(), clazz
											.getClassName()));
						}
					}
				}
			} catch (final ClassFormatException e) {
				log.debug("Can not check file " + classFile, e);
			} catch (final FileNotFoundException e) {
				log.debug("Can not check file " + classFile, e);
			} catch (final IOException e) {
				log.debug("Can not check file " + classFile, e);
			}
		}
		return result;
	}

}
