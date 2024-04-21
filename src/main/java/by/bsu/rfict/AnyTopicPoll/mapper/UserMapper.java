package by.bsu.rfict.AnyTopicPoll.mapper;

import by.bsu.rfict.AnyTopicPoll.dto.UserDto;
import by.bsu.rfict.AnyTopicPoll.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDto userDto) {
        return User.builder().
                username(userDto.getUsername()).
                password(userDto.getPassword()).
                firstName(userDto.getFirstName()).
                lastName(userDto.getLastName()).
                birthDate(userDto.getBirthDate()).
                age(userDto.getAge()).
                gender(userDto.getGender()).
                country(userDto.getCountry()).
                build();
    }
}
