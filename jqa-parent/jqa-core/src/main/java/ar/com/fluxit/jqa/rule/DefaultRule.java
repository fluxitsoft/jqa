package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class DefaultRule implements Rule {

	private Predicate filterPredicate;

	private Predicate checkPredicate;
	private String name;

	public DefaultRule(Predicate filterPredicate, Predicate checkPredicate,
			String name) {
		super();
		this.filterPredicate = filterPredicate;
		this.checkPredicate = checkPredicate;
		this.name = name;
	}

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
