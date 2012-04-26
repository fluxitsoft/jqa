/*
 * XML Type:  FilteredPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * An XML FilteredPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 * 
 * This is a complex type.
 */
public class FilteredPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName PREDICATE$0 = new javax.xml.namespace.QName("", "predicate");

	public FilteredPredicateImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "predicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().add_element_user(PREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "predicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate getPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().find_element_user(PREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "predicate" element
	 */
	@Override
	public void setPredicate(ar.com.fluxit.jqa.schema.ruleset.Predicate predicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().find_element_user(PREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().add_element_user(PREDICATE$0);
			}
			target.set(predicate);
		}
	}
}
