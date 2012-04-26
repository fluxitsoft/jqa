/*
 * An XML document type.
 * Localname: NamingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.NamingPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * NamingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class NamingPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.NamingPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName NAMINGPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"NamingPredicate");

	public NamingPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "NamingPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.NamingPredicate addNewNamingPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.NamingPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) get_store().add_element_user(NAMINGPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "NamingPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.NamingPredicate getNamingPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.NamingPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) get_store().find_element_user(NAMINGPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "NamingPredicate" element
	 */
	@Override
	public void setNamingPredicate(ar.com.fluxit.jqa.schema.ruleset.NamingPredicate namingPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.NamingPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) get_store().find_element_user(NAMINGPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) get_store().add_element_user(NAMINGPREDICATE$0);
			}
			target.set(namingPredicate);
		}
	}
}
