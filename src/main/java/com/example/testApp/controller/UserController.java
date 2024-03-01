package com.example.testApp.controller;

import com.example.testApp.entity.User;
import com.example.testApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PutMapping("/{userId}/phone")
    public User addUserPhone(@PathVariable("userId") Long userId,
                                @RequestParam("phone") String phone) {
        return userService.addPhone(userId, phone).get();
    }

    @PutMapping("/{userId}/email")
    public User addUserEmail(@PathVariable("userId") Long userId,
                                @RequestParam("email") String email) {
        return userService.addEmail(userId, email).get();
    }

    @DeleteMapping("/{userId}/phone")
    public User deleteUserPhone(@PathVariable("userId") Long userId,
                                @RequestParam("phone") String phone) {
        return userService.deletePhone(userId, phone).get();
    }

    @DeleteMapping("/{userId}/email")
    public User deleteUserEmail(@PathVariable("userId") Long userId,
                                @RequestParam("email") String email) {
        return userService.deleteEmail(userId, email).get();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam("fromUsername") String fromUsername,
                         @RequestParam("toUsername") String toUsername,
                         @RequestParam("amount") BigDecimal amount) {
        transferService.transfer(fromUsername, toUsername, amount);
    }
}
