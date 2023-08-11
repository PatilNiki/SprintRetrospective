package com.java.retrospective.validator;

import com.java.retrospective.dto.swimlane.SwimlaneInDto;
import org.springframework.stereotype.Component;

@Component
public class SwimlaneValidator {
    public boolean validateForCreate(SwimlaneInDto swimlane){
        if (swimlane.getTitle().length()==0)
            return false;
        return true;
    }
}
