/*
 * An XML document type.
 * Localname: NotPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.NotPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one NotPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class NotPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.NotPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public NotPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOTPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "NotPredicate");
    
    
    /**
     * Gets the "NotPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.NotPredicate getNotPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.NotPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.NotPredicate)get_store().find_element_user(NOTPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "NotPredicate" element
     */
    public void setNotPredicate(ar.com.fluxit.jqa.schema.ruleset.NotPredicate notPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.NotPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.NotPredicate)get_store().find_element_user(NOTPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.NotPredicate)get_store().add_element_user(NOTPREDICATE$0);
            }
            target.set(notPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "NotPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.NotPredicate addNewNotPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.NotPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.NotPredicate)get_store().add_element_user(NOTPREDICATE$0);
            return target;
        }
    }
}
