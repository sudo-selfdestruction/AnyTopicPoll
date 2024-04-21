package by.bsu.rfict.AnyTopicPoll.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "keeper")
@Data
@AllArgsConstructor
public class ParticipationKeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "poll_id")
    private Long pollId;

    @Column(name = "user_id")
    private Long userId;

    public ParticipationKeeper() {}
}
