package com.java.retrospective.dto.retrospeective;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RetrospectiveInDto {
    @NotNull
    private String title;
    @NotNull
    private String description;
}
