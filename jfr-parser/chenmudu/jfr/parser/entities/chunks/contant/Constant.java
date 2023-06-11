package jfr.parser.entities.chunks.contant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Constant {

    private Long classId;

    private String field;

    private Long index;
}
