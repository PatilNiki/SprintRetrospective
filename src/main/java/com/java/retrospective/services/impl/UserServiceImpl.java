package com.java.retrospective.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.retrospective.dao.UserDao;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.mappers.UserMapper;
import com.java.retrospective.services.UserService;

import com.java.retrospective.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    @Override
    public UserDto addUser(UserDto user) {
        if(userValidator.validateForCreate(user)) {
            return userMapper.mapEntityToDto(userDao.save(userMapper.mapDtoToEntity(user)));
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.findAll().stream().map(userMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    public Boolean checkIfAdmin(Integer id){
        Optional<UserEntity> optionalUserEntity = userDao.findById(id);
        if(optionalUserEntity.isPresent()){
            UserEntity user = optionalUserEntity.get();
            return user.getUsername().equals("Admin") && user.getPassword().equals("Admin");
        }
        else return false;
    }

}
