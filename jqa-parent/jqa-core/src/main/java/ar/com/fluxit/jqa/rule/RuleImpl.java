package ar.com.fluxit.jqa.rule;

import ar.com.fluxit.jqa.predicate.Predicate;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleImpl implements Rule {

	private Predicate filterPredicate;
	private Predicate checkPredicate;
	private String name;
	private String message;

	public RuleImpl(Predicate filterPredicate, Predicate checkPredicate,
			String name, String message) {
		super();
		this.filterPredicate = filterPredicate;
		this.checkPredicate = checkPredicate;
		this.name = name;
		this.message = message;
	}

	@Override
	public Predicate getCheckPredicate() {
		return checkPredicate;
	}

	@Override
	public Predicate getFilterPredicate() {
		return filterPredicate;
	}

	public String getMessage() {
		return message;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}
}
