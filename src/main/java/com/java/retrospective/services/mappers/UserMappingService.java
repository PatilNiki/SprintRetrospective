package com.java.retrospective.services.mappers;

import com.java.retrospective.dto.user.UserDto;

import java.util.List;

public interface UserMappingService {
    List<UserDto> getAllUsers();

}
