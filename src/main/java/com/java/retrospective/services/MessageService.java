package com.java.retrospective.services;

import com.java.retrospective.dto.message.MessageInDto;
import com.java.retrospective.dto.message.MessageOutDto;
import com.java.retrospective.entity.MessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {

    List<MessageOutDto> getAllMessages(Integer retro_id);
    MessageOutDto addMessage(Integer retro_id, MessageInDto messageEntity);
    String deleteMessage(Integer retro_id, Integer id);
    MessageOutDto updateMessage(Integer retro_id, Integer id, String message);
}
