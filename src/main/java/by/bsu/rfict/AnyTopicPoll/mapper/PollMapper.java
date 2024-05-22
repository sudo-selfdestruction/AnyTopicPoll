package by.bsu.rfict.AnyTopicPoll.mapper;

import by.bsu.rfict.AnyTopicPoll.dto.PollDto;
import by.bsu.rfict.AnyTopicPoll.entity.Poll;
import org.springframework.stereotype.Component;

@Component
public class PollMapper {

    public Poll toPoll(PollDto pollDto) {
        return Poll.builder().
                name(pollDto.getName()).
                description(pollDto.getDescription()).
                date(pollDto.getDate()).
                votedCounter(pollDto.getVotedCounter()).
                optionList(pollDto.getOptionList()).
                build();
    }

    public PollDto toPollDto(Poll poll) {
        return PollDto.builder().
                id(poll.getId()).
                name(poll.getName()).
                description(poll.getDescription()).
                date(poll.getDate()).
                votedCounter(poll.getVotedCounter()).
                optionList(poll.getOptionList()).
                build();
    }

}
