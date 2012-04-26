/*
 * An XML document type.
 * Localname: ContextProvidedPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * ContextProvidedPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset)
 * element.
 * 
 * This is a complex type.
 */
public class ContextProvidedPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName CONTEXTPROVIDEDPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"ContextProvidedPredicate");

	public ContextProvidedPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "ContextProvidedPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate addNewContextProvidedPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) get_store().add_element_user(CONTEXTPROVIDEDPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "ContextProvidedPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate getContextProvidedPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) get_store().find_element_user(CONTEXTPROVIDEDPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "ContextProvidedPredicate" element
	 */
	@Override
	public void setContextProvidedPredicate(ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate contextProvidedPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) get_store().find_element_user(CONTEXTPROVIDEDPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) get_store().add_element_user(CONTEXTPROVIDEDPREDICATE$0);
			}
			target.set(contextProvidedPredicate);
		}
	}
}
