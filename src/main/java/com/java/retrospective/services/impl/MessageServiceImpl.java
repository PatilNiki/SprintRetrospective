package com.java.retrospective.services.impl;

import com.java.retrospective.dao.MessageDao;
import com.java.retrospective.entity.MessageEntity;
import com.java.retrospective.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<MessageEntity> getAllMessages() {
        return messageDao.findAll();
    }

    @Override
    public MessageEntity addMessage(MessageEntity messageEntity) {
        return messageDao.save(messageEntity);
    }

    @Override
    public String deleteMessage(Integer id) {
        messageDao.deleteById(id);
        return null;
    }

    @Override
    public MessageEntity updateMessage(Integer id, String message) {
        Optional<MessageEntity> optionalMessageEntity = messageDao.findById(id);
        if(optionalMessageEntity.isPresent()){
            MessageEntity messageEntity = optionalMessageEntity.get();
            return messageDao.save(messageEntity);
        }
        return null;
    }
}
