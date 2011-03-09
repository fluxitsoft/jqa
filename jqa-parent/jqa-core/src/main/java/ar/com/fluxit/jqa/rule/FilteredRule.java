package ar.com.fluxit.jqa.rule;

import java.util.Collection;

import ar.com.fluxit.jqa.bce.JavaClass;
import ar.com.fluxit.jqa.bce.RepositoryLocator;
import ar.com.fluxit.jqa.context.CheckingContext;

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

	@Override
	public final boolean check(JavaClass clazz, CheckingContext checkingContext) {
		final Collection<JavaClass> filteredClasses = RepositoryLocator
				.getRepository().getUses(clazz);
		return check(filteredClasses, checkingContext);
	}

	protected abstract boolean check(Collection<JavaClass> filteredClasses,
			CheckingContext checkingContext);

}