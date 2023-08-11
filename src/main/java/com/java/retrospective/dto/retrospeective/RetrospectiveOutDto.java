package com.java.retrospective.dto.retrospeective;

import java.util.List;

import com.java.retrospective.entity.SwimlaneEntity;

import lombok.Data;

@Data
public class RetrospectiveOutDto {
    private String title;
    private String description;
    private List<SwimlaneEntity> swimlanes;
}
