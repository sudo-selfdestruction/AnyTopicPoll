package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Poll;
import by.bsu.rfict.AnyTopicPoll.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PollService {
    private final PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
        Poll createdPoll = pollRepository.save(poll);
        return createdPoll;
    }
}
