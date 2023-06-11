package jfr.parser.entities.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassEventType {

    private ClassLoaderEventType classLoader;

    private String name;

    //note:package is keyword.
    private PackageEventType packages;

    private Integer modifiers;

    private Boolean hidden;
}
