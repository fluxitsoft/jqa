
package ar.com.fluxit.jqa.schema;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Ruleset">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns:Rule" name="rule" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" use="required" name="name"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Ruleset
{
    private List<Rule> ruleList = new ArrayList<Rule>();
    private String name;

    /** 
     * Get the list of 'rule' element items.
     * 
     * @return list
     */
    public List<Rule> getRuleList() {
        return ruleList;
    }

    /** 
     * Set the list of 'rule' element items.
     * 
     * @param list
     */
    public void setRuleList(List<Rule> list) {
        ruleList = list;
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
}
