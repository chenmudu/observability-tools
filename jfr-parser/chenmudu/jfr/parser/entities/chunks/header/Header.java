package jfr.parser.entities.chunks.header;

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
public class Header {

    private Integer headerSize = 60;

    private Byte magicCharF = 'F';

    private Byte majorCharL = 'L';

    private Byte majorCharR = 'R';

    private Byte majorNumber0 = 0;

    /**
     * It didn't seem to do much good.
     */
    private Short firstMajorVersion;

    /**
     * It didn't seem to do much good.
     */
    private Short secondMajorVersion;

    private Long chunkSize;

    private Long constantPoolOffset;

    private Long metadataOffset;

    private Long startTimeNanos;

    private Long durationNanos;

    private Long startTicks;

    private Long ticksPerSecond;
    /**
     * Compression flag.
     */
    private Integer features;

    public Header buildHeaderProperties(final ByteBuffer buffer) {
        final Leb128CompressedByteBuffer bf = Leb128CompressedByteBuffer.getLeb128CompressedByteBuffer(buffer);
        this.setChunkSize(bf.getLong());
        this.setConstantPoolOffset(bf.getLong());
        this.setMetadataOffset(bf.getLong());
        this.setStartTimeNanos(bf.getLong());
        this.setDurationNanos(bf.getLong());
        this.setStartTicks(bf.getLong());
        this.setTicksPerSecond(bf.getLong());
        this.setFeatures(bf.getInt());
        return this;
    }

}
