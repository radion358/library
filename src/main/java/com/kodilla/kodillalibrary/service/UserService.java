package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.exception.UserNotFoundException;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User addUser(User user)  {
        user.setUserSignUpDate(new Date());
        return repository.save(user);
    }
    public User findUserById(long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
