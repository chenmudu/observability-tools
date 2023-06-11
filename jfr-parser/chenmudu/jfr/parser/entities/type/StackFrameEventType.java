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
public class StackFrameEventType {

    private MethodEventType method;

    private Integer lineNumber;

    private Integer bytecodeIndex;

    private String type;

}
