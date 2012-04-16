
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" abstract="true" name="Predicate">
 *   &lt;xs:attribute type="xs:string" name="name"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public abstract class Predicate
{
    private String name;

    /** 
     * Get the 'name' attribute value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'name' attribute value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
