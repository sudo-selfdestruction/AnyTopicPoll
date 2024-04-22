package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Option;
import by.bsu.rfict.AnyTopicPoll.entity.Poll;
import by.bsu.rfict.AnyTopicPoll.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PollService {
    @Autowired
    private final PollRepository pollRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final OptionService optionService;

    public Poll createPoll(Poll poll) {
        poll.setUser(userService.getUserByLogin());
        List<Option> optionList = poll.getOptionList();
        poll.setOptionList(null);
        pollRepository.save(poll);
        for (Option option : optionList) {
            option.setPoll(poll);
            optionService.createOption(option);
        }
        return poll;
    }

    public List<Poll> findAll() {
        List<Poll> pollList = pollRepository.findAll();
        return pollList;
    }

    public Poll findById(Long id) {
        return pollRepository.findById(id).orElse(null);
    }

    public Poll updatePoll(Poll poll) {
        return pollRepository.save(poll);
    }
}
