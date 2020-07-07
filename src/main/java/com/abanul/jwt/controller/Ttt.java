package com.abanul.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ttt {
    @GetMapping
    public void test(){
        System.out.println("Yes");
    }
}
