package com.java.retrospective.validator;

import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import org.springframework.stereotype.Component;

@Component
public class RetrospectiveValidator {

    public boolean validateForCreate(RetrospectiveInDto retrospective){
        if(retrospective.getTitle().length()==0)
            return false;
        return true;
    }
}
