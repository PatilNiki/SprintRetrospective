package com.java.retrospective.dto.message;

import com.java.retrospective.dto.retrospeective.SimpleRetrospectiveOutDto;
import com.java.retrospective.dto.swimlane.SwimlaneOutDto;
import com.java.retrospective.dto.user.UserDto;
import lombok.Data;

@Data
public class MessageOutDto {
    private String message;
    private UserDto user=null;
    private SimpleRetrospectiveOutDto retrospective=null;
    private SwimlaneOutDto swimlane =null;
}
