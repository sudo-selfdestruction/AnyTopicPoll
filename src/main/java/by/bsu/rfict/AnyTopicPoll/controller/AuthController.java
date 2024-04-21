package by.bsu.rfict.AnyTopicPoll.controller;

import by.bsu.rfict.AnyTopicPoll.dto.LoginRequestDto;
import by.bsu.rfict.AnyTopicPoll.dto.UserDto;
import by.bsu.rfict.AnyTopicPoll.entity.User;
import by.bsu.rfict.AnyTopicPoll.mapper.UserMapper;
import by.bsu.rfict.AnyTopicPoll.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequestDto loginDto) {
        String username = loginDto.getUsername();
        User user = userService.findByUsername(username);
        log.info("login - user : {} successfully login", user);
        return user;
    }

    @PostMapping("/sign-up")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userService.registerUser(user);
        return userDto;
    }
}