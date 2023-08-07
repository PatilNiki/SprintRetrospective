package com.java.retrospective.services;

import com.java.retrospective.dto.swimlane.SwimlaneDto;
import com.java.retrospective.entity.SwimlaneEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SwimlaneService {
    List<SwimlaneDto> getAllSwimlanes(Integer retro_id);
    SwimlaneDto addSwimlane(Integer retro_id, String swimlaneEntity);
    String deleteSwimlane(Integer retro_id, Integer id);

}
