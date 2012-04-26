/*
 * An XML document type.
 * Localname: Predicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.PredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * Predicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class PredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.PredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName PREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "Predicate");

	public PredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "Predicate" element
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
	 * Gets the "Predicate" element
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
	 * Sets the "Predicate" element
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
