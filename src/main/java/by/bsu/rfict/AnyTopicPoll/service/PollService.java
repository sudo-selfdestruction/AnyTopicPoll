package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Poll;
import by.bsu.rfict.AnyTopicPoll.repository.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final UserService userService;

    public Poll createPoll(Poll poll) {
        Poll createdPoll = pollRepository.save(poll);
        createdPoll.setUser(userService.getUserByLogin());
        return createdPoll;
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
