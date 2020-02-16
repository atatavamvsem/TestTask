package com.example.testtask.controller;

import com.example.testtask.models.User;
import com.example.testtask.repositories.UserRepoList;
import com.example.testtask.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.example.testtask.models.Role;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepositories userRepositories;

    @Qualifier("userRepoList")
    @Autowired
    private UserRepoList userRepoList;
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filterUser, Model model){
        Iterable<User> users =  userRepoList.findAll();

        if (filterUser != null && !filterUser.isEmpty()) {
            users = userRepoList.findByUsername(filterUser);
        } else {
            users = userRepoList.findAll();
        }

        model.addAttribute("users", users);
        model.addAttribute("filterUser", filterUser);
        return "main";
    }





}