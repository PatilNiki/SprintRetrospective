package com.java.retrospective.dto.user;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String username;
    private String password;
}
