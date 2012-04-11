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
package ar.com.fluxit.jqa;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.CoverageExtension;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.JavaFile;
import org.sonar.api.resources.Project;
import org.sonar.api.resources.Resource;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQASensor implements Sensor, CoverageExtension {

	private static Logger LOGGER =  LoggerFactory.getLogger(JQASensor.class);
	
	public boolean shouldExecuteOnProject(Project project) {
		return !project.getFileSystem().mainFiles(Java.KEY).isEmpty();
	}

	public void analyse(Project project, SensorContext context) {
		String path = "target/";
		File report = project.getFileSystem().resolvePath(path);
		if (!report.exists() || !report.isFile()) {
			LOGGER.warn("JQA report not found at {}", report);
			return;
		}
		parseReport(report, context);
	}

	protected void parseReport(File xmlFile, final SensorContext context) {
		LOGGER.info("parsing {}", xmlFile);
		new JavaJQAParser().parseReport(xmlFile, context);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	private static final class JavaJQAParser extends AbstractJQAParser {
		@Override
		protected Resource<?> getResource(String fileName) {
			return new JavaFile(fileName);
		}
	}
}
