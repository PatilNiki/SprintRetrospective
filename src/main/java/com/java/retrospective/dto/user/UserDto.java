package com.java.retrospective.dto.user;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
