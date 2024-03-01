package com.example.testApp.service;

import com.example.testApp.entity.User;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserService {
    Optional<User> addPhone(Long id, String phone);

    Optional<User> deletePhone(Long id, String phone);

    Optional<User> addEmail(Long id, String email);

    Optional<User> deleteEmail(Long id, String email);

    boolean sendMoney(String userNameFrom, String userNameTo, BigDecimal amount);

}
