/*
 * XML Type:  RuleSetImport
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;
/**
 * An XML RuleSetImport(@http://www.fluxit.com.ar/jqa/schema/rulescontext).
 *
 * This is a complex type.
 */
public class RuleSetImportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport
{
    private static final long serialVersionUID = 1L;
    
    public RuleSetImportImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCE$0 = 
        new javax.xml.namespace.QName("", "resource");
    
    
    /**
     * Gets the "resource" attribute
     */
    public java.lang.String getResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCE$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "resource" attribute
     */
    public org.apache.xmlbeans.XmlString xgetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCE$0);
            return target;
        }
    }
    
    /**
     * True if has "resource" attribute
     */
    public boolean isSetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RESOURCE$0) != null;
        }
    }
    
    /**
     * Sets the "resource" attribute
     */
    public void setResource(java.lang.String resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RESOURCE$0);
            }
            target.setStringValue(resource);
        }
    }
    
    /**
     * Sets (as xml) the "resource" attribute
     */
    public void xsetResource(org.apache.xmlbeans.XmlString resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RESOURCE$0);
            }
            target.set(resource);
        }
    }
    
    /**
     * Unsets the "resource" attribute
     */
    public void unsetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RESOURCE$0);
        }
    }
}
