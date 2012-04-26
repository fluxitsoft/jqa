/*
 * An XML document type.
 * Localname: OrPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.OrPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one OrPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class OrPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.OrPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "OrPredicate");
    
    
    /**
     * Gets the "OrPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.OrPredicate getOrPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.OrPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.OrPredicate)get_store().find_element_user(ORPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "OrPredicate" element
     */
    public void setOrPredicate(ar.com.fluxit.jqa.schema.ruleset.OrPredicate orPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.OrPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.OrPredicate)get_store().find_element_user(ORPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.OrPredicate)get_store().add_element_user(ORPREDICATE$0);
            }
            target.set(orPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "OrPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.OrPredicate addNewOrPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.OrPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.OrPredicate)get_store().add_element_user(ORPREDICATE$0);
            return target;
        }
    }
}
