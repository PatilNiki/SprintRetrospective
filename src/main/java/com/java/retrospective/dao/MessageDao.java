package com.java.retrospective.dao;

import com.java.retrospective.entity.MessageEntity;
import com.java.retrospective.validator.MessageValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<MessageEntity, Integer> {

    MessageEntity findByRetrospective(Integer retrospective_id);

    MessageEntity findByUserId(Integer user_id);

    MessageEntity findByRetrospectiveAndSwimlane(Integer retrospective_id, Integer swimlane_id);



}
