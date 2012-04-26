package ar.com.fluxit.jqa;

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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.JavaFile;
import org.sonar.api.resources.Project;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.Violation;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.result.RuleCheckFailed;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQASensor implements Sensor {

	private static Logger LOGGER = LoggerFactory.getLogger(JQASensor.class);
	private final MavenProject project;

	public JQASensor(MavenProject project) {
		this.project = project;
	}

	private void addViolations(SensorContext context, CheckingResult check) {
		for (final RuleCheckFailed fail : check.getRuleChecksFailed()) {
			final Rule rule = Rule.create(JQARuleRepository.REPOSITORY_KEY, fail.getRuleName());
			final JavaFile resource = new JavaFile(fail.getTargetClassName());
			final Violation violation = Violation.create(rule, resource);
			violation.setMessage(fail.getRuleMessage());
			violation.setLineId(fail.getLineId()); // TODO set the real line
													// number
			context.saveViolation(violation);
		}
	}

	@Override
	public void analyse(Project project, SensorContext context) {
		try {
			final RulesContext rulesContext = RulesContextLoader.INSTANCE.load();
			final File buildDirectory = project.getFileSystem().getBuildOutputDir();
			final Collection<File> classFiles = FileUtils.listFiles(buildDirectory, new SuffixFileFilter(RulesContextChecker.CLASS_SUFFIX),
					TrueFileFilter.INSTANCE);
			final Collection<File> classPath = new ArrayList<File>();
			@SuppressWarnings("unchecked")
			final Set<Artifact> artifacts = getProject().getArtifacts();
			for (final Artifact artifact : artifacts) {
				classPath.add(artifact.getFile());
			}
			// Add project classes to classpath
			if (project.getFileSystem().getBuildOutputDir() != null) {
				classPath.add(project.getFileSystem().getBuildOutputDir());
			}
			if (project.getFileSystem().getTestDirs() != null) {
				classPath.addAll(project.getFileSystem().getTestDirs());
			}
			final File sourceDir = new File((String) getProject().getCompileSourceRoots().get(0));
			final CheckingResult check = RulesContextChecker.INSTANCE.check(classFiles, classPath, rulesContext, sourceDir, LOGGER);
			addViolations(context, check);
		} catch (final Exception e) {
			LOGGER.error("An error occurred", e);
			throw new IllegalStateException(e);
		}
	}

	private MavenProject getProject() {
		return project;
	}

	@Override
	public boolean shouldExecuteOnProject(Project project) {
		return !project.getFileSystem().mainFiles(Java.KEY).isEmpty();
	}

	@Override
	public String toString() {
		return "JQASensor";
	}
}
