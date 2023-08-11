package com.java.retrospective.dto.swimlane;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SwimlaneInDto {
    @NotNull
    private String title;
//    private RetrospectiveOutDto retrospective= new RetrospectiveOutDto();
}
