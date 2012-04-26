/*
 * An XML document type.
 * Localname: TruePredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.TruePredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * TruePredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class TruePredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.TruePredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName TRUEPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"TruePredicate");

	public TruePredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "TruePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.TruePredicate addNewTruePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.TruePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.TruePredicate) get_store().add_element_user(TRUEPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "TruePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.TruePredicate getTruePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.TruePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.TruePredicate) get_store().find_element_user(TRUEPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "TruePredicate" element
	 */
	@Override
	public void setTruePredicate(ar.com.fluxit.jqa.schema.ruleset.TruePredicate truePredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.TruePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.TruePredicate) get_store().find_element_user(TRUEPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.TruePredicate) get_store().add_element_user(TRUEPREDICATE$0);
			}
			target.set(truePredicate);
		}
	}
}
