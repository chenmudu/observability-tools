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
public class MethodEventType {

    private ClassEventType type;

    private String name;

    private String descriptor;

    private Integer modifiers;

    private Boolean hidden;

}
