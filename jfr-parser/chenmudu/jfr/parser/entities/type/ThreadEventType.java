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
public class ThreadEventType {

    private String osName;

    private String osThreadId;

    private String javaName;

    private Long javaThreadThreadId;

    private ThreadGroupEventType group;

}
