package com.java.retrospective.services.impl;

import com.java.retrospective.dao.SwimlaneDao;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.services.SwimlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class SwimlaneServiceImpl implements SwimlaneService {
    @Autowired
    private SwimlaneDao swimlaneDao;

    @Override
    public List<SwimlaneEntity> getAllSwimlanes() {
        return swimlaneDao.findAll();
    }

    @Override
    public String addSwimlane(SwimlaneEntity swimlaneEntity) {
        return swimlaneDao.save(swimlaneEntity).toString();
    }

    @Override
    public String deleteSwimlane(Integer id) {
        swimlaneDao.deleteById(id);
        return "Swimlane deleted!";
    }
}
