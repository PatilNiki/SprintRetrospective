package com.java.retrospective.dto.message;

import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.entity.UserEntity;

import lombok.Data;

@Data
public class MessageDto {
    private String message;
    private UserEntity user;
    private RetrospectiveEntity retrospective;
    private SwimlaneEntity swimlane;
}
