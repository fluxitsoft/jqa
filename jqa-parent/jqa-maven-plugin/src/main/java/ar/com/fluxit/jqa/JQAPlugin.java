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
import java.io.FileInputStream;
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

	// FIXME volar este metodo
	// public static void main(String[] args) throws IOException {
	// final Configuration configuration = new Configuration();
	//
	// final Check ruleset1 = new Check();
	// ruleset1.setFilterRule(new NamingPredicate("**.entities.**"));
	// ruleset1.setCheckRule(new TypingPredicate(
	// "ar.com.osde.framework.entities.FrameworkEntity"));
	//
	// final Check ruleset2 = new Check();
	// ruleset2.setFilterRule(new NamingPredicate("**.bo.**"));
	// ruleset2.setCheckRule(new TypingPredicate(
	// "ar.com.osde.framework.business.base.BusinessObject"));
	//
	// final XStream xs = new XStream();
	// configuration.addCheck(ruleset1);
	// configuration.addCheck(ruleset2);
	// final Writer w = new FileWriter(
	// "/home/jbarisich/qa-java-apps-ruleset.xml");
	// final Writer out = new BufferedWriter(w);
	// xs.toXML(configuration, out);
	// out.close();
	// w.close();
	//
	// System.out.println(xs.fromXML(new FileInputStream(
	// "/home/jbarisich/qa-java-apps-ruleset.xml")));
	// }

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
	 * @parameter expression="${resultsFile}"
	 * @required
	 */
	private File resultsFile;

	/**
	 * @parameter expression="${rulesFile}"
	 * @required
	 */
	private String rulesFile;

	private Logger logger;

	@Override
	public void execute() throws MojoExecutionException {
		try {
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
			final XStream xs = new XStream();
			xs.setMode(XStream.NO_REFERENCES);
			getLog().debug("Reading configuration from " + getRulesFile());

			final FileInputStream fis = new FileInputStream(getRulesFile());
			// final Configuration configuration = (Configuration)
			// xs.fromXML(fis);
			fis.close();
			// Check the rules
			final CheckingResult result = JQAChecker.INSTANCE.check(classFiles,
					null, getLogger());
			// Writes the results
			getLog().debug("Writing the results on " + getResultsFile());
			final Writer w = new FileWriter(getResultsFile());
			final Writer out = new BufferedWriter(w);
			xs.toXML(result, out);
			out.close();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private Logger getLogger() {
		if (logger == null) {
			logger = new MavenLogLoggerAdapter(getLog());
		}
		return logger;
	}

	public File getResultsFile() {
		return resultsFile;
	}

	public String getRulesFile() {
		return rulesFile;
	}

	public void setResultsFile(File resultFile) {
		resultsFile = resultFile;
	}

	public void setRulesFile(String rulesFile) {
		this.rulesFile = rulesFile;
	}
}
