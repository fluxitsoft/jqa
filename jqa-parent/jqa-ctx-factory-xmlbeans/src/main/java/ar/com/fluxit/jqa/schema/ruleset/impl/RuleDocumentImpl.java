/*
 * An XML document type.
 * Localname: Rule
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.RuleDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one Rule(@http://www.fluxit.com.ar/jqa/schema/ruleset)
 * element.
 * 
 * This is a complex type.
 */
public class RuleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.RuleDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RULE$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "Rule");

	public RuleDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "Rule" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Rule addNewRule() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Rule) get_store().add_element_user(RULE$0);
			return target;
		}
	}

	/**
	 * Gets the "Rule" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Rule getRule() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Rule) get_store().find_element_user(RULE$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "Rule" element
	 */
	@Override
	public void setRule(ar.com.fluxit.jqa.schema.ruleset.Rule rule) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Rule target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Rule) get_store().find_element_user(RULE$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.Rule) get_store().add_element_user(RULE$0);
			}
			target.set(rule);
		}
	}
}
