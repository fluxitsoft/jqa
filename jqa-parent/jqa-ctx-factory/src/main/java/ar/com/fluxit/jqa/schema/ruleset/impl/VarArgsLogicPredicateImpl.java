/*
 * XML Type:  VarArgsLogicPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * An XML VarArgsLogicPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public class VarArgsLogicPredicateImpl extends ar.com.fluxit.jqa.schema.ruleset.impl.PredicateImpl implements ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate
{
    private static final long serialVersionUID = 1L;
    
    public VarArgsLogicPredicateImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PREDICATE$0 = 
        new javax.xml.namespace.QName("", "predicate");
    
    
    /**
     * Gets a List of "predicate" elements
     */
    public java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> getPredicateList()
    {
        final class PredicateList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.ruleset.Predicate>
        {
            public ar.com.fluxit.jqa.schema.ruleset.Predicate get(int i)
                { return VarArgsLogicPredicateImpl.this.getPredicateArray(i); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Predicate set(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o)
            {
                ar.com.fluxit.jqa.schema.ruleset.Predicate old = VarArgsLogicPredicateImpl.this.getPredicateArray(i);
                VarArgsLogicPredicateImpl.this.setPredicateArray(i, o);
                return old;
            }
            
            public void add(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o)
                { VarArgsLogicPredicateImpl.this.insertNewPredicate(i).set(o); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Predicate remove(int i)
            {
                ar.com.fluxit.jqa.schema.ruleset.Predicate old = VarArgsLogicPredicateImpl.this.getPredicateArray(i);
                VarArgsLogicPredicateImpl.this.removePredicate(i);
                return old;
            }
            
            public int size()
                { return VarArgsLogicPredicateImpl.this.sizeOfPredicateArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new PredicateList();
        }
    }
    
    /**
     * Gets array of all "predicate" elements
     * @deprecated
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate[] getPredicateArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.ruleset.Predicate>();
            get_store().find_all_element_users(PREDICATE$0, targetList);
            ar.com.fluxit.jqa.schema.ruleset.Predicate[] result = new ar.com.fluxit.jqa.schema.ruleset.Predicate[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "predicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate getPredicateArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(PREDICATE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "predicate" element
     */
    public int sizeOfPredicateArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PREDICATE$0);
        }
    }
    
    /**
     * Sets array of all "predicate" element
     */
    public void setPredicateArray(ar.com.fluxit.jqa.schema.ruleset.Predicate[] predicateArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(predicateArray, PREDICATE$0);
        }
    }
    
    /**
     * Sets ith "predicate" element
     */
    public void setPredicateArray(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate predicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(PREDICATE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(predicate);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "predicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate insertNewPredicate(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().insert_element_user(PREDICATE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "predicate" element
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
    
    /**
     * Removes the ith "predicate" element
     */
    public void removePredicate(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PREDICATE$0, i);
        }
    }
}
