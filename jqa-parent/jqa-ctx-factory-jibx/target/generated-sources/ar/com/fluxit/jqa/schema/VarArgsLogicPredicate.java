
package ar.com.fluxit.jqa.schema;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" abstract="true" name="VarArgsLogicPredicate">
 *   &lt;xs:complexContent>
 *     &lt;xs:extension base="ns:Predicate">
 *       &lt;xs:sequence>
 *         &lt;xs:element type="ns:Predicate" name="predicate" maxOccurs="unbounded"/>
 *       &lt;/xs:sequence>
 *     &lt;/xs:extension>
 *   &lt;/xs:complexContent>
 * &lt;/xs:complexType>
 * </pre>
 */
public abstract class VarArgsLogicPredicate extends Predicate
{
    private List<Predicate> predicateList = new ArrayList<Predicate>();

    /** 
     * Get the list of 'predicate' element items.
     * 
     * @return list
     */
    public List<Predicate> getPredicateList() {
        return predicateList;
    }

    /** 
     * Set the list of 'predicate' element items.
     * 
     * @param list
     */
    public void setPredicateList(List<Predicate> list) {
        predicateList = list;
    }
}
