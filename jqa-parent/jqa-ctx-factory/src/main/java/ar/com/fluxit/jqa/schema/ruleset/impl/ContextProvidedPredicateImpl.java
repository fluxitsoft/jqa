/*
 * XML Type:  ContextProvidedPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML ContextProvidedPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class ContextProvidedPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate
{
    private static final long serialVersionUID = 1L;
    
    public ContextProvidedPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROVIDEDPREDICATENAME$0 = 
        new javax.xml.namespace.QName("", "providedPredicateName");
    
    
    /**
     * Gets the "providedPredicateName" attribute
     */
    public java.lang.String getProvidedPredicateName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROVIDEDPREDICATENAME$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "providedPredicateName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetProvidedPredicateName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROVIDEDPREDICATENAME$0);
            return target;
        }
    }
    
    /**
     * Sets the "providedPredicateName" attribute
     */
    public void setProvidedPredicateName(java.lang.String providedPredicateName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROVIDEDPREDICATENAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROVIDEDPREDICATENAME$0);
            }
            target.setStringValue(providedPredicateName);
        }
    }
    
    /**
     * Sets (as xml) the "providedPredicateName" attribute
     */
    public void xsetProvidedPredicateName(org.apache.xmlbeans.XmlString providedPredicateName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROVIDEDPREDICATENAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROVIDEDPREDICATENAME$0);
            }
            target.set(providedPredicateName);
        }
    }
}
