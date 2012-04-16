
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="NamingPredicate">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Predicate">
 *       &lt;xs:attribute type="xs:string" use="required" name="namePattern"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class NamingPredicate extends Predicate
{
    private String namePattern;

    /** 
     * Get the 'namePattern' attribute value.
     * 
     * @return value
     */
    public String getNamePattern() {
        return namePattern;
    }

    /** 
     * Set the 'namePattern' attribute value.
     * 
     * @param namePattern
     */
    public void setNamePattern(String namePattern) {
        this.namePattern = namePattern;
    }
}
