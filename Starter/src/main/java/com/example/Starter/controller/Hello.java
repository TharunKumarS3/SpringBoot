package com.example.Starter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Value("${welcome.message}")
    private String message;


    @GetMapping(path = "/")
    public String welcome()
    {

        return message;
    }
}
