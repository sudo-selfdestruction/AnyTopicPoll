package by.bsu.rfict.AnyTopicPoll.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionDto {
    private Long id;
    private String optionText;
    private Integer optionVotedCounter;
}
