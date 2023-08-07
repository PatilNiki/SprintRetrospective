package com.java.retrospective.services.impl;

import com.java.retrospective.dao.MessageDao;
import com.java.retrospective.dto.message.MessageDto;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.MessageEntity;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<MessageDto> getAllMessages(Integer retro_id) {
        return messageDao.findAll().stream().filter(messageEntity -> messageEntity.getRetrospective().getId().equals(retro_id)).collect(Collectors.toList()).stream().map(this::convertDataIntoDto).collect(Collectors.toList());
    }

    @Override
    public MessageDto addMessage(Integer retro_id, MessageEntity messageEntity) {
        return convertDataIntoDto(messageDao.save(messageEntity));
    }

    @Override
    public String deleteMessage(Integer retro_id, Integer id) {
        messageDao.deleteById(id);
        return "Message Deleted";
    }

    @Override
    public MessageDto updateMessage(Integer retro_id, Integer id, String message) {
        Optional<MessageEntity> optionalMessageEntity = messageDao.findById(id);
        if(optionalMessageEntity.isPresent()){
            MessageEntity messageEntity = optionalMessageEntity.get();
            return convertDataIntoDto(messageDao.save(messageEntity));
        }
        return null;
    }

    private MessageDto convertDataIntoDto(MessageEntity message){
        MessageDto messageDto= new MessageDto();
        messageDto.setMessage(message.getMessage());
        messageDto.setUser(message.getUser());
        messageDto.setRetrospective(message.getRetrospective());
        messageDto.setSwimlane(message.getSwimlane());
        return messageDto;
    }
}
