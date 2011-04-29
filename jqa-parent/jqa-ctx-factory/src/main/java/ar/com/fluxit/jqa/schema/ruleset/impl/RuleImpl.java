/*
 * XML Type:  Rule
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.Rule
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML Rule(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class RuleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.Rule
{
    private static final long serialVersionUID = 1L;
    
    public RuleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILTERPREDICATE$0 = 
        new javax.xml.namespace.QName("", "filterPredicate");
    private static final javax.xml.namespace.QName CHECKPREDICATE$2 = 
        new javax.xml.namespace.QName("", "checkPredicate");
    private static final javax.xml.namespace.QName NAME$4 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName MESSAGE$6 = 
        new javax.xml.namespace.QName("", "message");
    private static final javax.xml.namespace.QName PRIORITY$8 = 
        new javax.xml.namespace.QName("", "priority");
    private static final javax.xml.namespace.QName BIDIRECTIONALCHECK$10 = 
        new javax.xml.namespace.QName("", "bidirectionalCheck");
    
    
    /**
     * Gets the "filterPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate getFilterPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(FILTERPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "filterPredicate" element
     */
    public void setFilterPredicate(ar.com.fluxit.jqa.schema.ruleset.Predicate filterPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(FILTERPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(FILTERPREDICATE$0);
            }
            target.set(filterPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "filterPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewFilterPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(FILTERPREDICATE$0);
            return target;
        }
    }
    
    /**
     * Gets the "checkPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate getCheckPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(CHECKPREDICATE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkPredicate" element
     */
    public void setCheckPredicate(ar.com.fluxit.jqa.schema.ruleset.Predicate checkPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(CHECKPREDICATE$2, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(CHECKPREDICATE$2);
            }
            target.set(checkPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "checkPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewCheckPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(CHECKPREDICATE$2);
            return target;
        }
    }
    
    /**
     * Gets the "name" attribute
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" attribute
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
            return target;
        }
    }
    
    /**
     * Sets the "name" attribute
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$4);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$4);
            }
            target.set(name);
        }
    }
    
    /**
     * Gets the "message" attribute
     */
    public java.lang.String getMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MESSAGE$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "message" attribute
     */
    public org.apache.xmlbeans.XmlString xgetMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MESSAGE$6);
            return target;
        }
    }
    
    /**
     * Sets the "message" attribute
     */
    public void setMessage(java.lang.String message)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MESSAGE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MESSAGE$6);
            }
            target.setStringValue(message);
        }
    }
    
    /**
     * Sets (as xml) the "message" attribute
     */
    public void xsetMessage(org.apache.xmlbeans.XmlString message)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MESSAGE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(MESSAGE$6);
            }
            target.set(message);
        }
    }
    
    /**
     * Gets the "priority" attribute
     */
    public int getPriority()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PRIORITY$8);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "priority" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetPriority()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PRIORITY$8);
            return target;
        }
    }
    
    /**
     * True if has "priority" attribute
     */
    public boolean isSetPriority()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PRIORITY$8) != null;
        }
    }
    
    /**
     * Sets the "priority" attribute
     */
    public void setPriority(int priority)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PRIORITY$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PRIORITY$8);
            }
            target.setIntValue(priority);
        }
    }
    
    /**
     * Sets (as xml) the "priority" attribute
     */
    public void xsetPriority(org.apache.xmlbeans.XmlInt priority)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(PRIORITY$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(PRIORITY$8);
            }
            target.set(priority);
        }
    }
    
    /**
     * Unsets the "priority" attribute
     */
    public void unsetPriority()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PRIORITY$8);
        }
    }
    
    /**
     * Gets the "bidirectionalCheck" attribute
     */
    public boolean getBidirectionalCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BIDIRECTIONALCHECK$10);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "bidirectionalCheck" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetBidirectionalCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(BIDIRECTIONALCHECK$10);
            return target;
        }
    }
    
    /**
     * True if has "bidirectionalCheck" attribute
     */
    public boolean isSetBidirectionalCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(BIDIRECTIONALCHECK$10) != null;
        }
    }
    
    /**
     * Sets the "bidirectionalCheck" attribute
     */
    public void setBidirectionalCheck(boolean bidirectionalCheck)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BIDIRECTIONALCHECK$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BIDIRECTIONALCHECK$10);
            }
            target.setBooleanValue(bidirectionalCheck);
        }
    }
    
    /**
     * Sets (as xml) the "bidirectionalCheck" attribute
     */
    public void xsetBidirectionalCheck(org.apache.xmlbeans.XmlBoolean bidirectionalCheck)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(BIDIRECTIONALCHECK$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(BIDIRECTIONALCHECK$10);
            }
            target.set(bidirectionalCheck);
        }
    }
    
    /**
     * Unsets the "bidirectionalCheck" attribute
     */
    public void unsetBidirectionalCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(BIDIRECTIONALCHECK$10);
        }
    }
}
