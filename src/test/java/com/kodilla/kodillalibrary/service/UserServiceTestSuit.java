package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTestSuit {
    private UserRepository repository;
    private UserService service;

    public UserServiceTestSuit() {
        this.repository = mock(UserRepository.class);
        this.service = new UserService(repository);
    }

    @Test
    public void addUserTest() {
        //Given
        User user = new User(1, "test Name", "test surname", LocalDate.now());
        when(repository.save(user)).thenReturn(user);

        //When
        User testUser = service.addUser(user);

        //Then
        assertEquals(user, testUser);
    }

    @Test
    public void findUserByIdWithValidId() {
        //Given
        User user = new User(1, "test Name", "test surname", LocalDate.now());
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        //When
        User testUser = service.findUserById(1);

        //Then
        assertEquals(user, testUser);
    }

    @Test(expected = UserNotFoundException.class)
    public void findUserByIdWithoutValidId() {
        //Given
        User user = new User(1, "test Name", "test surname", LocalDate.now());
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        //When
        service.findUserById(2L);
    }
}
