package com.home.demo.service;

import com.home.demo.dto.UserDto;

import java.util.List;
import java.util.stream.IntStream;

public interface UserService {
    void addUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    void deleteUserById(Long id);
}