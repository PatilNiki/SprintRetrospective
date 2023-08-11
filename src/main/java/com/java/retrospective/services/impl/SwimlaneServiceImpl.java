package com.java.retrospective.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dao.SwimlaneDao;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.dto.swimlane.SwimlaneInDto;
import com.java.retrospective.dto.swimlane.SwimlaneOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.mappers.SwimlaneMapper;
import com.java.retrospective.services.RetrospectiveService;
import com.java.retrospective.services.SwimlaneService;

import com.java.retrospective.validator.RetrospectiveValidator;
import com.java.retrospective.validator.SwimlaneValidator;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SwimlaneServiceImpl implements SwimlaneService {

    private final SwimlaneDao swimlaneDao;
    private final SwimlaneMapper swimlaneMapper;
    private final RetrospectiveService retrospectiveService;
    private final SwimlaneValidator swimlaneValidator;

    @Override
    public List<SwimlaneOutDto> getAllSwimlanes(Integer retro_id) {
        List<SwimlaneEntity> swimlaneEntities = swimlaneDao.findByRetrospectiveId(retro_id);
        return  swimlaneEntities==null? null:swimlaneEntities.stream().map(swimlaneMapper::mapEntityToOutDto).collect(Collectors.toList());
    }

    @Override
    public SwimlaneOutDto addSwimlane(Integer retro_id, SwimlaneInDto swimlane) {
        if(swimlaneValidator.validateForCreate(swimlane)) {
            RetrospectiveEntity retrospectiveEntity = retrospectiveService.getRetrospectiveEntity(retro_id);
            if (retrospectiveEntity != null) {
                SwimlaneEntity swimlaneEntity = swimlaneMapper.mapInDtoToEntity(swimlane);
                swimlaneEntity.setRetrospective(retrospectiveEntity);
                return swimlaneMapper.mapEntityToOutDto(swimlaneDao.save(swimlaneEntity));
            }
        }
        return null;
    }

    @Override
    public String deleteSwimlane(Integer retro_id, Integer id) {
        swimlaneDao.deleteById(id);
        return "Swimlane deleted!";
    }

    @Override
    public SwimlaneEntity getSwimlaneById(Integer id) {
        return swimlaneDao.findById(id).orElse(null);
    }

}
