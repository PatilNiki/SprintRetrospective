package com.java.retrospective.services;

import com.java.retrospective.entity.MessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {

    List<MessageEntity> getAllMessages();
    MessageEntity addMessage(MessageEntity messageEntity);
    String deleteMessage(Integer id);
    MessageEntity updateMessage(Integer id, String message);
}
