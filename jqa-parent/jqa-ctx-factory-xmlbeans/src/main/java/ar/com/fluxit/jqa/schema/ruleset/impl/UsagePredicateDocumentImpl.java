/*
 * An XML document type.
 * Localname: UsagePredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.UsagePredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * UsagePredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class UsagePredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.UsagePredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName USAGEPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"UsagePredicate");

	public UsagePredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "UsagePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.UsagePredicate addNewUsagePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.UsagePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.UsagePredicate) get_store().add_element_user(USAGEPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "UsagePredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.UsagePredicate getUsagePredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.UsagePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.UsagePredicate) get_store().find_element_user(USAGEPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "UsagePredicate" element
	 */
	@Override
	public void setUsagePredicate(ar.com.fluxit.jqa.schema.ruleset.UsagePredicate usagePredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.UsagePredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.UsagePredicate) get_store().find_element_user(USAGEPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.UsagePredicate) get_store().add_element_user(USAGEPREDICATE$0);
			}
			target.set(usagePredicate);
		}
	}
}
