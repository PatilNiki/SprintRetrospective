package com.java.retrospective.controller;

import java.util.List;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public String addUsers(@RequestBody UserDto user){
        if(userService.addUser(user)!=null)
            return "User registration successful!";
        return "Incorrect inputs. Please check the username and password.";
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return userDtos;
    }


}
