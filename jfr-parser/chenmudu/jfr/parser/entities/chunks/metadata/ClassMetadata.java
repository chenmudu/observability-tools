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
public class ClassMetadata extends BaseTreeNodeElement {

    /**
     * key: id
     */
    private Long id;

    /**
     * key: name
     */
    private String name;

    /**
     * key: superType
     */
    private String superType;

    /**
     * key: simpleType
     */
    private Boolean simpleType;

    /**
     * key: field
     */
    private List<FieldMetadata> fieldMetadataList;

    /**
     * key: setting
     */
    private List<SettingMetadata> settingMetadataList;

    /**
     * key: annotation
     */
    private List<AnnotationMetadata> annotationMetadataList;

    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        if (StrUtil.isNotEmpty(nodeName)) {
            if (StrUtil.equals(nodeName, StringConstants.METADATA_TREE_NODE_FIELD)) {
                if (CollectionUtil.isEmpty(this.fieldMetadataList)) {
                    this.fieldMetadataList = new ArrayList<>(10);
                }
            } else if (StrUtil.equals(nodeName, StringConstants.METADATA_TREE_NODE_SETTING)) {
                if (CollectionUtil.isEmpty(this.settingMetadataList)) {
                    this.settingMetadataList = new ArrayList<>(10);
                }
            } else if (StrUtil.equals(nodeName, StringConstants.METADATA_TREE_NODE_ANNOTATION)) {
                if (CollectionUtil.isEmpty(this.annotationMetadataList)) {
                    this.annotationMetadataList = new ArrayList<>(10);
                }
            } else {
                return null;
            }
            return this;
        }
        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        if (StrUtil.isNotEmpty(propertyKey)) {
            if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_ID, propertyKey)) {
                this.id = Long.parseUnsignedLong(propertyValue);
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_NAME, propertyKey)){
                this.name = propertyValue;
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_SUPER_TYPE, propertyKey)) {
                this.superType = propertyValue;
            } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_SIMPLE_TYPE, propertyKey)) {
                this.simpleType = Boolean.parseBoolean(propertyValue);
            } else {
                return null;
            }
            return this;
        }
        return null;
    }
}
