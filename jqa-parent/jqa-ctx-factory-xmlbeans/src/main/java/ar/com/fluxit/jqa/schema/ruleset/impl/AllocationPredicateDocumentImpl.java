/*
 * An XML document type.
 * Localname: AllocationPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.AllocationPredicateDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * AllocationPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class AllocationPredicateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.ruleset.AllocationPredicateDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName ALLOCATIONPREDICATE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset",
			"AllocationPredicate");

	public AllocationPredicateDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "AllocationPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate addNewAllocationPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate) get_store().add_element_user(ALLOCATIONPREDICATE$0);
			return target;
		}
	}

	/**
	 * Gets the "AllocationPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate getAllocationPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate) get_store().find_element_user(ALLOCATIONPREDICATE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "AllocationPredicate" element
	 */
	@Override
	public void setAllocationPredicate(ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate allocationPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate) get_store().find_element_user(ALLOCATIONPREDICATE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.AllocationPredicate) get_store().add_element_user(ALLOCATIONPREDICATE$0);
			}
			target.set(allocationPredicate);
		}
	}
}
