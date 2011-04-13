/*
 * XML Type:  Ruleset
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.Ruleset
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML Ruleset(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class RulesetImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.Ruleset
{
    private static final long serialVersionUID = 1L;
    
    public RulesetImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RULE$0 = 
        new javax.xml.namespace.QName("", "rule");
    private static final javax.xml.namespace.QName NAME$2 = 
        new javax.xml.namespace.QName("", "name");
    
    
    /**
     * Gets a List of "rule" elements
     */
    public java.util.List<ar.com.fluxit.jqa.schema.ruleset.Rule> getRuleList()
    {
        final class RuleList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.ruleset.Rule>
        {
            public ar.com.fluxit.jqa.schema.ruleset.Rule get(int i)
                { return RulesetImpl.this.getRuleArray(i); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Rule set(int i, ar.com.fluxit.jqa.schema.ruleset.Rule o)
            {
                ar.com.fluxit.jqa.schema.ruleset.Rule old = RulesetImpl.this.getRuleArray(i);
                RulesetImpl.this.setRuleArray(i, o);
                return old;
            }
            
            public void add(int i, ar.com.fluxit.jqa.schema.ruleset.Rule o)
                { RulesetImpl.this.insertNewRule(i).set(o); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Rule remove(int i)
            {
                ar.com.fluxit.jqa.schema.ruleset.Rule old = RulesetImpl.this.getRuleArray(i);
                RulesetImpl.this.removeRule(i);
                return old;
            }
            
            public int size()
                { return RulesetImpl.this.sizeOfRuleArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new RuleList();
        }
    }
    
    /**
     * Gets array of all "rule" elements
     * @deprecated
     */
    public ar.com.fluxit.jqa.schema.ruleset.Rule[] getRuleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ar.com.fluxit.jqa.schema.ruleset.Rule> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.ruleset.Rule>();
            get_store().find_all_element_users(RULE$0, targetList);
            ar.com.fluxit.jqa.schema.ruleset.Rule[] result = new ar.com.fluxit.jqa.schema.ruleset.Rule[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "rule" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Rule getRuleArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Rule)get_store().find_element_user(RULE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "rule" element
     */
    public int sizeOfRuleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RULE$0);
        }
    }
    
    /**
     * Sets array of all "rule" element
     */
    public void setRuleArray(ar.com.fluxit.jqa.schema.ruleset.Rule[] ruleArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(ruleArray, RULE$0);
        }
    }
    
    /**
     * Sets ith "rule" element
     */
    public void setRuleArray(int i, ar.com.fluxit.jqa.schema.ruleset.Rule rule)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Rule)get_store().find_element_user(RULE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(rule);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "rule" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Rule insertNewRule(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Rule)get_store().insert_element_user(RULE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "rule" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Rule addNewRule()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Rule)get_store().add_element_user(RULE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "rule" element
     */
    public void removeRule(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RULE$0, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
            return target;
        }
    }
    
    /**
     * True if has "name" attribute
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NAME$2) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" attribute
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NAME$2);
        }
    }
}
