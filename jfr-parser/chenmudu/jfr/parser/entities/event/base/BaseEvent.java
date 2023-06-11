package jfr.parser.entities.event.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEvent {

    /**
     * All events hold this property.
     */
    private Long startTime;

}
