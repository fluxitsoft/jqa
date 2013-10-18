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
package ar.com.fluxit.jqa.result;

import java.util.Collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
	private Collection<Integer> lineIds;
	private String targetFileName;

	public RuleCheckFailed() {
		super();
	}

	public RuleCheckFailed(String ruleName, String ruleMessage,
			String targetClassName, int rulePriority) {
		super();
		this.ruleName = ruleName;
		this.ruleMessage = ruleMessage;
		this.targetClassName = targetClassName;
		this.rulePriority = rulePriority;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof RuleCheckFailed) {
			RuleCheckFailed other = (RuleCheckFailed) obj;
			return new EqualsBuilder().append(ruleName, other.ruleName)
					.append(targetFileName, other.targetFileName)
					.append(lineIds, other.lineIds).isEquals();
		} else {
			return false;
		}
	}

	public Collection<Integer> getLineIds() {
		return this.lineIds;
	}

	public String getRuleMessage() {
		return this.ruleMessage;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public int getRulePriority() {
		return this.rulePriority;
	}

	public String getTargetClassName() {
		return this.targetClassName;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(ruleName).append(targetFileName)
				.append(lineIds).toHashCode();
	}

	public void setLineIds(Collection<Integer> lineIds) {
		this.lineIds = lineIds;
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
		this.targetClassName = className;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}

	@Override
	public String toString() {
		return "(RuleName='" + getRuleName() + "' TargetClassName="
				+ getTargetClassName() + ")";
	}

}
