package com.java.retrospective.dao;

import com.java.retrospective.entity.SwimlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwimlaneDao extends JpaRepository<SwimlaneEntity, Integer> {

    //write query to return retro data for id
    List<SwimlaneEntity> findByRetrospectiveId(Integer id);
}
