package com.java.retrospective.mappers;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserEntity mapDtoToEntity(UserDto userDto);
    UserDto mapEntityToDto(UserEntity userEntity);
}
