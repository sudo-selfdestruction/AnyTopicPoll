package by.bsu.rfict.AnyTopicPoll.dto;

import by.bsu.rfict.AnyTopicPoll.entity.Option;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private Integer votedCounter;
    private List<Option> optionList;
}
