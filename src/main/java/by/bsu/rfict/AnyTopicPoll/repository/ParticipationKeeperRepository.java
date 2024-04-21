package by.bsu.rfict.AnyTopicPoll.repository;

import by.bsu.rfict.AnyTopicPoll.entity.ParticipationKeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationKeeperRepository extends JpaRepository<ParticipationKeeper, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM keeper WHERE poll_id = :pollId")
    List<ParticipationKeeper> getAllByPollId(Long pollId);
}
