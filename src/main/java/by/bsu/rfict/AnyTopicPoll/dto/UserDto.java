package by.bsu.rfict.AnyTopicPoll.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int age;
    private String gender;
    private String country;
}
