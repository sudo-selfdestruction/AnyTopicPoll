package by.bsu.rfict.AnyTopicPoll.service;

import by.bsu.rfict.AnyTopicPoll.entity.Role;
import by.bsu.rfict.AnyTopicPoll.entity.User;
import by.bsu.rfict.AnyTopicPoll.repository.RoleRepository;
import by.bsu.rfict.AnyTopicPoll.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(User user) {
        Role roleUser = roleRepository.findRoleByName("RESPONDENT");
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleUser);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRolesList(roleList);

        User registerdUser = userRepository.save(user);
        log.info("registerUser - user : {} successfully registered", registerdUser);

        return registerdUser;
    }

    public void deleteUser(User user) {
        if (user == null) {
            log.info("deleteUser - user doesn't exist");
        }

        userRepository.delete(user);
        log.info("deleteUser - user : {} successfully deleted", user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            log.info("deleteUser - user with id {} didn't find", userId);
        } else {
            userRepository.deleteById(userId);
            log.info("deleteUser - user with id {} successfully deleted", userId);
        }
    }

    public User findById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            log.info("findById - user with id {} didn't find", userId);
        }
        log.info("findById - user with id {} successfully found", userId);

        return user;
    }

    public User findByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        log.info("findAll - found {} users", userList.size());
        return userList;
    }

    public User getUserByLogin() {
        return userRepository.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}