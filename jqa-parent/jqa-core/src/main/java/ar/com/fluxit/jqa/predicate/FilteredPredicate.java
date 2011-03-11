package ar.com.fluxit.jqa.predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class FilteredPredicate extends AbstractPredicate {

	protected Predicate filterRule;

	public FilteredPredicate() {
		super();
	}

	public FilteredPredicate(Predicate filterRule) {
		super();
		this.filterRule = filterRule;
	}

	public Predicate getFilterRule() {
		return filterRule;
	}

	public void setFilterRule(Predicate filterRule) {
		this.filterRule = filterRule;
	}

}