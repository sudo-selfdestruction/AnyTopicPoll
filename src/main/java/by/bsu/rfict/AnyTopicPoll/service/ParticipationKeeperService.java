package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.ParticipationKeeper;
import by.bsu.rfict.AnyTopicPoll.repository.ParticipationKeeperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ParticipationKeeperService {
    private UserService userService;
    private final ParticipationKeeperRepository participationKeeperRepository;

    public ParticipationKeeper createKeeper(ParticipationKeeper participationKeeper) {
        participationKeeperRepository.save(participationKeeper);
        return participationKeeper;
    }

    public Boolean checkKeeper(Long userId, Long pollId) {
        List<ParticipationKeeper> participationKeeperList = participationKeeperRepository.getAllByPollId(pollId);
        for (ParticipationKeeper participationKeeper : participationKeeperList) {
            if (Objects.equals(participationKeeper.getUserId(), userService.getUserByLogin().getId())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
