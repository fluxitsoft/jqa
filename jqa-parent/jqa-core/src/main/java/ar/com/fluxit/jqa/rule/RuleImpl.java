package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
class RuleImpl implements Rule {

	private Predicate filterPredicate;
	private Predicate checkPredicate;
	private String name;

	@Override
	public Predicate getCheckPredicate() {
		return checkPredicate;
	}

	@Override
	public Predicate getFilterPredicate() {
		return filterPredicate;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setCheckPredicate(Predicate checkPredicate) {
		this.checkPredicate = checkPredicate;
	}

	public void setFilterPredicate(Predicate filterPredicate) {
		this.filterPredicate = filterPredicate;
	}

	public void setName(String name) {
		this.name = name;
	}
}
