package com.java.retrospective.services.mapping;

import com.java.retrospective.dao.UserDao;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface UserMappingService {
    List<UserDto> getAllUsers();

}
