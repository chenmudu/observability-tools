package jfr.parser.entities.chunks.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataEvent {

    private Long startTime;

    private Long duration;

    private Long id;

    private Root root;
}
