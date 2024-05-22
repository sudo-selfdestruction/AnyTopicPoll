package by.bsu.rfict.AnyTopicPoll.repository;

import by.bsu.rfict.AnyTopicPoll.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String roleName);
    Role findRoleById(Long id);
}
