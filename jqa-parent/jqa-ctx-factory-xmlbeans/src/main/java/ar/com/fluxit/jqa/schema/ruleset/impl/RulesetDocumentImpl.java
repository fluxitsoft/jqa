/*
 * An XML document type.
 * Localname: Ruleset
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.RulesetDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset.impl;

/**
 * A document containing one
 * Ruleset(@http://www.fluxit.com.ar/jqa/schema/ruleset) element.
 * 
 * This is a complex type.
 */
public class RulesetDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.ruleset.RulesetDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RULESET$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/ruleset", "Ruleset");

	public RulesetDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "Ruleset" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset addNewRuleset() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().add_element_user(RULESET$0);
			return target;
		}
	}

	/**
	 * Gets the "Ruleset" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset getRuleset() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().find_element_user(RULESET$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "Ruleset" element
	 */
	@Override
	public void setRuleset(ar.com.fluxit.jqa.schema.ruleset.Ruleset ruleset) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().find_element_user(RULESET$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().add_element_user(RULESET$0);
			}
			target.set(ruleset);
		}
	}
}
