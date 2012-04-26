/*
 * An XML document type.
 * Localname: FalsePredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.FalsePredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * FalsePredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class FalsePredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.FalsePredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName FALSEPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"FalsePredicate");

	public FalsePredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "FalsePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.FalsePredicate addNewFalsePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FalsePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FalsePredicate) get_store().add_element_user(FALSEPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "FalsePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.FalsePredicate getFalsePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FalsePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FalsePredicate) get_store().find_element_user(FALSEPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "FalsePredicate" element
	 */
	@Override
	public void setFalsePredicate(ar.com.fluxit.jqa.schema.ruleset.FalsePredicate falsePredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.FalsePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.FalsePredicate) get_store().find_element_user(FALSEPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.FalsePredicate) get_store().add_element_user(FALSEPREDICATE$0);
			}
			target.set(falsePredicate);
		}
	}
}
