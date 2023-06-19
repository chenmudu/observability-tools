package jfr.parser.entities.chunks.metadata;

public interface ITreeNodeElement {
    /**
     *
     * @param nodeName current node name.
     * @return Current Node.
     */
    ITreeNodeElement getChildNodeElementByNodeName(final String nodeName);


    /**
     *
     * @param propertyKey  Node property name.
     * @param propertyValue Node property value.
     * @return
     */
    ITreeNodeElement buildCurrentNodeElementBaseProperties(final String propertyKey, final String propertyValue);

}
