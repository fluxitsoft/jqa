/*
 * XML Type:  NamingPredicate
 * Namespace: http://www.fluxit.com.ar/jqa/schema/ruleset
 * Java type: ar.com.fluxit.jqa.schema.ruleset.NamingPredicate
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.ruleset;


/**
 * An XML NamingPredicate(@http://www.fluxit.com.ar/jqa/schema/ruleset).
 *
 * This is a complex type.
 */
public interface NamingPredicate extends ar.com.fluxit.jqa.schema.ruleset.Predicate
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NamingPredicate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sA27342670DA8F7949A5E3F708A63BE79").resolveHandle("namingpredicate3b33type");
    
    /**
     * Gets the "classNamePattern" attribute
     */
    java.lang.String getClassNamePattern();
    
    /**
     * Gets (as xml) the "classNamePattern" attribute
     */
    org.apache.xmlbeans.XmlString xgetClassNamePattern();
    
    /**
     * Sets the "classNamePattern" attribute
     */
    void setClassNamePattern(java.lang.String classNamePattern);
    
    /**
     * Sets (as xml) the "classNamePattern" attribute
     */
    void xsetClassNamePattern(org.apache.xmlbeans.XmlString classNamePattern);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate newInstance() {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ar.com.fluxit.jqa.schema.ruleset.NamingPredicate parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ar.com.fluxit.jqa.schema.ruleset.NamingPredicate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
