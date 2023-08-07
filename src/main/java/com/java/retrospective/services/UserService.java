package com.java.retrospective.services;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UserService {

    UserDto addUser(UserDto user);
    List<UserDto> getAllUsers();
}
