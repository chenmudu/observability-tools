package jfr.parser.entities.chunks.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataEventMetadata {

    private List<ClassMetadata> classes;

}
