package com.abanul.jwt.controller;

import com.abanul.jwt.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public User getUser(){
        return User.builder()
                .id(1L)
                .name("Andrew")
                .build();
    }
}
