package com.java.retrospective.dto.swimlane;

import com.java.retrospective.entity.RetrospectiveEntity;

import lombok.Data;

@Data
public class SwimlaneDto {
    private String title;
    private RetrospectiveEntity retrospective;
}
