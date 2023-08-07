package com.java.retrospective.services;

import com.java.retrospective.dto.message.MessageDto;
import com.java.retrospective.entity.MessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {

    List<MessageDto> getAllMessages(Integer retro_id);
    MessageDto addMessage(Integer retro_id, MessageEntity messageEntity);
    String deleteMessage(Integer retro_id, Integer id);
    MessageDto updateMessage(Integer retro_id, Integer id, String message);
}
