/*
 * An XML document type.
 * Localname: ThrowingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one ThrowingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class ThrowingPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public ThrowingPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName THROWINGPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "ThrowingPredicate");
    
    
    /**
     * Gets the "ThrowingPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate getThrowingPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate)get_store().find_element_user(THROWINGPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ThrowingPredicate" element
     */
    public void setThrowingPredicate(ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate throwingPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate)get_store().find_element_user(THROWINGPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate)get_store().add_element_user(THROWINGPREDICATE$0);
            }
            target.set(throwingPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "ThrowingPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate addNewThrowingPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.ThrowingPredicate)get_store().add_element_user(THROWINGPREDICATE$0);
            return target;
        }
    }
}
