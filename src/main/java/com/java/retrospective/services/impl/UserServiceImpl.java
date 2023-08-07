package com.java.retrospective.services.impl;

import com.java.retrospective.dao.UserDao;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@AllArgsConstructor
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;
    @Override
    public UserDto addUser(UserDto user) {
        return convertDataIntoDto(userDao.save(convertDataIntoEntity(user)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.findAll().stream().map(this::convertDataIntoDto).collect(Collectors.toList());
    }

    private UserDto convertDataIntoDto(UserEntity user){
        UserDto userDto= new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private UserEntity convertDataIntoEntity(UserDto user){
        UserEntity userEntity= new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
