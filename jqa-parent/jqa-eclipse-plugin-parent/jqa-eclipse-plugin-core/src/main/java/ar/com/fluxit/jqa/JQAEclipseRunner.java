/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.management.IntrospectionException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fluxit.jqa.bce.TypeFormatException;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactory;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.utils.Utils;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAEclipseRunner {

	public static JQAEclipseRunner INSTANCE = new JQAEclipseRunner();
	private static Logger LOGGER = LoggerFactory
			.getLogger(JQAEclipseRunner.class);

	private JQAEclipseRunner() {
		// hide constructor
	}

	private Collection<File> getClassFiles(IJavaProject javaProject)
			throws JavaModelException {
		Collection<File> result = new ArrayList<File>();
		File buildDir = Utils.getAbsolutePath(javaProject.getOutputLocation());
		result.addAll(FileUtils.listFiles(buildDir, new SuffixFileFilter(
				RulesContextChecker.CLASS_SUFFIX), TrueFileFilter.INSTANCE));
		return result;
	}

	private Collection<File> getClassPath(IJavaProject javaProject)
			throws JavaModelException {
		Collection<File> result = new ArrayList<File>();
		for (IPackageFragmentRoot classpathEntry : javaProject
				.getAllPackageFragmentRoots()) {
			if (classpathEntry.isExternal()) {
				result.add(classpathEntry.getPath().toFile());
			} else {
				result.add(Utils.getAbsolutePath(((IJavaProject) classpathEntry
						.getParent()).getOutputLocation()));
			}

		}
		return result;
	}

	private void run(IResource rulesContextFile, IProject targetProject)
			throws RulesContextFactoryException, IntrospectionException,
			FileNotFoundException, TypeFormatException, IOException {
		final IJavaProject javaProject = JavaCore.create(targetProject);
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		final RulesContext rulesContext = rulesContextFactory
				.getRulesContext(rulesContextFile.getRawLocation().toOSString());
		try {
			Collection<File> classPath = getClassPath(javaProject);
			Collection<File> classFiles = getClassFiles(javaProject);
			String sourceJavaVersion = javaProject.getOption(
					JavaCore.COMPILER_SOURCE, true);
			File[] sourceDir = Utils.getSourcesDirs(javaProject);
			final CheckingResult checkResult = RulesContextChecker.INSTANCE
					.check(targetProject.getName(), classFiles, classPath,
							rulesContext, sourceDir, sourceJavaVersion, LOGGER);
			JQAEclipseMarker.INSTANCE.mark(javaProject, checkResult);
		} catch (JavaModelException e) {
			throw new IllegalStateException("Can not parse Java project: "
					+ javaProject.getElementName(), e);
		}
	}

	public void run(IResource rulesContextFile, IProject[] targetProjects)
			throws RulesContextFactoryException, IntrospectionException,
			FileNotFoundException, TypeFormatException, IOException {
		for (IProject targetProject : targetProjects) {
			run(rulesContextFile, targetProject);
		}
	}

}