package com.example.testtask.controller;

import com.example.testtask.models.Role;
import com.example.testtask.models.User;
import com.example.testtask.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration( Model model){
        model.addAttribute("roles", Role.values());
        return "registration";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model,
                          @RequestParam("userRole") Set<Role> role){
        User userFromDb = userRepositories.findByUsername(user.getUsername());

        if(userFromDb!= null){
            model.put("message", "user exist");
            model.put("roles", Role.values());
            return "registration";
        }
        user.setStatus(true);
        user.setRoles(role);

        LocalDate localDate = LocalDate.now();
        user.setCreated(localDate);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepositories.save(user);
        return "redirect:/main";
    }
}
