/*
 * XML Type:  AbstractionPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML AbstractionPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class AbstractionPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate
{
    private static final long serialVersionUID = 1L;
    
    public AbstractionPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTIONTYPE$0 = 
        new javax.xml.namespace.QName("", "abstractionType");
    
    
    /**
     * Gets the "abstractionType" attribute
     */
    public ar.com.fluxit.jqa.schema.ruleset.AbstractionType.Enum getAbstractionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ABSTRACTIONTYPE$0);
            if (target == null)
            {
                return null;
            }
            return (ar.com.fluxit.jqa.schema.ruleset.AbstractionType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "abstractionType" attribute
     */
    public ar.com.fluxit.jqa.schema.ruleset.AbstractionType xgetAbstractionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.AbstractionType target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionType)get_store().find_attribute_user(ABSTRACTIONTYPE$0);
            return target;
        }
    }
    
    /**
     * Sets the "abstractionType" attribute
     */
    public void setAbstractionType(ar.com.fluxit.jqa.schema.ruleset.AbstractionType.Enum abstractionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ABSTRACTIONTYPE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ABSTRACTIONTYPE$0);
            }
            target.setEnumValue(abstractionType);
        }
    }
    
    /**
     * Sets (as xml) the "abstractionType" attribute
     */
    public void xsetAbstractionType(ar.com.fluxit.jqa.schema.ruleset.AbstractionType abstractionType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.AbstractionType target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionType)get_store().find_attribute_user(ABSTRACTIONTYPE$0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionType)get_store().add_attribute_user(ABSTRACTIONTYPE$0);
            }
            target.set(abstractionType);
        }
    }
}
