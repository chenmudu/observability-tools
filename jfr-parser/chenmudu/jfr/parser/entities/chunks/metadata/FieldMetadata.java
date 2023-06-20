package jfr.parser.entities.chunks.metadata;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import jfr.parser.constans.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMetadata extends BaseTreeNodeElement {
    /**
     * key: class
     */
    private Long classId;

    /**
     * key: name
     */
    private String name;

    /**
     * key: constantPool
     */
    private Boolean constantPool;

    /**
     * key: dimension
     */
    private Integer dimension;

    /**
     * key: annotation
     */
    private List<AnnotationMetadata> annotationMetadataLists;

    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        if (StrUtil.isNotEmpty(nodeName) && StrUtil.equals(StringConstants.METADATA_TREE_NODE_ANNOTATION, nodeName)) {
            if (CollectionUtil.isEmpty(annotationMetadataLists)) {
                this.annotationMetadataLists = new ArrayList<>(10);
            }
            return this;
        }
        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        if (StrUtil.isNotEmpty(propertyKey)) {
            if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_NAME, propertyKey)) {
                this.name = propertyValue;
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_CLASS, propertyKey)) {
                this.classId = Long.parseLong(propertyValue);
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_CONSTANT_POOL, propertyKey)) {
                this.constantPool = Boolean.parseBoolean(propertyValue);
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_DIMENSION, propertyKey)) {
                this.dimension = Integer.parseInt(propertyValue);
            }
            return this;
        }
        return null;
    }
}
