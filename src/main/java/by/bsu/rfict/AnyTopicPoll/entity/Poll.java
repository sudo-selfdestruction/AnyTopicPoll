package by.bsu.rfict.AnyTopicPoll.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "poll")
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

    @Column(name = "option_amount")
    private Integer optionAmount;

    @Column(name = "votedCounter")
    private Integer votedCounter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="poll", cascade = CascadeType.ALL)
    private List<Option> optionList;
}
