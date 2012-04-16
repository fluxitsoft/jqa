
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" abstract="true" name="FilteredPredicate">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Predicate">
 *       &lt;xs:sequence>
 *         &lt;xs:element type="ns:Predicate" name="predicate"/>
 *       &lt;/xs:sequence>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public abstract class FilteredPredicate extends Predicate
{
    private Predicate predicate1;

    /** 
     * Get the 'predicate' element value.
     * 
     * @return value
     */
    public Predicate getPredicate1() {
        return predicate1;
    }

    /** 
     * Set the 'predicate' element value.
     * 
     * @param predicate1
     */
    public void setPredicate1(Predicate predicate1) {
        this.predicate1 = predicate1;
    }
}
