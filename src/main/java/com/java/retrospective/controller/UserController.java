package com.java.retrospective.controller;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.services.UserService;
import com.java.retrospective.services.mappers.UserMappingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMappingService userServicerMappingService;
    @PostMapping
    public String addUsers(@RequestBody UserDto user){
        userService.addUser(user);
        return "User registration successful!";
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<UserDto> userDtos=userService.getAllUsers();
        return userDtos;
    }

}
