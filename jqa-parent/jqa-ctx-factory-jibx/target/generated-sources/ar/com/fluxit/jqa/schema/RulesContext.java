
package ar.com.fluxit.jqa.schema;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/ruleset" xmlns:ns1="http://www.fluxit.com.ar/jqa/schema/rulescontext" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RulesContext">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="ns1:RulesContextImport" name="rulesContextImport" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns1:RuleSetImport" name="ruleSetImport" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:Predicate" name="globalPredicate" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:Ruleset" name="ruleSet" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 *   &lt;xs:attribute type="xs:string" name="name"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class RulesContext
{
    private List<RulesContextImport> rulesContextImportList = new ArrayList<RulesContextImport>();
    private List<RuleSetImport> ruleSetImportList = new ArrayList<RuleSetImport>();
    private List<Predicate> globalPredicateList = new ArrayList<Predicate>();
    private List<Ruleset> ruleSetList = new ArrayList<Ruleset>();
    private String name;

    /** 
     * Get the list of 'rulesContextImport' element items.
     * 
     * @return list
     */
    public List<RulesContextImport> getRulesContextImportList() {
        return rulesContextImportList;
    }

    /** 
     * Set the list of 'rulesContextImport' element items.
     * 
     * @param list
     */
    public void setRulesContextImportList(List<RulesContextImport> list) {
        rulesContextImportList = list;
    }

    /** 
     * Get the list of 'ruleSetImport' element items.
     * 
     * @return list
     */
    public List<RuleSetImport> getRuleSetImportList() {
        return ruleSetImportList;
    }

    /** 
     * Set the list of 'ruleSetImport' element items.
     * 
     * @param list
     */
    public void setRuleSetImportList(List<RuleSetImport> list) {
        ruleSetImportList = list;
    }

    /** 
     * Get the list of 'globalPredicate' element items.
     * 
     * @return list
     */
    public List<Predicate> getGlobalPredicateList() {
        return globalPredicateList;
    }

    /** 
     * Set the list of 'globalPredicate' element items.
     * 
     * @param list
     */
    public void setGlobalPredicateList(List<Predicate> list) {
        globalPredicateList = list;
    }

    /** 
     * Get the list of 'ruleSet' element items.
     * 
     * @return list
     */
    public List<Ruleset> getRuleSetList() {
        return ruleSetList;
    }

    /** 
     * Set the list of 'ruleSet' element items.
     * 
     * @param list
     */
    public void setRuleSetList(List<Ruleset> list) {
        ruleSetList = list;
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
