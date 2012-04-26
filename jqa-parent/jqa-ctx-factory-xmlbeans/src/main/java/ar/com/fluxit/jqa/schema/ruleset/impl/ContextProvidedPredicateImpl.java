/*
 * XML Type:  ContextProvidedPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * An XML
 * ContextProvidedPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 * 
 * This is a complex type.
 */
public class ContextProvidedPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements
		ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName PREDICATENAME$0 = new javax.xml.namespace.QName("", "predicateName");

	public ContextProvidedPredicateImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Gets the "predicateName" attribute
	 */
	@Override
	public java.lang.String getPredicateName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(PREDICATENAME$0);
			if (target == null) {
				return null;
			}
			return target.getStringValue();
		}
	}

	/**
	 * Sets the "predicateName" attribute
	 */
	@Override
	public void setPredicateName(java.lang.String predicateName) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(PREDICATENAME$0);
			if (target == null) {
				target = (org.apache.xmlbeans.SimpleValue) get_store().add_attribute_user(PREDICATENAME$0);
			}
			target.setStringValue(predicateName);
		}
	}

	/**
	 * Gets (as xml) the "predicateName" attribute
	 */
	@Override
	public org.apache.xmlbeans.XmlString xgetPredicateName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(PREDICATENAME$0);
			return target;
		}
	}

	/**
	 * Sets (as xml) the "predicateName" attribute
	 */
	@Override
	public void xsetPredicateName(org.apache.xmlbeans.XmlString predicateName) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(PREDICATENAME$0);
			if (target == null) {
				target = (org.apache.xmlbeans.XmlString) get_store().add_attribute_user(PREDICATENAME$0);
			}
			target.set(predicateName);
		}
	}
}
