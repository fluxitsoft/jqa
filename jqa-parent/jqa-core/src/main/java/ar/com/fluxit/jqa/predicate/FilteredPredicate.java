package ar.com.fluxit.jqa.predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public abstract class FilteredPredicate extends AbstractPredicate {

	protected Predicate filterPredicate;

	public FilteredPredicate() {
		super();
	}

	public Predicate getFilterPredicate() {
		return filterPredicate;
	}

	public void setFilterPredicate(Predicate filterPredicate) {
		this.filterPredicate = filterPredicate;
	}

}