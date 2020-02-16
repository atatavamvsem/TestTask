package com.example.testtask.controller;

import com.example.testtask.models.Role;
import com.example.testtask.models.User;
import com.example.testtask.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepositories userRepositories;

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "infoUser";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}/edit")
    public String userInfoForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "editUser";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam String password, @RequestParam String lastname,
                           @RequestParam Map<String,String> form, @RequestParam String firstname,
                           @RequestParam("userRole") Role role,
                           @RequestParam("userId") User user) {
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.getRoles().clear();
        user.getRoles().add(role);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        userRepositories.save(user);

        return "redirect:/main";
    }
}
