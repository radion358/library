package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.UserDto;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserMapperTest {
    //Given
    private final User user;
    private final UserDto userDto;
    private final LocalDate date;
    private final UserMapper mapper;

    public UserMapperTest() {
        this.date = LocalDate.now();
        this.user = new User(1, "test name", "test surname", date);
        this.userDto = new UserDto(1, "test name", "test surname", date);
        this.mapper = new UserMapper();
    }

    @Test
    public void mapToUserDto() {
        //When
        UserDto testUserDto = mapper.mapToUserDto(user);

        //Then
        assertEquals(userDto, testUserDto);
    }

    @Test
    public void mapToUser() {
        //When
        User testUser = mapper.mapToUser(userDto);

        //Then
        assertEquals(user, testUser);
    }
}