package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Role;
import by.bsu.rfict.AnyTopicPoll.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role getRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }
}
