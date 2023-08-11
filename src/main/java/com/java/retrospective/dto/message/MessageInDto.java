package com.java.retrospective.dto.message;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageInDto {
    @NotNull
    private String message;
    @NotNull
    private Integer swimlaneId;
    @NotNull
    private Integer userId;

}
