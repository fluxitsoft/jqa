
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AbstractionType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="ABSTRACT"/>
 *     &lt;xs:enumeration value="INTERFACE"/>
 *     &lt;xs:enumeration value="CONCRETE"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum AbstractionType {
    ABSTRACT, INTERFACE, CONCRETE
}
