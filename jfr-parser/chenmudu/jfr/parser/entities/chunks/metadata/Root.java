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
public class Root {

    private MetadataEventMetadata eventMetadata;

    private Region region;

}
