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
public class MetadataEventMetadata extends BaseTreeNodeElement {
    /**
     * key: class
     */
    private List<ClassMetadata> classes;

    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        if(StrUtil.isNotEmpty(nodeName) && StrUtil.equals(nodeName, StringConstants.METADATA_TREE_NODE_CLASS)) {
            if (CollectionUtil.isEmpty(this.classes)) {
                this.classes = new ArrayList<>(10);
            }
            return this;
        }
        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        return null;
    }
}
