package by.bsu.rfict.AnyTopicPoll.service;


import by.bsu.rfict.AnyTopicPoll.entity.User;
import by.bsu.rfict.AnyTopicPoll.entity.Role;
import by.bsu.rfict.AnyTopicPoll.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String[] roleNames = user.getUserRolesList().stream().map(Role::getName).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword())
                .roles(roleNames).build();
    }

}