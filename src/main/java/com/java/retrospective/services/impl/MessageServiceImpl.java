package com.java.retrospective.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.retrospective.dao.MessageDao;
import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dto.message.MessageInDto;
import com.java.retrospective.dto.message.MessageOutDto;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.MessageEntity;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.mappers.MessageMapper;
import com.java.retrospective.services.MessageService;

import com.java.retrospective.services.RetrospectiveService;
import com.java.retrospective.services.SwimlaneService;
import com.java.retrospective.services.UserService;
import com.java.retrospective.validator.MessageValidator;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageDao messageDao;
    private final MessageMapper messageMapper;
    private final MessageValidator messageValidator;
    private final UserService userService;
    private final SwimlaneService swimlaneService;
    private final RetrospectiveService retrospectiveService;

    @Override
    public List<MessageOutDto> getAllMessages(Integer retro_id) {
        return messageDao.findAll().stream().filter(messageEntity -> messageEntity.getRetrospective().getId().equals(retro_id)).collect(Collectors.toList()).stream().map(messageMapper::mapEntityToOutDto).collect(Collectors.toList());
    }

    @Override
    public MessageOutDto addMessage(Integer retro_id, MessageInDto messageDto) {
        if(messageValidator.validateForCreate(messageDto)){
            RetrospectiveEntity retrospectiveEntity= retrospectiveService.getRetrospectiveEntity(retro_id);

            if(retrospectiveEntity != null){
                MessageEntity messageEntity = messageMapper.mapInDtoToEntity(messageDto);
                messageEntity.setRetrospective(retrospectiveEntity);
                messageEntity.setUser(userService.getUserById(messageDto.getUserId()));
                messageEntity.setSwimlane(swimlaneService.getSwimlaneById(messageDto.getSwimlaneId()));
                return messageMapper.mapEntityToOutDto(messageDao.save(messageEntity));
            }
        }
        return null;
    }

    @Override
    public String deleteMessage(Integer retro_id, Integer id) {
        messageDao.deleteById(id);
        return "Message Deleted";
    }

    @Override
    public MessageOutDto updateMessage(Integer retro_id, Integer id, String message) {
        if(messageValidator.validateForUpdate(message)) {
            Optional<MessageEntity> optionalMessageEntity = messageDao.findById(id);
            if (optionalMessageEntity.isPresent()) {
                MessageEntity messageEntity = optionalMessageEntity.get();
                return messageMapper.mapEntityToOutDto(messageDao.save(messageEntity));
            }
        }
        return null;
    }

}
