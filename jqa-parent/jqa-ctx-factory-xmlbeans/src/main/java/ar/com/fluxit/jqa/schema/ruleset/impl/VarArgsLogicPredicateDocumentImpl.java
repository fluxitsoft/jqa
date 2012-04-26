/*
 * An XML document type.
 * Localname: VarArgsLogicPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one VarArgsLogicPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class VarArgsLogicPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public VarArgsLogicPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VARARGSLOGICPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "VarArgsLogicPredicate");
    
    
    /**
     * Gets the "VarArgsLogicPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate getVarArgsLogicPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate)get_store().find_element_user(VARARGSLOGICPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "VarArgsLogicPredicate" element
     */
    public void setVarArgsLogicPredicate(ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate varArgsLogicPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate)get_store().find_element_user(VARARGSLOGICPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate)get_store().add_element_user(VARARGSLOGICPREDICATE$0);
            }
            target.set(varArgsLogicPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "VarArgsLogicPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate addNewVarArgsLogicPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.VarArgsLogicPredicate)get_store().add_element_user(VARARGSLOGICPREDICATE$0);
            return target;
        }
    }
}
