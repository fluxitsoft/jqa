/*
 * An XML document type.
 * Localname: RulesContextImport
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContextImportDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;

/**
 * A document containing one
 * RulesContextImport(@http://www.fluxit.com.ar/jqa/schema/rulescontext)
 * element.
 * 
 * This is a complex type.
 */
public class RulesContextImportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements
		ar.com.fluxit.jqa.schema.rulescontext.RulesContextImportDocument {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RULESCONTEXTIMPORT$0 = new javax.xml.namespace.QName("http://www.fluxit.com.ar/jqa/schema/rulescontext",
			"RulesContextImport");

	public RulesContextImportDocumentImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty "RulesContextImport" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport addNewRulesContextImport() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().add_element_user(RULESCONTEXTIMPORT$0);
			return target;
		}
	}

	/**
	 * Gets the "RulesContextImport" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport getRulesContextImport() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().find_element_user(RULESCONTEXTIMPORT$0, 0);
			if (target == null) {
				return null;
			}
			return target;
		}
	}

	/**
	 * Sets the "RulesContextImport" element
	 */
	@Override
	public void setRulesContextImport(ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport rulesContextImport) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().find_element_user(RULESCONTEXTIMPORT$0, 0);
			if (target == null) {
				target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().add_element_user(RULESCONTEXTIMPORT$0);
			}
			target.set(rulesContextImport);
		}
	}
}
