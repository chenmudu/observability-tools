package jfr.parser.entities.chunks.header;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Short firstMajorVersion;

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

    public Header buildHeaderByByteArray(byte[] arrays) {
        //
        return this;
    }
}
