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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactoryLocator;
import ar.com.fluxit.jqa.log.MavenLogLoggerAdapter;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.util.ClassPathLoader;

import com.thoughtworks.xstream.XStream;

/**
 * Goal checks Java applications for QA
 * 
 * @goal check
 * @requiresDependencyResolution test
 * @phase generate-sources
 * @author Juan Ignacio Barisich
 */
public class JQAPlugin extends AbstractMojo {

	private static final String CLASS_SUFFIX = "class";

	/**
	 * @parameter expression="${project}"
	 * @readonly
	 * @required
	 */
	protected MavenProject project;

	/**
	 * @parameter expression="${project.build.directory}"
	 * @required
	 */
	private File outputDirectory;

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

	private Logger logger;

	@Override
	public void execute() throws MojoExecutionException {
		try {
			checkParams();
			// Add project dependencies to classpath
			getLog().debug("Adding project dependencies to classpath");
			@SuppressWarnings("unchecked")
			final Set<Artifact> artifacts = project.getArtifacts();
			for (final Artifact artifact : artifacts) {
				ClassPathLoader.INSTANCE.addArtifactFile(artifact.getFile(),
						getLogger());
			}
			// Add project classes to classpath
			getLog().debug("Adding project classes to classpath");
			final Collection<File> classFiles = FileUtils.listFiles(
					outputDirectory, new SuffixFileFilter(CLASS_SUFFIX),
					TrueFileFilter.INSTANCE);
			for (final File file : classFiles) {
				ClassPathLoader.INSTANCE.addClassFile(file, getLogger());
			}
			// Reads the config file
			getLog().debug("Reading rules context");
			RulesContext rulesContext = RulesContextFactoryLocator
					.getRulesContextFactory().getRulesContext(
							getRulesContextFile());
			getLog().debug("Checking rules for " + classFiles.size() + " files");
			CheckingResult checkingResult = RuleSetChecker.INSTANCE.check(
					classFiles, rulesContext, getLogger());
			// Writes the results
			final File resultsFile = new File(getResultsDirectory(), "results-"
					+ project.getArtifactId() + ".xml");
			getLog().debug("Writing the results on " + resultsFile);
			final Writer w = new FileWriter(resultsFile);
			final Writer out = new BufferedWriter(w);
			final XStream xs = new XStream();
			xs.setMode(XStream.NO_REFERENCES);
			xs.toXML(checkingResult, out);
			out.close();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private void checkParams() {
		if (getRulesContextFile() == null)
			throw new IllegalArgumentException(
					"Rules context file can not be null");
		if (!getRulesContextFile().exists())
			throw new IllegalArgumentException(
					"Rules context file does not exist" + getRulesContextFile());
		if (getResultsDirectory() == null)
			throw new IllegalArgumentException(
					"Results directory can not be null");
		if (!getResultsDirectory().exists())
			throw new IllegalArgumentException(
					"Results directory does not exist: "
							+ getResultsDirectory());
		if (!getResultsDirectory().isDirectory())
			throw new IllegalArgumentException("Invalid results directory: "
					+ getResultsDirectory());
	}

	private Logger getLogger() {
		if (logger == null) {
			logger = new MavenLogLoggerAdapter(getLog());
		}
		return logger;
	}

	public File getResultsDirectory() {
		return resultsDirectory;
	}

	public File getRulesContextFile() {
		return rulesContextFile;
	}

	public void setResultsDirectory(File resultFile) {
		resultsDirectory = resultFile;
	}

	public void setRulesContextFile(File rulesFile) {
		rulesContextFile = rulesFile;
	}
}
