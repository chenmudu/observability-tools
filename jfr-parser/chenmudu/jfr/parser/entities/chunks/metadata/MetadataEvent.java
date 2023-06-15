package jfr.parser.entities.chunks.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;

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

    private Root root;


    public MetadataEvent parseMetadataEvent(ByteBuffer buffer) {

        return this;
    }
}
