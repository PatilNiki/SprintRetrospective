package com.java.retrospective.services.impl;

import com.java.retrospective.dao.UserDao;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserEntity addUser(UserEntity user) {
        userDao.save(user);
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.findAll();
    }
}
