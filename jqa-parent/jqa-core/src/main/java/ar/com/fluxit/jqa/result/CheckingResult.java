/*******************************************************************************
 * JQA (http://code.google.com/p/jqa-project/)
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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO javadoc TODO ¿hold more info (like ruleset)?
 * 
 * @author Juan Ignacio Barisich
 */
public class CheckingResult {

	private Date date;
	private List<RuleCheckFailed> ruleChecksFailed;

	public CheckingResult() {
		ruleChecksFailed = new ArrayList<RuleCheckFailed>();
		date = new Date();
	}

	public void addRuleExecutionFailed(RuleCheckFailed failed) {
		getRuleChecksFailed().add(failed);
	}

	public Date getDate() {
		return date;
	}

	public List<RuleCheckFailed> getRuleChecksFailed() {
		return ruleChecksFailed;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setRuleChecksFailed(
			List<RuleCheckFailed> ruleExecutionsFailed) {
		this.ruleChecksFailed = ruleExecutionsFailed;
	}

}
