package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    User addUser(User user)  {
        return repository.save(user);
    }
}
