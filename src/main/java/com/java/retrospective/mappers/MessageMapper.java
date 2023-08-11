package com.java.retrospective.mappers;

import com.java.retrospective.dto.message.MessageInDto;
import com.java.retrospective.dto.message.MessageOutDto;
import com.java.retrospective.entity.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

//    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);

    MessageEntity mapInDtoToEntity(MessageInDto messageInDto);
    MessageEntity mapOutDtoToEntity(MessageOutDto messageOutDto);
    MessageInDto mapEntityToInDto(MessageEntity messageEntity);
    MessageOutDto mapEntityToOutDto(MessageEntity messageEntity);
}
