/*
 * XML Type:  RulesContext
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContext
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;
/**
 * An XML RulesContext(@http://www.fluxit.com.ar/jqa/schema/rulescontext).
 *
 * This is a complex type.
 */
public class RulesContextImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.rulescontext.RulesContext
{
    private static final long serialVersionUID = 1L;
    
    public RulesContextImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RULESETIMPORT$0 = 
        new javax.xml.namespace.QName("", "ruleSetImport");
    private static final javax.xml.namespace.QName GLOBALPREDICATE$2 = 
        new javax.xml.namespace.QName("", "globalPredicate");
    
    
    /**
     * Gets a List of "ruleSetImport" elements
     */
    public java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport> getRuleSetImportList()
    {
        final class RuleSetImportList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport>
        {
            public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport get(int i)
                { return RulesContextImpl.this.getRuleSetImportArray(i); }
            
            public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport set(int i, ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport o)
            {
                ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport old = RulesContextImpl.this.getRuleSetImportArray(i);
                RulesContextImpl.this.setRuleSetImportArray(i, o);
                return old;
            }
            
            public void add(int i, ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport o)
                { RulesContextImpl.this.insertNewRuleSetImport(i).set(o); }
            
            public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport remove(int i)
            {
                ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport old = RulesContextImpl.this.getRuleSetImportArray(i);
                RulesContextImpl.this.removeRuleSetImport(i);
                return old;
            }
            
            public int size()
                { return RulesContextImpl.this.sizeOfRuleSetImportArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new RuleSetImportList();
        }
    }
    
    /**
     * Gets array of all "ruleSetImport" elements
     * @deprecated
     */
    public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[] getRuleSetImportArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport>();
            get_store().find_all_element_users(RULESETIMPORT$0, targetList);
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[] result = new ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "ruleSetImport" element
     */
    public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport getRuleSetImportArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().find_element_user(RULESETIMPORT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "ruleSetImport" element
     */
    public int sizeOfRuleSetImportArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RULESETIMPORT$0);
        }
    }
    
    /**
     * Sets array of all "ruleSetImport" element
     */
    public void setRuleSetImportArray(ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[] ruleSetImportArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(ruleSetImportArray, RULESETIMPORT$0);
        }
    }
    
    /**
     * Sets ith "ruleSetImport" element
     */
    public void setRuleSetImportArray(int i, ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport ruleSetImport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().find_element_user(RULESETIMPORT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(ruleSetImport);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ruleSetImport" element
     */
    public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport insertNewRuleSetImport(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().insert_element_user(RULESETIMPORT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ruleSetImport" element
     */
    public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport addNewRuleSetImport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().add_element_user(RULESETIMPORT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ruleSetImport" element
     */
    public void removeRuleSetImport(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RULESETIMPORT$0, i);
        }
    }
    
    /**
     * Gets a List of "globalPredicate" elements
     */
    public java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> getGlobalPredicateList()
    {
        final class GlobalPredicateList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.ruleset.Predicate>
        {
            public ar.com.fluxit.jqa.schema.ruleset.Predicate get(int i)
                { return RulesContextImpl.this.getGlobalPredicateArray(i); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Predicate set(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o)
            {
                ar.com.fluxit.jqa.schema.ruleset.Predicate old = RulesContextImpl.this.getGlobalPredicateArray(i);
                RulesContextImpl.this.setGlobalPredicateArray(i, o);
                return old;
            }
            
            public void add(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o)
                { RulesContextImpl.this.insertNewGlobalPredicate(i).set(o); }
            
            public ar.com.fluxit.jqa.schema.ruleset.Predicate remove(int i)
            {
                ar.com.fluxit.jqa.schema.ruleset.Predicate old = RulesContextImpl.this.getGlobalPredicateArray(i);
                RulesContextImpl.this.removeGlobalPredicate(i);
                return old;
            }
            
            public int size()
                { return RulesContextImpl.this.sizeOfGlobalPredicateArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new GlobalPredicateList();
        }
    }
    
    /**
     * Gets array of all "globalPredicate" elements
     * @deprecated
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate[] getGlobalPredicateArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.ruleset.Predicate>();
            get_store().find_all_element_users(GLOBALPREDICATE$2, targetList);
            ar.com.fluxit.jqa.schema.ruleset.Predicate[] result = new ar.com.fluxit.jqa.schema.ruleset.Predicate[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "globalPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate getGlobalPredicateArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(GLOBALPREDICATE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "globalPredicate" element
     */
    public int sizeOfGlobalPredicateArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(GLOBALPREDICATE$2);
        }
    }
    
    /**
     * Sets array of all "globalPredicate" element
     */
    public void setGlobalPredicateArray(ar.com.fluxit.jqa.schema.ruleset.Predicate[] globalPredicateArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(globalPredicateArray, GLOBALPREDICATE$2);
        }
    }
    
    /**
     * Sets ith "globalPredicate" element
     */
    public void setGlobalPredicateArray(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().find_element_user(GLOBALPREDICATE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(globalPredicate);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "globalPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate insertNewGlobalPredicate(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().insert_element_user(GLOBALPREDICATE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "globalPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewGlobalPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.Predicate)get_store().add_element_user(GLOBALPREDICATE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "globalPredicate" element
     */
    public void removeGlobalPredicate(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(GLOBALPREDICATE$2, i);
        }
    }
}
