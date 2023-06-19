package jfr.parser.entities.chunks.metadata;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import jfr.parser.constans.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationMetadata implements ITreeNodeElement {

    /**
     * key: class
     */
    private Long classId;

    /**
     * key: value
     */
    private Map<String, String> annotationMetadata;

    @Override
    public ITreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        return null;
    }

    @Override
    public ITreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        if (StrUtil.isNotEmpty(propertyKey)) {
            if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_CLASS, propertyKey)) {
                this.classId = Long.parseLong(propertyValue);
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_VALUE, propertyKey)) {
                if (CollectionUtil.isEmpty(this.annotationMetadata)) {
                    this.annotationMetadata = new HashMap<>(10);
                }
                this.annotationMetadata.put(propertyKey, propertyValue);
            } else {
                return null;
            }
            return this;
        }
        return null;
    }
}
