package com.example.testApp.service;

import com.example.testApp.domain.entity.User;

import java.math.BigDecimal;

public interface UserRegistrationService {
    void registerUser(User user, BigDecimal start_amount);
}
