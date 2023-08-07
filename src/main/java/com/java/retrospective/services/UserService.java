package com.java.retrospective.services;

import com.java.retrospective.entity.UserEntity;
import java.util.List;
import org.springframework.stereotype.Service;


public interface UserService {

    UserEntity addUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
