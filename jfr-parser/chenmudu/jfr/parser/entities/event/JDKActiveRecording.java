package jfr.parser.entities.event;

import jfr.parser.entities.event.base.BaseEvent;
import jfr.parser.entities.type.StackTraceEventType;
import jfr.parser.entities.type.ThreadEventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JDKActiveRecording extends BaseEvent {

    private Long duration;

    //Thread in which event was committed in
    private ThreadEventType eventThread;

    //Stack Trace starting from the method the event was committed in
    private StackTraceEventType stackTrace;

    private Long id;

    private String name;

    private String destination;

    private Long maxAge;

    private Long flushInterval;

    private Long maxSize;

    private Long recordingStart;

    private Long recordingDuration;

}
