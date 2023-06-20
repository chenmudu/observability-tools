package jfr.parser.entities.chunks.chunk;

import jfr.parser.leb128.Leb128CompressedByteBuffer;
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
public class CheckPointEvent {
    /**
     * type: Int32-C
     */
    private Integer size;

    /**
     * type: Int64-C
     */
    private Long eventType;
    //
    private Long startTime;

    private Long duration;

    private Long delta;

    private Byte typeMask;

    private Integer poolCount;

    // Maybe we can cache it? class id, constant count?


    public CheckPointEvent buildCheckPointEvent(final ByteBuffer buffer) {
        final Leb128CompressedByteBuffer bf = Leb128CompressedByteBuffer.getLeb128CompressedByteBuffer(buffer);
        this.size = bf.getVarInt();
        this.eventType = bf.getVarLong();
        this.startTime = bf.getVarLong();
        this.duration = bf.getVarLong();
        this.delta = bf.getVarLong();
        this.typeMask = bf.get();
        this.poolCount = bf.getVarInt();
        return this;
    }

}
