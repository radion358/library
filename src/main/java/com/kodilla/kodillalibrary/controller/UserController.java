package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.UserDto;
import com.kodilla.kodillalibrary.mapper.UserMapper;
import com.kodilla.kodillalibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return mapper.mapToUserDto(service.addUser(mapper.mapToUser(userDto)));
    }
}
