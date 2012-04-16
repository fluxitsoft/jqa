
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Rule">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Predicate" name="filterPredicate"/>
 *     &lt;xs:element type="ns:Predicate" name="checkPredicate"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" use="required" name="name"/>
 *   &lt;xs:attribute type="xs:string" use="required" name="message"/>
 *   &lt;xs:attribute type="xs:int" name="priority"/>
 *   &lt;xs:attribute type="xs:boolean" name="bidirectionalCheck"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Rule
{
    private Predicate filterPredicate;
    private Predicate checkPredicate;
    private String name;
    private String message;
    private Integer priority;
    private Boolean bidirectionalCheck;

    /** 
     * Get the 'filterPredicate' element value.
     * 
     * @return value
     */
    public Predicate getFilterPredicate() {
        return filterPredicate;
    }

    /** 
     * Set the 'filterPredicate' element value.
     * 
     * @param filterPredicate
     */
    public void setFilterPredicate(Predicate filterPredicate) {
        this.filterPredicate = filterPredicate;
    }

    /** 
     * Get the 'checkPredicate' element value.
     * 
     * @return value
     */
    public Predicate getCheckPredicate() {
        return checkPredicate;
    }

    /** 
     * Set the 'checkPredicate' element value.
     * 
     * @param checkPredicate
     */
    public void setCheckPredicate(Predicate checkPredicate) {
        this.checkPredicate = checkPredicate;
    }

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

    /** 
     * Get the 'message' attribute value.
     * 
     * @return value
     */
    public String getMessage() {
        return message;
    }

    /** 
     * Set the 'message' attribute value.
     * 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /** 
     * Get the 'priority' attribute value.
     * 
     * @return value
     */
    public Integer getPriority() {
        return priority;
    }

    /** 
     * Set the 'priority' attribute value.
     * 
     * @param priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /** 
     * Get the 'bidirectionalCheck' attribute value.
     * 
     * @return value
     */
    public Boolean getBidirectionalCheck() {
        return bidirectionalCheck;
    }

    /** 
     * Set the 'bidirectionalCheck' attribute value.
     * 
     * @param bidirectionalCheck
     */
    public void setBidirectionalCheck(Boolean bidirectionalCheck) {
        this.bidirectionalCheck = bidirectionalCheck;
    }
}
