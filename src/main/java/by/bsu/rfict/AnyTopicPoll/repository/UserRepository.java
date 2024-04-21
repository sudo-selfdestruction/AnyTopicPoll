package by.bsu.rfict.AnyTopicPoll.repository;

import by.bsu.rfict.AnyTopicPoll.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE username = :login")
    User getUserByLogin(String login);
}
