/*
 * XML Type:  RulesContextImport
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;

/**
 * An XML RulesContextImport(@http://www.fluxit.com.ar/jqa/schema/rulescontext).
 * 
 * This is a complex type.
 */
public class RulesContextImportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RESOURCE$0 = new javax.xml.namespace.QName("", "resource");

	public RulesContextImportImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Gets the "resource" attribute
	 */
	@Override
	public java.lang.String getResource() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(RESOURCE$0);
			if (target == null) {
				return null;
			}
			return target.getStringValue();
		}
	}

	/**
	 * True if has "resource" attribute
	 */
	@Override
	public boolean isSetResource() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().find_attribute_user(RESOURCE$0) != null;
		}
	}

	/**
	 * Sets the "resource" attribute
	 */
	@Override
	public void setResource(java.lang.String resource) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(RESOURCE$0);
			if (target == null) {
				target = (org.apache.xmlbeans.SimpleValue) get_store().add_attribute_user(RESOURCE$0);
			}
			target.setStringValue(resource);
		}
	}

	/**
	 * Unsets the "resource" attribute
	 */
	@Override
	public void unsetResource() {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_attribute(RESOURCE$0);
		}
	}

	/**
	 * Gets (as xml) the "resource" attribute
	 */
	@Override
	public org.apache.xmlbeans.XmlString xgetResource() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(RESOURCE$0);
			return target;
		}
	}

	/**
	 * Sets (as xml) the "resource" attribute
	 */
	@Override
	public void xsetResource(org.apache.xmlbeans.XmlString resource) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(RESOURCE$0);
			if (target == null) {
				target = (org.apache.xmlbeans.XmlString) get_store().add_attribute_user(RESOURCE$0);
			}
			target.set(resource);
		}
	}
}
