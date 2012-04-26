/*
 * An XML document type.
 * Localname: FilteredPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.FilteredPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * FilteredPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class FilteredPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.FilteredPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName FILTEREDPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"FilteredPredicate");

	public FilteredPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "FilteredPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate addNewFilteredPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate) get_store().add_element_user(FILTEREDPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "FilteredPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate getFilteredPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate) get_store().find_element_user(FILTEREDPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "FilteredPredicate" element
	 */
	@Override
	public void setFilteredPredicate(ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate filteredPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate) get_store().find_element_user(FILTEREDPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate) get_store().add_element_user(FILTEREDPREDICATE$0);
			}
			target.set(filteredPredicate);
		}
	}
}
