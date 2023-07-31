package com.user.service.service;

import com.user.service.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    UserDto findById(Long id);


    List<UserDto> findAll();

    String deleteById(long id);
}
