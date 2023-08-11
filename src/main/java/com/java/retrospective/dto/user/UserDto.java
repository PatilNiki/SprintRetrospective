package com.java.retrospective.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
