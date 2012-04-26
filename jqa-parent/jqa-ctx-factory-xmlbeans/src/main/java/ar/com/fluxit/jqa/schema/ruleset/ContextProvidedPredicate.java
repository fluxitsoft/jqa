/*
 * XML Type:  ContextProvidedPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset;

/**
 * An XML
 * ContextProvidedPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 * 
 * This is a complex type.
 */
public interface ContextProvidedPredicate extends ar.com.fluxit.jqa.schema.ruleset.Predicate {
	/**
	 * A factory class with static methods for creating instances of this type.
	 */

	public static final class Factory {
		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate newInstance() {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate newInstance(org.apache.xmlbeans.XmlOptions options) {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, options);
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
		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.File file) throws org.apache.xmlbeans.XmlException,
				java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.File file, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException,
				java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException,
				java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, options);
		}

		/**
		 * @param xmlAsString
		 *            the string value to parse
		 */
		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type,
					null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type,
					options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.net.URL u) throws org.apache.xmlbeans.XmlException,
				java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(javax.xml.stream.XMLStreamReader sr)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(javax.xml.stream.XMLStreamReader sr,
				org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, options);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis)
				throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, null);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis,
				org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, options);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, null);
		}

		public static ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.ruleset.ContextProvidedPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, options);
		}

		private Factory() {
		} // No instance of this class allowed
	}

	public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType) org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(
			ContextProvidedPredicate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCF439B81031AD69462AD629128D21633").resolveHandle(
			"contextprovidedpredicate737btype");

	/**
	 * Gets the "predicateName" attribute
	 */
	java.lang.String getPredicateName();

	/**
	 * Sets the "predicateName" attribute
	 */
	void setPredicateName(java.lang.String predicateName);

	/**
	 * Gets (as xml) the "predicateName" attribute
	 */
	org.apache.xmlbeans.XmlString xgetPredicateName();

	/**
	 * Sets (as xml) the "predicateName" attribute
	 */
	void xsetPredicateName(org.apache.xmlbeans.XmlString predicateName);
}
