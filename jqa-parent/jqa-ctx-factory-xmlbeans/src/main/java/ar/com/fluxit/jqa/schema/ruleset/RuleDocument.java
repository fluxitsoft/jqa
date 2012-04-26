/*
 * An XML document type.
 * Localname: Rule
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.RuleDocument
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset;

/**
 * A document containing one Rule(@http://www.fluxit.com.ar/jqa/schema/ruleset)
 * element.
 * 
 * This is a complex type.
 */
public interface RuleDocument extends org.apache.xmlbeans.XmlObject {
	/**
	 * A factory class with static methods for creating instances of this type.
	 */

	public static final class Factory {
		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument newInstance() {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, options);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis)
				throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xis, type, null);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis,
				org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xis, type, options);
		}

		/**
		 * @param file
		 *            the file from which to load an xml document
		 */
		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, options);
		}

		/**
		 * @param xmlAsString
		 *            the string value to parse
		 */
		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, options);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis)
				throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, null);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis,
				org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.RuleDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.RuleDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, options);
		}

		private Factory() {
		} // No instance of this class allowed
	}

	public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType) org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(
			RuleDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCF439B81031AD69462AD629128D21633").resolveHandle("rule2f62doctype");

	/**
	 * Appends and returns a new empty "Rule" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Rule addNewRule();

	/**
	 * Gets the "Rule" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Rule getRule();

	/**
	 * Sets the "Rule" element
	 */
	void setRule(ar.com.fluxit.jqa.schema.ruleset.Rule rule);
}
