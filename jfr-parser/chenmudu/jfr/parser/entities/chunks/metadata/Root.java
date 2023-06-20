package jfr.parser.entities.chunks.metadata;

import cn.hutool.core.util.StrUtil;
import jfr.parser.constans.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root extends BaseTreeNodeElement {
    /**
     * key: metadata.
     */
    private MetadataEventMetadata eventMetadata;

    private Region region;

    /**
     * key: region
     * @param nodeName current node name.
     * @return
     */
    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {

        if (StrUtil.isEmpty(nodeName)) {
            return null;
        }

        if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_METADATA, nodeName)) {
            this.eventMetadata = new MetadataEventMetadata();
            return this;
        } else if (StrUtil.equals(StringConstants.METADATA_TREE_NODE_REGION, nodeName)) {
            this.region = new Region();
            return this;
        }

        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        //empty implementation.
        return null;
    }
}
