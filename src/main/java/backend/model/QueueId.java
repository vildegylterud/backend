package backend.model;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class QueueId implements Serializable {

    @Getter
    @Setter
    private Long subject_id;
    @Getter @Setter
    private Long user_id;
}
