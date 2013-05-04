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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
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

public class JQAEclipseRunner {

	public static JQAEclipseRunner INSTANCE = new JQAEclipseRunner();
	private static Logger LOGGER = LoggerFactory
			.getLogger(JQAEclipseRunner.class);

	private JQAEclipseRunner() {
		// hide constructor
	}

	private File getAbsolutePath(IPath path) throws JavaModelException {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(path)
				.getLocation().toFile();
	}

	private Collection<File> getClassFiles(IJavaProject javaProject) {
		Collection<File> result = new ArrayList<File>();
		try {
			File buildDir = getAbsolutePath(javaProject.getOutputLocation());
			result.addAll(FileUtils.listFiles(buildDir, new SuffixFileFilter(
					RulesContextChecker.CLASS_SUFFIX), TrueFileFilter.INSTANCE));
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException("Can not parse Java project: "
					+ javaProject.getElementName(), e);
		}
	}

	private Collection<File> getClassPath(IJavaProject javaProject) {
		// FIXME
		return null;
	}

	private void run(IResource rulesContextFile, IProject targetProject)
			throws RulesContextFactoryException, IntrospectionException,
			FileNotFoundException, TypeFormatException, IOException {
		final IJavaProject javaProject = JavaCore.create(targetProject);
		final RulesContextFactory rulesContextFactory = RulesContextFactoryLocator
				.getRulesContextFactory();
		final RulesContext rulesContext = rulesContextFactory
				.getRulesContext(rulesContextFile.getRawLocation().toOSString());
		Collection<File> classPath = getClassPath(javaProject);
		Collection<File> classFiles = getClassFiles(javaProject);
		String sourceJavaVersion = javaProject.getJavaModel().toString(); // FIXME
		try {
			IPackageFragmentRoot[] packageFragmentRoot = javaProject
					.getAllPackageFragmentRoots();
			for (int i = 0; i < packageFragmentRoot.length; i++) {
				if (packageFragmentRoot[i].getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT
						&& !packageFragmentRoot[i].isArchive()) {
					File sourceDir = getAbsolutePath(packageFragmentRoot[i]
							.getPath());
					RulesContextChecker.INSTANCE.check(targetProject.getName(),
							classFiles, classPath, rulesContext, sourceDir,
							sourceJavaVersion, LOGGER);
				}
			}
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
