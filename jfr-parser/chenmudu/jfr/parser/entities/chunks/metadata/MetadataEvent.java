package jfr.parser.entities.chunks.metadata;

import jfr.parser.leb128.Leb128CompressedByteBuffer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

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

    private static MetadataEvent buildEmptyMetadataEvent() {
        return new MetadataEvent();
    }

    public static MetadataEvent buildMetadataEventProperties(ByteBuffer buffer) {
        final MetadataEvent event = buildEmptyMetadataEvent();
        Leb128CompressedByteBuffer bf = Leb128CompressedByteBuffer.getLeb128CompressedByteBuffer(buffer);
        event.setSize(bf.getVarInt());
        event.setEventType(bf.getVarLong());
        event.setStart(bf.getVarLong());
        event.setDuration(bf.getVarLong());
        event.setMetaDataId(bf.getVarLong());
        event.setStringCount(bf.getVarInt());
        //set root.
        final List<String> strs = new ArrayList<>(event.getStringCount());
        for(int i = 0; i < event.getStringCount(); i++) {
            strs.add(bf.getString());
        }

        //parse names;

        //parse elements;

        return event;
    }

    private Root getRootData() {
        Root root = new Root();
        return root;
    }

}
