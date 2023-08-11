package com.java.retrospective.mappers;

import com.java.retrospective.dto.swimlane.SwimlaneInDto;
import com.java.retrospective.dto.swimlane.SwimlaneOutDto;
import com.java.retrospective.entity.SwimlaneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface SwimlaneMapper {
//    SwimlaneMapper MAPPER= Mappers.getMapper(SwimlaneMapper.class);
    SwimlaneOutDto mapEntityToOutDto(SwimlaneEntity swimlaneEntity);
    SwimlaneOutDto mapEntityToInDto(SwimlaneEntity swimlaneEntity);

    SwimlaneEntity mapOutDtoToEntity(SwimlaneOutDto swimlaneOutDto);
    SwimlaneEntity mapInDtoToEntity(SwimlaneInDto swimlaneInDto);

}
