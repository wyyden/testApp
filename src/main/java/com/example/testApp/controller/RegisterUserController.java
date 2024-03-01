package com.example.testApp.controller;

import com.example.testApp.entity.User;
import com.example.testApp.service.UserRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/api/registerUser")
public class RegisterUserController {
    private final UserRegistrationService userRegistrationService;

    public RegisterUserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public void createUser(@RequestBody User user, @RequestParam("startBalance") BigDecimal startBalance) {
        userRegistrationService.registerUser(user, startBalance);
    }
}
