/*
 * XML Type:  TypingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.TypingPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML TypingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class TypingPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.TypingPredicate
{
    private static final long serialVersionUID = 1L;
    
    public TypingPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PARENTCLASSNAME$0 = 
        new javax.xml.namespace.QName("", "parentClassName");
    
    
    /**
     * Gets the "parentClassName" attribute
     */
    public java.lang.String getParentClassName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PARENTCLASSNAME$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "parentClassName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetParentClassName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PARENTCLASSNAME$0);
            return target;
        }
    }
    
    /**
     * Sets the "parentClassName" attribute
     */
    public void setParentClassName(java.lang.String parentClassName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PARENTCLASSNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PARENTCLASSNAME$0);
            }
            target.setStringValue(parentClassName);
        }
    }
    
    /**
     * Sets (as xml) the "parentClassName" attribute
     */
    public void xsetParentClassName(org.apache.xmlbeans.XmlString parentClassName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PARENTCLASSNAME$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PARENTCLASSNAME$0);
            }
            target.set(parentClassName);
        }
    }
}
