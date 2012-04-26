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
package ar.com.fluxit.jqa.result;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleCheckFailed {

	private String ruleName;
	private String ruleMessage;
	private String targetClassName;
	private int rulePriority;
	private Integer lineId;

	public RuleCheckFailed() {
		super();
	}

	public RuleCheckFailed(String ruleName, String ruleMessage, String targetClassName, int rulePriority) {
		super();
		this.ruleName = ruleName;
		this.ruleMessage = ruleMessage;
		this.targetClassName = targetClassName;
		this.rulePriority = rulePriority;
	}

	public Integer getLineId() {
		return lineId;
	}

	public String getRuleMessage() {
		return ruleMessage;
	}

	public String getRuleName() {
		return ruleName;
	}

	public int getRulePriority() {
		return rulePriority;
	}

	public String getTargetClassName() {
		return targetClassName;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public void setRuleMessage(String ruleMessage) {
		this.ruleMessage = ruleMessage;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public void setRulePriority(int rulePriority) {
		this.rulePriority = rulePriority;
	}

	public void setTargetClassName(String className) {
		targetClassName = className;
	}

	@Override
	public String toString() {
		return "(RuleName='" + getRuleName() + "' TargetClassName=" + getTargetClassName() + ")";
	}

}
