/*
 * XML Type:  NotPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.NotPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML NotPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class NotPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.NotPredicate
{
    private static final long serialVersionUID = 1L;
    
    public NotPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PREDICATE$0 = 
        new javax.xml.namespace.QName("", "predicate");
    
    
    /**
     * Gets the "predicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate getPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(PREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "predicate" element
     */
    public void setPredicate(ar.com.fluxit.jqa.schema.ruleset.Predicate predicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(PREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(PREDICATE$0);
            }
            target.set(predicate);
        }
    }
    
    /**
     * Appends and returns a new empty "predicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(PREDICATE$0);
            return target;
        }
    }
}
