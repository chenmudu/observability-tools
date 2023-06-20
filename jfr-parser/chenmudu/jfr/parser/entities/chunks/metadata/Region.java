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
public class Region extends BaseTreeNodeElement {
    /**
     * key: locale
     */
    private String locale;
    /**
     * key: gmtOffset
     */
    private String gmtOffset;

    /**
     * key: ticksToMillis
     */
    private String ticks2Millis;

    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        //empty implementation.
        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        if(StrUtil.isNotEmpty(propertyKey)) {
            if (StrUtil.equals(propertyKey, StringConstants.METADATA_TREE_NODE_PROPERTY_LOCALE)) {
                this.locale = propertyValue;
            } else if (StrUtil.equals(propertyKey, StringConstants.METADATA_TREE_NODE_PROPERTY_GMT_OFFSET)) {
                this.gmtOffset = propertyValue;
            } else if (StrUtil.equals(propertyKey, StringConstants.METADATA_TREE_NODE_PROPERTY_TICKS_TO_MILLIS)) {
                this.ticks2Millis = propertyValue;
            }
            return this;
        }
        return null;
    }
}
