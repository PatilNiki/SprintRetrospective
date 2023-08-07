package com.java.retrospective.services;

import com.java.retrospective.entity.RetrospectiveEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RetrospectiveService {
    List<RetrospectiveEntity> getAllRetrospectives();
    String addRetrospective(RetrospectiveEntity retrospectiveEntity);
    String getRetrospective(Integer id);
    String deleteRetrospective(Integer id);
    String updateRetrospective(Integer id, RetrospectiveEntity retrospective);

}
