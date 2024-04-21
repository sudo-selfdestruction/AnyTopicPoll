package by.bsu.rfict.AnyTopicPoll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "poll_option")
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "option_text")
    private String optionText;

    @Column(name = "option_voted_counter")
    private Integer optionVotedCounter;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "option_user",
            joinColumns = @JoinColumn(name = "option_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList;

    public Option() {}
}
