/*
 * An XML document type.
 * Localname: XORPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.XORPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * XORPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class XORPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.XORPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName XORPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "XORPredicate");

	public XORPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "XORPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.XORPredicate addNewXORPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.XORPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.XORPredicate) get_store().add_element_user(XORPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "XORPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.XORPredicate getXORPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.XORPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.XORPredicate) get_store().find_element_user(XORPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "XORPredicate" element
	 */
	@Override
	public void setXORPredicate(ar.com.fluxit.jqa.schema.ruleset.XORPredicate xorPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.XORPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.XORPredicate) get_store().find_element_user(XORPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.XORPredicate) get_store().add_element_user(XORPREDICATE$0);
			}
			target.set(xorPredicate);
		}
	}
}
