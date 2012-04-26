/*
 * An XML document type.
 * Localname: AndPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.AndPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * AndPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class AndPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.AndPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName ANDPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "AndPredicate");

	public AndPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "AndPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.AndPredicate addNewAndPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AndPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AndPredicate) get_store().add_element_user(ANDPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "AndPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.AndPredicate getAndPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AndPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AndPredicate) get_store().find_element_user(ANDPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "AndPredicate" element
	 */
	@Override
	public void setAndPredicate(ar.com.fluxit.jqa.schema.ruleset.AndPredicate andPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AndPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AndPredicate) get_store().find_element_user(ANDPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.AndPredicate) get_store().add_element_user(ANDPREDICATE$0);
			}
			target.set(andPredicate);
		}
	}
}
