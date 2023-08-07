package com.java.retrospective.services.impl;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.services.RetrospectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrospectiveServiceImpl implements RetrospectiveService {
    @Autowired
    RetrospectiveDao retrospectiveDao;

    @Override
    public List<RetrospectiveEntity> getAllRetrospectives() {
        return retrospectiveDao.findAll();
    }

    @Override
    public String addRetrospective(RetrospectiveEntity retrospectiveEntity) {
        return retrospectiveDao.save(retrospectiveEntity).toString();
    }

    @Override
    public String getRetrospective(Integer id) {
        return retrospectiveDao.findById(id).toString();
    }

    @Override
    public String deleteRetrospective(Integer id) {
        retrospectiveDao.deleteById(id);
        return "Retrospective deleted!";
    }

    @Override
    public String updateRetrospective(Integer id, RetrospectiveEntity retrospective) {
        if(retrospectiveDao.findById(id)!=null){
            return retrospectiveDao.save(retrospective).toString();
        }
        return null;
    }
}
