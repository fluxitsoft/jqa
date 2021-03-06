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
import java.util.Set;

import javax.management.IntrospectionException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;

import ar.com.fluxit.jqa.bce.TypeFormatException;
import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.exporter.CheckingResultExporter;
import ar.com.fluxit.jqa.exporter.ExporterException;
import ar.com.fluxit.jqa.log.MavenLogLoggerAdapter;
import ar.com.fluxit.jqa.result.CheckingResult;

/**
 * Goal checks Java applications for QA
 * 
 * @goal check
 * @requiresDependencyResolution test
 * @phase test
 * @author Juan Ignacio Barisich
 */
public class JQAMavenPlugin extends AbstractMojo {

	/**
	 * @parameter expression="${project.packaging}"
	 */
	protected String packaging;

	/**
	 * @parameter expression="${project}"
	 * @readonly
	 * @required
	 */
	protected MavenProject project;

	/**
	 * @parameter default-value="${project.build.outputDirectory}"
	 * @readonly
	 * @required
	 */
	private File outputDirectory;

	/**
	 * @parameter default-value="${project.build.sourceDirectory}"
	 * @readonly
	 * @required
	 */
	private File sourceDir;

	/**
	 * @parameter expression="${resultsDirectory}"
	 * @required
	 */
	private File resultsDirectory;

	/**
	 * @parameter expression="${rulesContextFile}"
	 * @required
	 */
	private File rulesContextFile;

	/**
	 * @parameter expression="${xslt}"
	 */
	private File xslt;

	private Logger logger;

	private void checkParams() {
		if (getRulesContextFile() == null) {
			throw new IllegalArgumentException(
					"Rules context file can not be null");
		}
		if (!getRulesContextFile().exists()) {
			throw new IllegalArgumentException(
					"Rules context file does not exist: "
							+ getRulesContextFile());
		}
		if (getResultsDirectory() == null) {
			throw new IllegalArgumentException(
					"Results directory can not be null");
		}
		if (!getResultsDirectory().exists()) {
			throw new IllegalArgumentException(
					"Results directory does not exist: "
							+ getResultsDirectory());
		}
		if (!getResultsDirectory().isDirectory()) {
			throw new IllegalArgumentException("Invalid results directory: "
					+ getResultsDirectory());
		}
	}

	private void doExecute(File buildDirectory, File outputDirectory,
			File testOutputDirectory, MavenProject project, File sourceDir,
			String sourceJavaVersion) throws IntrospectionException,
			TypeFormatException, FileNotFoundException, IOException,
			RulesContextFactoryException, ExporterException {
		// Add project dependencies to classpath
		getLog().debug("Adding project dependencies to classpath");
		final Collection<File> classPath = new ArrayList<File>();
		@SuppressWarnings("unchecked")
		final Set<Artifact> artifacts = project.getArtifacts();
		for (final Artifact artifact : artifacts) {
			classPath.add(artifact.getFile());
		}
		// Add project classes to classpath
		if (outputDirectory != null) {
			classPath.add(outputDirectory);
		}
		if (testOutputDirectory != null) {
			classPath.add(testOutputDirectory);
		}
		getLog().debug("Adding project classes to classpath");
		final Collection<File> classFiles = FileUtils.listFiles(buildDirectory,
				new SuffixFileFilter(RulesContextChecker.CLASS_SUFFIX),
				TrueFileFilter.INSTANCE);
		// Reads the config file
		getLog().debug("Reading rules context");
		final RulesContext rulesContext = RulesContextFactoryLocator
				.getRulesContextFactory().getRulesContext(
						getRulesContextFile().getPath());
		getLog().debug("Checking rules for " + classFiles.size() + " files");
		final CheckingResult checkingResult = RulesContextChecker.INSTANCE
				.check(project.getArtifactId(), classFiles, classPath,
						rulesContext, new File[] { sourceDir },
						sourceJavaVersion, getLogger());
		CheckingResultExporter.INSTANCE.export(checkingResult,
				project.getArtifactId(), getResultsDirectory(), this.xslt,
				getLogger());
	}

	@Override
	public void execute() throws MojoExecutionException {
		try {
			if ("pom".equals(this.packaging)) {
				getLog().info("Artifact ignored because it has pom packaging");
			} else {
				checkParams();
				String sourceJavaVersion = getSourceJavaVersion(this.project);
				getLogger().info(
						"The source Java version is " + sourceJavaVersion);
				doExecute(this.outputDirectory, new File(this.project
						.getBuild().getOutputDirectory()), new File(
						this.project.getBuild().getTestOutputDirectory()),
						this.project, this.sourceDir, sourceJavaVersion);
			}
		} catch (final Exception e) {
			throw new MojoExecutionException(
					"An error occurred while executing the rules", e);
		}
	}

	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = new MavenLogLoggerAdapter(getLog());
		}
		return this.logger;
	}

	public File getResultsDirectory() {
		return this.resultsDirectory;
	}

	public File getRulesContextFile() {
		return this.rulesContextFile;
	}

	private String getSourceJavaVersion(MavenProject project) {
		try {
			return ((org.codehaus.plexus.util.xml.Xpp3Dom) ((org.apache.maven.model.Plugin) project
					.getBuild().getPluginsAsMap()
					.get("org.apache.maven.plugins:maven-compiler-plugin"))
					.getConfiguration()).getChild("source").getValue();
		} catch (Exception e) {
			return null;
		}
	}

	public void setResultsDirectory(File resultFile) {
		this.resultsDirectory = resultFile;
	}

	public void setRulesContextFile(File rulesFile) {
		this.rulesContextFile = rulesFile;
	}
}
