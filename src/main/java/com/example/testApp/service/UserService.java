package com.example.testApp.service;

import com.example.testApp.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserService {
    Optional<User> addPhone(Long id, String phone);

    Optional<User> deletePhone(Long id, String phone);

    Optional<User> addEmail(Long id, String email);

    Optional<User> deleteEmail(Long id, String email);

    boolean sendMoney(String userNameFrom, String userNameTo, BigDecimal amount);

    User getByUsername(String username);

    UserDetailsService userDetailsService();

}
