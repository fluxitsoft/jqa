/*
 * XML Type:  Predicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.Predicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * An XML Predicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 * 
 * This is a complex type.
 */
public class PredicateImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.Predicate {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName NAME$0 = new javax.xml.namespace.QName("", "name");

	public PredicateImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Gets the "name" attribute
	 */
	@Override
	public java.lang.String getName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAME$0);
			if (target == null) {
				return null;
			}
			return target.getStringValue();
		}
	}

	/**
	 * True if has "name" attribute
	 */
	@Override
	public boolean isSetName() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().find_attribute_user(NAME$0) != null;
		}
	}

	/**
	 * Sets the "name" attribute
	 */
	@Override
	public void setName(java.lang.String name) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAME$0);
			if (target == null) {
				target = (org.apache.xmlbeans.SimpleValue) get_store().add_attribute_user(NAME$0);
			}
			target.setStringValue(name);
		}
	}

	/**
	 * Unsets the "name" attribute
	 */
	@Override
	public void unsetName() {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_attribute(NAME$0);
		}
	}

	/**
	 * Gets (as xml) the "name" attribute
	 */
	@Override
	public org.apache.xmlbeans.XmlString xgetName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAME$0);
			return target;
		}
	}

	/**
	 * Sets (as xml) the "name" attribute
	 */
	@Override
	public void xsetName(org.apache.xmlbeans.XmlString name) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAME$0);
			if (target == null) {
				target = (org.apache.xmlbeans.XmlString) get_store().add_attribute_user(NAME$0);
			}
			target.set(name);
		}
	}
}
