package com.java.retrospective.services.mapping.impl;

import com.java.retrospective.dao.UserDao;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.mapping.UserMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMappingServiceImpl implements UserMappingService {

    private UserDao userDao;

    public List<UserDto> getAllUsers(){
        return userDao.findAll().stream().map(this::convertDataIntoDto).collect(Collectors.toList());
    }

//    public UserDto addUser(String username, String password){
//        return userDao.save(new UserDto(username,password));
//    }

    private UserDto convertDataIntoDto(UserEntity user){
        UserDto userDto= new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
