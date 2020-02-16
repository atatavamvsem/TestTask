package com.example.testtask.controller;

import com.example.testtask.models.User;
import com.example.testtask.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.testtask.models.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepositories userRepositories;
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<User> users =  userRepositories.findAll();

        model.put("users", users);

        return "main";
    }





}