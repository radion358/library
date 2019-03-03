package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUserSignUpDate());
    }

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getUserSignUpDate());
    }
}
