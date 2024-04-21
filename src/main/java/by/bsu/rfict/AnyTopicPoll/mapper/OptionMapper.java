package by.bsu.rfict.AnyTopicPoll.mapper;

import by.bsu.rfict.AnyTopicPoll.dto.OptionDto;
import by.bsu.rfict.AnyTopicPoll.entity.Option;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {

    public Option toOption(OptionDto optionDto) {
        return Option.builder().
                optionText(optionDto.getOptionText()).
                optionVotedCounter(optionDto.getOptionVotedCounter()).
                build();
    }

    public OptionDto toOptionDto(Option option) {
        return OptionDto.builder().
                optionText(option.getOptionText()).
                optionVotedCounter(option.getOptionVotedCounter()).
                build();
    }
}
