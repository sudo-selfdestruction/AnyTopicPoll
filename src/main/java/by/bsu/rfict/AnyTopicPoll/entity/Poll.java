package by.bsu.rfict.AnyTopicPoll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "poll")
@AllArgsConstructor
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "votedCounter")
    private Integer votedCounter;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="poll", cascade = CascadeType.ALL)
    private List<Option> optionList;

    public Poll() {}
}
