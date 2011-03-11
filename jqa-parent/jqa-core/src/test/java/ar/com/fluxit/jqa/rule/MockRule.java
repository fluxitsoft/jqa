package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

public class MockRule implements Rule {

	private final Predicate filterPredicate;
	private final Predicate checkPredicate;

	public MockRule(Predicate filterPredicate, Predicate checkPredicate) {
		super();
		this.filterPredicate = filterPredicate;
		this.checkPredicate = checkPredicate;
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
		return "";
	}

}
