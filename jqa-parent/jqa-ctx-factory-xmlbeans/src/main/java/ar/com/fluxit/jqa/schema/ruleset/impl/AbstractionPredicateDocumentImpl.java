/*
 * An XML document type.
 * Localname: AbstractionPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one AbstractionPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class AbstractionPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public AbstractionPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTIONPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "AbstractionPredicate");
    
    
    /**
     * Gets the "AbstractionPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate getAbstractionPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate)get_store().find_element_user(ABSTRACTIONPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AbstractionPredicate" element
     */
    public void setAbstractionPredicate(ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate abstractionPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate)get_store().find_element_user(ABSTRACTIONPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate)get_store().add_element_user(ABSTRACTIONPREDICATE$0);
            }
            target.set(abstractionPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "AbstractionPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate addNewAbstractionPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.AbstractionPredicate)get_store().add_element_user(ABSTRACTIONPREDICATE$0);
            return target;
        }
    }
}
