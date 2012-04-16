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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.resources.Project;
/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAMavenPluginHandler implements MavenPluginHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(JQAMavenPluginHandler.class);

	public String getGroupId() {
		return JQASonarPlugin.JQA_GROUP_ID;
	}

	public String getArtifactId() {
		return JQASonarPlugin.JQA_ARTIFACT_ID;
	}

	public String getVersion() {
		return JQASonarPlugin.JQA_VERSION;
	}

	public boolean isFixedVersion() {
		return false;
	}

	public String[] getGoals() {
		return new String[] { JQASonarPlugin.JQA_GOAL };
	}

	public void configure(Project project, MavenPlugin jqaPlugin) {
		LOGGER.info("Paso");
	}
}