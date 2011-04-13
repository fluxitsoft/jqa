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
public class NamingPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.NamingPredicate
{
    private static final long serialVersionUID = 1L;
    
    public NamingPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CLASSNAMEPATTERN$0 = 
        new javax.xml.namespace.QName("", "classNamePattern");
    
    
    /**
     * Gets the "classNamePattern" attribute
     */
    public java.lang.String getClassNamePattern()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CLASSNAMEPATTERN$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "classNamePattern" attribute
     */
    public org.apache.xmlbeans.XmlString xgetClassNamePattern()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CLASSNAMEPATTERN$0);
            return target;
        }
    }
    
    /**
     * Sets the "classNamePattern" attribute
     */
    public void setClassNamePattern(java.lang.String classNamePattern)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CLASSNAMEPATTERN$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CLASSNAMEPATTERN$0);
            }
            target.setStringValue(classNamePattern);
        }
    }
    
    /**
     * Sets (as xml) the "classNamePattern" attribute
     */
    public void xsetClassNamePattern(org.apache.xmlbeans.XmlString classNamePattern)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CLASSNAMEPATTERN$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CLASSNAMEPATTERN$0);
            }
            target.set(classNamePattern);
        }
    }
}
