/*
 * An XML document type.
 * Localname: TypingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.TypingPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;
/**
 * A document containing one TypingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 *
 * This is a complex type.
 */
public class TypingPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.TypingPredicateDocument
{
    private static final long serialVersionUID = 1L;
    
    public TypingPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TYPINGPREDICATE$0 = 
        new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "TypingPredicate");
    
    
    /**
     * Gets the "TypingPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.TypingPredicate getTypingPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.TypingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.TypingPredicate)get_store().find_element_user(TYPINGPREDICATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "TypingPredicate" element
     */
    public void setTypingPredicate(ar.com.fluxit.jqa.schema.ruleset.TypingPredicate typingPredicate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.TypingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.TypingPredicate)get_store().find_element_user(TYPINGPREDICATE$0, 0);
            if (target == null)
            {
                target = (ar.com.fluxit.jqa.schema.ruleset.TypingPredicate)get_store().add_element_user(TYPINGPREDICATE$0);
            }
            target.set(typingPredicate);
        }
    }
    
    /**
     * Appends and returns a new empty "TypingPredicate" element
     */
    public ar.com.fluxit.jqa.schema.ruleset.TypingPredicate addNewTypingPredicate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ar.com.fluxit.jqa.schema.ruleset.TypingPredicate target = null;
            target = (ar.com.fluxit.jqa.schema.ruleset.TypingPredicate)get_store().add_element_user(TYPINGPREDICATE$0);
            return target;
        }
    }
}
