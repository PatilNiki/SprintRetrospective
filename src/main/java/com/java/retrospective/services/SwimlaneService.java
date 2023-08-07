package com.java.retrospective.services;

import com.java.retrospective.entity.SwimlaneEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SwimlaneService {
    List<SwimlaneEntity> getAllSwimlanes();
    String addSwimlane(SwimlaneEntity swimlaneEntity);
    String deleteSwimlane(Integer id);

}
