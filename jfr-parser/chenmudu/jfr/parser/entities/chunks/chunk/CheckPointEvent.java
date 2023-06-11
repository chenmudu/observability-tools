package jfr.parser.entities.chunks.chunk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckPointEvent {
    //
    private Long startTime;

    private Long duration;

    private Long delta;

    private Byte typeMask;
}
