package com.java.retrospective.validator;

import com.java.retrospective.dto.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator {
    public boolean validateForCreate(UserDto user) {
        boolean usernameFlag=true;
        if(user.getUsername().length()==0)
            usernameFlag= false;
            //throw new Exception("Username should not be empty.");
        boolean passwordFlag;
        String passwordRegex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";
        Pattern p = Pattern.compile(passwordRegex);
        Matcher m = p.matcher(user.getPassword());
        passwordFlag= m.matches();
        return (usernameFlag && passwordFlag);
    }
}
