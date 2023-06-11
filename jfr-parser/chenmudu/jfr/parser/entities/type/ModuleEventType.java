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
public class ModuleEventType {

    private String name;

    private String version;

    private String location;

    private ClassLoaderEventType classLoader;

}
