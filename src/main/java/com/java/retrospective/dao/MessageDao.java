package com.java.retrospective.dao;

import com.java.retrospective.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<MessageEntity, Integer> {

}
