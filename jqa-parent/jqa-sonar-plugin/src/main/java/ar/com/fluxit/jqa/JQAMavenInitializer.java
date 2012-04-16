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

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Initializer;
import org.sonar.api.batch.maven.DependsUponMavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.Project;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAMavenInitializer extends Initializer implements DependsUponMavenPlugin {

	private Logger LOGGER = LoggerFactory.getLogger(JQAMavenInitializer.class);

	private JQAMavenPluginHandler handler;

	public JQAMavenInitializer(JQAMavenPluginHandler handler) {
		this.handler = handler;
	}

	public MavenPluginHandler getMavenPluginHandler(Project project) {
		if (project.getAnalysisType().equals(Project.AnalysisType.DYNAMIC)) {
			return handler;
		}
		return null;
	}

	@Override
	public boolean shouldExecuteOnProject(Project project) {
		final boolean ok = project.getAnalysisType().isDynamic(true) && !project.getFileSystem().mainFiles(Java.KEY).isEmpty();
		LOGGER.info("JQASonarPlugin will execute = " + ok);
		return ok;
	}

	@Override
	public void execute(Project project) {
		Configuration conf = project.getConfiguration();
		String report = project.getFileSystem().getReportOutputDir() + "/jqa-results.xml";
		conf.setProperty(JQASonarPlugin.JQA_REPORT_PATH_PROPERTY, report);
	}

}
