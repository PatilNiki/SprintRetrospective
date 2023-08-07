package com.java.retrospective.dao;

import com.java.retrospective.entity.SwimlaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimlaneDao extends JpaRepository<SwimlaneEntity, Integer> {
}
