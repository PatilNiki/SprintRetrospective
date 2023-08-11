package com.java.retrospective.validator;

import com.java.retrospective.dto.message.MessageInDto;
import org.springframework.stereotype.Component;

@Component
public class MessageValidator {
    public boolean validateForCreate(MessageInDto message){
        if(message.getMessage().length()==0 || message.getMessage().length()>60)
            return false;
        return true;
    }
    public boolean validateForUpdate(String message){
        if(message.length()>60)
            return false;
        return true;
    }
}
