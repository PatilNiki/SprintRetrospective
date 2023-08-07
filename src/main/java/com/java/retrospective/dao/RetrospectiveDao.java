package com.java.retrospective.dao;

import com.java.retrospective.entity.RetrospectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrospectiveDao extends JpaRepository<RetrospectiveEntity, Integer> {
}
