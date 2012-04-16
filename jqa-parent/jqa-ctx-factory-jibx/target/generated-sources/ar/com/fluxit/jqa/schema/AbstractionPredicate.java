
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AbstractionPredicate">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Predicate">
 *       &lt;xs:attribute type="ns:AbstractionType" use="required" name="abstractionType"/>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AbstractionPredicate extends Predicate
{
    private AbstractionType abstractionType;

    /** 
     * Get the 'abstractionType' attribute value.
     * 
     * @return value
     */
    public AbstractionType getAbstractionType() {
        return abstractionType;
    }

    /** 
     * Set the 'abstractionType' attribute value.
     * 
     * @param abstractionType
     */
    public void setAbstractionType(AbstractionType abstractionType) {
        this.abstractionType = abstractionType;
    }
}
