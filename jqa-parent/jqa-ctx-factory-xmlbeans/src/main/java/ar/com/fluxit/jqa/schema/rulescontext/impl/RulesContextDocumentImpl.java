/*
 * An XML document type.
 * Localname: RulesContext
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;

/**
 * A document containing one
 * RulesContext(@http://www.fluxit.com.ar/jqa/schema/rulescontext) element.
 * 
 * This is a complex type.
 */
public class RulesContextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RULESCONTEXT$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/rulescontext",
			"RulesContext");

	public RulesContextDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "RulesContext" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContext addNewRulesContext() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) get_store().add_element_user(RULESCONTEXT$0);
			return target;
		}
	}

	/**
	 * Gets the "RulesContext" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContext getRulesContext() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) get_store().find_element_user(RULESCONTEXT$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "RulesContext" element
	 */
	@Override
	public void setRulesContext(ar.com.fluxit.jqa.schema.rulescontext.RulesContext rulesContext) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContext target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) get_store().find_element_user(RULESCONTEXT$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) get_store().add_element_user(RULESCONTEXT$0);
			}
			target.set(rulesContext);
		}
	}
}
