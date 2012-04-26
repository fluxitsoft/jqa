/*
 * XML Type:  NamingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.NamingPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * An XML NamingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 * 
 * This is a complex type.
 */
public class NamingPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.NamingPredicate {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName NAMEPATTERN$0 = new javax.xml.namespace.QName("", "namePattern");

	public NamingPredicateImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Gets the "namePattern" attribute
	 */
	@Override
	public java.lang.String getNamePattern() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAMEPATTERN$0);
			if (target == null) {
				return null;
			}
			return target.getStringValue();
		}
	}

	/**
	 * Sets the "namePattern" attribute
	 */
	@Override
	public void setNamePattern(java.lang.String namePattern) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAMEPATTERN$0);
			if (target == null) {
				target = (org.apache.xmlbeans.SimpleValue) get_store().add_attribute_user(NAMEPATTERN$0);
			}
			target.setStringValue(namePattern);
		}
	}

	/**
	 * Gets (as xml) the "namePattern" attribute
	 */
	@Override
	public org.apache.xmlbeans.XmlString xgetNamePattern() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAMEPATTERN$0);
			return target;
		}
	}

	/**
	 * Sets (as xml) the "namePattern" attribute
	 */
	@Override
	public void xsetNamePattern(org.apache.xmlbeans.XmlString namePattern) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAMEPATTERN$0);
			if (target == null) {
				target = (org.apache.xmlbeans.XmlString) get_store().add_attribute_user(NAMEPATTERN$0);
			}
			target.set(namePattern);
		}
	}
}
