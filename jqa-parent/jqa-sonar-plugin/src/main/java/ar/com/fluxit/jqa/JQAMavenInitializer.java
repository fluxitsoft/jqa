/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package ar.com.fluxit.jqa;

import org.apache.commons.configuration.Configuration;
import org.sonar.api.batch.CoverageExtension;
import org.sonar.api.batch.Initializer;
import org.sonar.api.batch.maven.DependsUponMavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.Project;

/**
 * Provides {@link JQAMavenPluginHandler} and configures correct path to report.
 * Enabled only in Maven environment.
 */
public class JQAMavenInitializer extends Initializer implements CoverageExtension, DependsUponMavenPlugin {

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
		return project.getAnalysisType().isDynamic(true) && !project.getFileSystem().mainFiles(Java.KEY).isEmpty();
	}

	@Override
	public void execute(Project project) {
		Configuration conf = project.getConfiguration();
		String report = project.getFileSystem().getReportOutputDir() + "/jqa-results.xml";
		conf.setProperty(JQASonarPlugin.JQA_REPORT_PATH_PROPERTY, report);
	}

}
