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

    public static Integer headerSize = 60;

    public static Byte magicCharF = 'F';

    public static Byte majorCharL = 'L';

    public static Byte majorCharR = 'R';

    public static Byte majorNumber0 = 0;

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
