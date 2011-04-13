/*
 * An XML document type.
 * Localname: RuleSetImport
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RuleSetImportDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;
/**
 * A document containing one RuleSetImport(@http://www.fluxit.com.ar/jqa/schema/rulescontext) element.
 *
 * This is a complex type.
 */
public class RuleSetImportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.rulescontext.RuleSetImportDocument
{
    private static final long serialVersionUID = 1L;
    
    public RuleSetImportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RULESETIMPORT$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/rulescontext", "RuleSetImport");
    
    
    /**
     * Gets the "RuleSetImport" element
     */
    public ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport getRuleSetImport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().find_element_user(RULESETIMPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "RuleSetImport" element
     */
    public void setRuleSetImport(ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport ruleSetImport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport target = null;
            target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().find_element_user(RULESETIMPORT$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport)get_store().add_element_user(RULESETIMPORT$0);
            }
            target.set(ruleSetImport);
        }
    }
    
    /**
     * Appends and returns a new empty "RuleSetImport" element
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
}
