package by.bsu.rfict.AnyTopicPoll.controller;

import by.bsu.rfict.AnyTopicPoll.dto.PollDto;
import by.bsu.rfict.AnyTopicPoll.entity.Option;
import by.bsu.rfict.AnyTopicPoll.entity.ParticipationKeeper;
import by.bsu.rfict.AnyTopicPoll.entity.Poll;
import by.bsu.rfict.AnyTopicPoll.mapper.PollMapper;
import by.bsu.rfict.AnyTopicPoll.service.ParticipationKeeperService;
import by.bsu.rfict.AnyTopicPoll.service.PollService;
import by.bsu.rfict.AnyTopicPoll.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PollController {
    private final PollMapper pollMapper;
    private PollService pollService;
    private UserService userService;
    private ParticipationKeeperService participationKeeperService;

    @GetMapping("/polls")
    public List<PollDto> getPolls() {
        List<Poll> pollList = pollService.findAll();
        List<PollDto> pollDtoList = new ArrayList<>();
        for (Poll poll : pollList) {
            pollDtoList.add(pollMapper.toPollDto(poll));
        }
        return pollDtoList;
    }

    @PostMapping("/polls/create")
    public PollDto createPoll(@RequestBody PollDto pollDto) {
        Poll poll = pollMapper.toPoll(pollDto);
        return pollDto;
    }

    @PostMapping("/polls/{id}")
    public Poll participatePoll(@PathVariable Long id, @RequestBody Option optionDto) {
        Poll poll = pollService.findById(id);
        ParticipationKeeper participationKeeper;


        if(participationKeeperService.checkKeeper(userService.getUserByLogin().getId(), id) == Boolean.TRUE) {
            return null;
        }

        List<Option> optionList = poll.getOptionList();
        for (Option option : optionList) {
            if (option.getId().equals(optionDto.getId())) {
                option.setOptionVotedCounter(option.getOptionVotedCounter() + 1);
            }
        }
        poll.setVotedCounter(poll.getVotedCounter() + 1);
        pollService.updatePoll(poll);
        return poll;
    }

}
