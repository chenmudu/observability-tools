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
public class FieldMetadata {
    private Long classId;

    private Long name;

    private Boolean constantPool;

    /**
     * size?
     */
    private Integer dimension;

    private List<AnnotationMetadata> annotationMetadataLists;

}
