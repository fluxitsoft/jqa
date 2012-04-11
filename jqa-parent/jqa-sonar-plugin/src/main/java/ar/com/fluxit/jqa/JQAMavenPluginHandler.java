package ar.com.fluxit.jqa;

import org.sonar.api.batch.maven.MavenPlugin;
import org.sonar.api.batch.maven.MavenPluginHandler;
import org.sonar.api.batch.maven.MavenSurefireUtils;
import org.sonar.api.resources.Project;

public class JQAMavenPluginHandler implements MavenPluginHandler {

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
		configureJQAMavenPlugin(project, jqaPlugin);
		MavenSurefireUtils.configure(project);
	}

	private void configureJQAMavenPlugin(Project project, MavenPlugin jqaPlugin) {
		// TODO jqaPlugin.setParameter("formats/format", "xml");
	}
}