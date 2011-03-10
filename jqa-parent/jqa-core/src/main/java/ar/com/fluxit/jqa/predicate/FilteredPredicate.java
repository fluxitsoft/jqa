package ar.com.fluxit.jqa.predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class FilteredPredicate implements Rule {

	protected Rule filterRule;

	public FilteredPredicate() {
		super();
	}

	public FilteredPredicate(Rule filterRule) {
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