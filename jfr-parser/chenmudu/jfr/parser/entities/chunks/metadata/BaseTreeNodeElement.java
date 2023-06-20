package jfr.parser.entities.chunks.metadata;

public abstract class BaseTreeNodeElement {
    /**
     *
     * @param nodeName current node name.
     * @return Current Node.
     */
    public abstract BaseTreeNodeElement getChildNodeElementByNodeName(final String nodeName);


    /**
     *
     * @param propertyKey  Node property name.
     * @param propertyValue Node property value.
     * @return
     */
    public abstract BaseTreeNodeElement buildCurrentNodeElementBaseProperties(final String propertyKey, final String propertyValue);

}
