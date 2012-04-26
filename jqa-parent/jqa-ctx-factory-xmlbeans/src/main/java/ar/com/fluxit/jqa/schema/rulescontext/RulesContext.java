/*
 * XML Type:  RulesContext
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContext
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext;

/**
 * An XML RulesContext(@http://www.fluxit.com.ar/jqa/schema/rulescontext).
 * 
 * This is a complex type.
 */
public interface RulesContext extends org.apache.xmlbeans.XmlObject {
	/**
	 * A factory class with static methods for creating instances of this type.
	 */

	public static final class Factory {
		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext newInstance() {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext newInstance(org.apache.xmlbeans.XmlOptions options) {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance(type, options);
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
		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.File file, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(file, type, options);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException,
				java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(is, type, options);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(r, type, options);
		}

		/**
		 * @param xmlAsString
		 *            the string value to parse
		 */
		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xmlAsString, type, options);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException, java.io.IOException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(u, type, options);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(sr, type, options);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis)
				throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, null);
		}

		/** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
		@Deprecated
		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis,
				org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(xis, type, options);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, null);
		}

		public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options)
				throws org.apache.xmlbeans.XmlException {
			return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse(node, type, options);
		}

		private Factory() {
		} // No instance of this class allowed
	}

	public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType) org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(
			RulesContext.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sCF439B81031AD69462AD629128D21633").resolveHandle("rulescontextfdb0type");

	/**
	 * Appends and returns a new empty value (as xml) as the last
	 * "globalPredicate" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Predicate addNewGlobalPredicate();

	/**
	 * Appends and returns a new empty value (as xml) as the last
	 * "rulesContextImport" element
	 */
	ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport addNewRulesContextImport();

	/**
	 * Appends and returns a new empty value (as xml) as the last "ruleSet"
	 * element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Ruleset addNewRuleSet();

	/**
	 * Gets array of all "globalPredicate" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	ar.com.fluxit.jqa.schema.ruleset.Predicate[] getGlobalPredicateArray();

	/**
	 * Gets ith "globalPredicate" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Predicate getGlobalPredicateArray(int i);

	/**
	 * Gets a List of "globalPredicate" elements
	 */
	java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> getGlobalPredicateList();

	/**
	 * Gets the "name" attribute
	 */
	java.lang.String getName();

	/**
	 * Gets array of all "rulesContextImport" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[] getRulesContextImportArray();

	/**
	 * Gets ith "rulesContextImport" element
	 */
	ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport getRulesContextImportArray(int i);

	/**
	 * Gets a List of "rulesContextImport" elements
	 */
	java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport> getRulesContextImportList();

	/**
	 * Gets array of all "ruleSet" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	ar.com.fluxit.jqa.schema.ruleset.Ruleset[] getRuleSetArray();

	/**
	 * Gets ith "ruleSet" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Ruleset getRuleSetArray(int i);

	/**
	 * Gets a List of "ruleSet" elements
	 */
	java.util.List<ar.com.fluxit.jqa.schema.ruleset.Ruleset> getRuleSetList();

	/**
	 * Inserts and returns a new empty value (as xml) as the ith
	 * "globalPredicate" element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Predicate insertNewGlobalPredicate(int i);

	/**
	 * Inserts and returns a new empty value (as xml) as the ith
	 * "rulesContextImport" element
	 */
	ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport insertNewRulesContextImport(int i);

	/**
	 * Inserts and returns a new empty value (as xml) as the ith "ruleSet"
	 * element
	 */
	ar.com.fluxit.jqa.schema.ruleset.Ruleset insertNewRuleSet(int i);

	/**
	 * True if has "name" attribute
	 */
	boolean isSetName();

	/**
	 * Removes the ith "globalPredicate" element
	 */
	void removeGlobalPredicate(int i);

	/**
	 * Removes the ith "rulesContextImport" element
	 */
	void removeRulesContextImport(int i);

	/**
	 * Removes the ith "ruleSet" element
	 */
	void removeRuleSet(int i);

	/**
	 * Sets array of all "globalPredicate" element
	 */
	void setGlobalPredicateArray(ar.com.fluxit.jqa.schema.ruleset.Predicate[] globalPredicateArray);

	/**
	 * Sets ith "globalPredicate" element
	 */
	void setGlobalPredicateArray(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate);

	/**
	 * Sets the "name" attribute
	 */
	void setName(java.lang.String name);

	/**
	 * Sets array of all "rulesContextImport" element
	 */
	void setRulesContextImportArray(ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[] rulesContextImportArray);

	/**
	 * Sets ith "rulesContextImport" element
	 */
	void setRulesContextImportArray(int i, ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport rulesContextImport);

	/**
	 * Sets array of all "ruleSet" element
	 */
	void setRuleSetArray(ar.com.fluxit.jqa.schema.ruleset.Ruleset[] ruleSetArray);

	/**
	 * Sets ith "ruleSet" element
	 */
	void setRuleSetArray(int i, ar.com.fluxit.jqa.schema.ruleset.Ruleset ruleSet);

	/**
	 * Returns number of "globalPredicate" element
	 */
	int sizeOfGlobalPredicateArray();

	/**
	 * Returns number of "rulesContextImport" element
	 */
	int sizeOfRulesContextImportArray();

	/**
	 * Returns number of "ruleSet" element
	 */
	int sizeOfRuleSetArray();

	/**
	 * Unsets the "name" attribute
	 */
	void unsetName();

	/**
	 * Gets (as xml) the "name" attribute
	 */
	org.apache.xmlbeans.XmlString xgetName();

	/**
	 * Sets (as xml) the "name" attribute
	 */
	void xsetName(org.apache.xmlbeans.XmlString name);
}
