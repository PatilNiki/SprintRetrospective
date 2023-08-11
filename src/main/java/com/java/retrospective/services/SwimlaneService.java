package com.java.retrospective.services;

import com.java.retrospective.dto.swimlane.SwimlaneInDto;
import com.java.retrospective.dto.swimlane.SwimlaneOutDto;
import com.java.retrospective.entity.SwimlaneEntity;

import java.util.List;

public interface SwimlaneService {
    List<SwimlaneOutDto> getAllSwimlanes(Integer retro_id);
    SwimlaneOutDto addSwimlane(Integer retro_id, SwimlaneInDto swimlane);
    String deleteSwimlane(Integer retro_id, Integer id);
    SwimlaneEntity getSwimlaneById(Integer id);

}
