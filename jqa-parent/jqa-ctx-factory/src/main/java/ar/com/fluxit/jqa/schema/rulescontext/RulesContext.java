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
public interface RulesContext extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RulesContext.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9E7197F7A4F9B8D98C8E628E8149BE56").resolveHandle("rulescontextfdb0type");
    
    /**
     * Gets a List of "ruleSetImport" elements
     */
    java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport> getRuleSetImportList();
    
    /**
     * Gets array of all "ruleSetImport" elements
     * @deprecated
     */
    ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[] getRuleSetImportArray();
    
    /**
     * Gets ith "ruleSetImport" element
     */
    ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport getRuleSetImportArray(int i);
    
    /**
     * Returns number of "ruleSetImport" element
     */
    int sizeOfRuleSetImportArray();
    
    /**
     * Sets array of all "ruleSetImport" element
     */
    void setRuleSetImportArray(ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport[] ruleSetImportArray);
    
    /**
     * Sets ith "ruleSetImport" element
     */
    void setRuleSetImportArray(int i, ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport ruleSetImport);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ruleSetImport" element
     */
    ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport insertNewRuleSetImport(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ruleSetImport" element
     */
    ar.com.fluxit.jqa.schema.rulescontext.RuleSetImport addNewRuleSetImport();
    
    /**
     * Removes the ith "ruleSetImport" element
     */
    void removeRuleSetImport(int i);
    
    /**
     * Gets a List of "globalPredicate" elements
     */
    java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> getGlobalPredicateList();
    
    /**
     * Gets array of all "globalPredicate" elements
     * @deprecated
     */
    ar.com.fluxit.jqa.schema.ruleset.Predicate[] getGlobalPredicateArray();
    
    /**
     * Gets ith "globalPredicate" element
     */
    ar.com.fluxit.jqa.schema.ruleset.Predicate getGlobalPredicateArray(int i);
    
    /**
     * Returns number of "globalPredicate" element
     */
    int sizeOfGlobalPredicateArray();
    
    /**
     * Sets array of all "globalPredicate" element
     */
    void setGlobalPredicateArray(ar.com.fluxit.jqa.schema.ruleset.Predicate[] globalPredicateArray);
    
    /**
     * Sets ith "globalPredicate" element
     */
    void setGlobalPredicateArray(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "globalPredicate" element
     */
    ar.com.fluxit.jqa.schema.ruleset.Predicate insertNewGlobalPredicate(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "globalPredicate" element
     */
    ar.com.fluxit.jqa.schema.ruleset.Predicate addNewGlobalPredicate();
    
    /**
     * Removes the ith "globalPredicate" element
     */
    void removeGlobalPredicate(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext newInstance() {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ar.com.fluxit.jqa.schema.rulescontext.RulesContext parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ar.com.fluxit.jqa.schema.rulescontext.RulesContext) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
