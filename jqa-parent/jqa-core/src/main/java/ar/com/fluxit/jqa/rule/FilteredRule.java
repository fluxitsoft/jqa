package ar.com.fluxit.jqa.rule;


/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class FilteredRule implements Rule {

	protected Rule filterRule;

	public FilteredRule() {
		super();
	}

	
	public FilteredRule(Rule filterRule) {
		super();
		this.filterRule = filterRule;
	}

	public Rule getFilterRule() {
		return filterRule;
	}

	public void setFilterRule(Rule filterRule) {
		this.filterRule = filterRule;
	}

}