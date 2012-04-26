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
import java.util.ArrayList;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQASonarPlugin extends SonarPlugin {

	public static final String JQA_GROUP_ID = "ar.com.fluxit.jqa";
	public static final String JQA_ARTIFACT_ID = "jqa-maven-plugin";
	public static final String JQA_VERSION = "1.0";
	public static final String JQA_GOAL = "check";
	public static final String JQA_REPORT_PATH_PROPERTY = "jqa.report.path";

	@Override
	public List<?> getExtensions() {
		final List<Class<? extends Extension>> list = new ArrayList<Class<? extends Extension>>();
		list.add(JQARuleRepository.class);
		list.add(JQASensor.class);
		return list;
	}

}
