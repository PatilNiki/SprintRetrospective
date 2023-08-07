package com.java.retrospective.mappers;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity mapDtoToEntity(UserDto userDto);
    UserDto mapEntityToDto(UserEntity userEntity);
}
