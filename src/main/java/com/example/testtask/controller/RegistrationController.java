package com.example.testtask.controller;

import com.example.testtask.converters.DtoConverter;
import com.example.testtask.models.Role;
import com.example.testtask.models.User;
import com.example.testtask.models.UserDto;
import com.example.testtask.repositories.UserRepositories;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {
    @Autowired
    private DtoConverter dtoConverter;

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
    public String addUser(@Valid @ModelAttribute(name = "user") UserDto user, BindingResult bindingResult, Model model,
                          @RequestParam("userRole") Set<Role> role){
        if(user.getPassword() == null){
            model.addAttribute("passwordError", "password empty");
        }
        if (bindingResult.hasErrors()) {
            Map<String,String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);

            model.addAttribute("roles", Role.values());
            return "registration";
        } else {
            User userFromDb = userRepositories.findByUsername(user.getUsername());

            if (userFromDb != null) {
                model.addAttribute("usernameError", "user exist");
                model.addAttribute("roles", Role.values());
                return "registration";
            }
            user.setStatus(true);
            user.setRoles(role);

            LocalDate localDate = LocalDate.now();
            user.setCreated(localDate);
            String a = user.getPassword();
            user.setPassword(passwordEncoder.encode(a));
            User newUser = dtoConverter.convertToEntityUser(user);
            userRepositories.save(newUser);
            return "redirect:/main";
        }
    }
}
