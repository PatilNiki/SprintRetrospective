package com.java.retrospective.mappers;

import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface RetrospectiveMapper {
//    RetrospectiveMapper MAPPER = Mappers.getMapper(RetrospectiveMapper.class);
    RetrospectiveInDto mapEntityToInDto(RetrospectiveEntity retrospectiveEntity);
    RetrospectiveOutDto mapEntityToOutDto(RetrospectiveEntity retrospectiveEntity);

    RetrospectiveEntity mapOutDtoToEntity(RetrospectiveOutDto retrospectiveOutDto);
    RetrospectiveEntity mapInDtoToEntity(RetrospectiveInDto retrospectiveInDto);

}
