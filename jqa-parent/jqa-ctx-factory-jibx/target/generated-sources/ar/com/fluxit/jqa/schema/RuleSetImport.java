
package ar.com.fluxit.jqa.schema;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://www.fluxit.com.ar/jqa/schema/rulescontext" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="RuleSetImport">
 *   &lt;xs:attribute type="xs:string" name="name"/>
 *   &lt;xs:attribute type="xs:string" name="fileName"/>
 * &lt;/xs:complexType>
 * </pre>
 */
public class RuleSetImport
{
    private String name;
    private String fileName;

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
     * Get the 'fileName' attribute value.
     * 
     * @return value
     */
    public String getFileName() {
        return fileName;
    }

    /** 
     * Set the 'fileName' attribute value.
     * 
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
