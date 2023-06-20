package jfr.parser.entities.chunks.metadata;

import cn.hutool.core.util.StrUtil;
import jfr.parser.leb128.Leb128CompressedByteBuffer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataEvent {
    //
    private Integer size;

    /**
     * when eventType != 0 unexpected metadata event.
     */
    private Long eventType;

    private Long start;

    private Long duration;

    private Long metaDataId;

    private Integer stringCount;

    private Root root;

    public MetadataEvent buildMetadataEventProperties(final ByteBuffer buffer) {
        final Leb128CompressedByteBuffer bf = Leb128CompressedByteBuffer.getLeb128CompressedByteBuffer(buffer);
        this.size = bf.getVarInt();
        this.eventType = bf.getVarLong();
        this.start = bf.getVarLong();
        this.duration = bf.getVarLong();
        this.metaDataId = bf.getVarLong();
        this.stringCount = bf.getVarInt();
        //set root.
        final List<String> rootStr = new ArrayList<>(this.getStringCount());
        for(int i = 0; i < this.getStringCount(); i++) {
            rootStr.add(bf.getString());
        }
        parseName(rootStr, bf);
        this.root = (Root) buildTreeNode(rootStr, bf, new Root());
        return this;
    }

    private BaseTreeNodeElement buildTreeNode(final List<String> rootStr, final Leb128CompressedByteBuffer bf, BaseTreeNodeElement nodeElement){
        //parse node properties
        final int proCount = bf.getVarInt();
        for (int i = 0; i < proCount; i++) {
            final String propertyKey = parseName(rootStr, bf);
            final String propertyVal = parseName(rootStr, bf);
            if (StrUtil.isEmpty(propertyKey) || StrUtil.isEmpty(propertyVal)) {
                return null;
            }
            nodeElement = nodeElement.buildCurrentNodeElementBaseProperties(propertyKey, propertyVal);
        }

        final int childCount = bf.getVarInt();
        for (int i = 0; i < childCount; i++) {
            final String propertyKey = parseName(rootStr, bf);
            BaseTreeNodeElement childNode = nodeElement.getChildNodeElementByNodeName(propertyKey);
            if (Objects.nonNull(childNode)) {
                nodeElement = buildTreeNode(rootStr, bf, childNode);
            }
        }
        return nodeElement;
    }

    String parseName(final List<String> rootStr, final Leb128CompressedByteBuffer bf) {
        final int point = bf.getVarInt();
        if (point < rootStr.size()) {
            return rootStr.get(point);
        }
        return null;
    }
}
