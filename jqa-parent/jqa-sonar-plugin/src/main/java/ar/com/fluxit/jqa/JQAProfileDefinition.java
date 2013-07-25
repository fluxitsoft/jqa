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

import java.util.ArrayList;
import java.util.List;

import org.sonar.api.database.model.ResourceModel;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Java;
import org.sonar.api.rules.Rule;
import org.sonar.api.utils.ValidationMessages;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAProfileDefinition extends ProfileDefinition {

	private static final String RULES_PROFILE_NAME = "JQA way";

	private final JQARuleRepository jqaRuleRepository;

	public JQAProfileDefinition(JQARuleRepository jqaRuleRepository) {
		this.jqaRuleRepository = jqaRuleRepository;
	}

	@Override
	public RulesProfile createProfile(ValidationMessages validation) {
		RulesProfile result = RulesProfile.create(RULES_PROFILE_NAME, Java.KEY);
		for (Rule rule : jqaRuleRepository.createRules()) {
			result.activateRule(rule, null);
		}
		List<ResourceModel> projects = new ArrayList<ResourceModel>();
		ResourceModel project = new ResourceModel();
		project.setKey("jqa-test-parent");
		project.setName("jqa-test-parent");
		projects.add(project);
		result.setProjects(projects);
		return result;
	}

}
