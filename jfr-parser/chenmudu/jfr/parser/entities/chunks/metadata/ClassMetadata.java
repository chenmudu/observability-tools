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
public class ClassMetadata {

    private Long id;

    private String name;

    private String superType;

    private Boolean simpleType;

    private List<FieldMetadata> fieldMetadataList;

    private List<SettingMetadata> settingMetadataList;

    private List<AnnotationMetadata> annotationMetadataList;

}
