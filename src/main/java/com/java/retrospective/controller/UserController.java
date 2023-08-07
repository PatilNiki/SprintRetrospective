package com.java.retrospective.controller;

import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.UserService;
import com.java.retrospective.services.mapping.UserMappingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserMappingService userServicerMappingService;
    @PostMapping(value = "/users")
    public String addUsers(@RequestBody UserEntity user){
        userService.addUser(user);
        return "User registration successful!";
    }

    @GetMapping(value="/users")
    public String getAllUsers(){

        userService.getAllUsers().forEach(user-> System.out.println("Username: "+user.getUsername()+" Password: "+user.getPassword()));
        return "";
    }

}
