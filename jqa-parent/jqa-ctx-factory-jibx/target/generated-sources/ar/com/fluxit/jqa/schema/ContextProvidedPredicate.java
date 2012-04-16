
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="ContextProvidedPredicate">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Predicate">
 *       &lt;xs:attribute type="xs:string" use="required" name="predicateName"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class ContextProvidedPredicate extends Predicate
{
    private String predicateName;

    /** 
     * Get the 'predicateName' attribute value.
     * 
     * @return value
     */
    public String getPredicateName() {
        return predicateName;
    }

    /** 
     * Set the 'predicateName' attribute value.
     * 
     * @param predicateName
     */
    public void setPredicateName(String predicateName) {
        this.predicateName = predicateName;
    }
}
