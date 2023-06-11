package jfr.parser.entities.chunks;

import jfr.parser.entities.chunks.chunk.CheckPointEvent;
import jfr.parser.entities.chunks.events.Event;
import jfr.parser.entities.chunks.header.Header;
import jfr.parser.entities.chunks.metadata.MetadataEvent;
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
public class Chunk {
    private Header header;

    private MetadataEvent metadataEvent;

    private List<CheckPointEvent> checkPointEvents;

    private List<Event> events;

}
