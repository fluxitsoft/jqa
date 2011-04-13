/*
 * XML Type:  FilteredPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML FilteredPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class FilteredPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.FilteredPredicate
{
    private static final long serialVersionUID = 1L;
    
    public FilteredPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FILTERPREDICATE$0 = 
        new javax.xml.namespace.QName("", "filterPredicate");
    
    
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
}
