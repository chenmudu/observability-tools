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
public class ThreadGroupEventType {

    private ThreadGroupEventType parent;
    
    private String name;
    
}
