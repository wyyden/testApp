package com.example.testApp.service;

import com.example.testApp.domain.entity.Account;
import com.example.testApp.domain.entity.User;
import com.example.testApp.repository.AccountRepository;
import com.example.testApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service()
public class UserRegistrationServiceImp implements UserRegistrationService{
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserRegistrationServiceImp(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void registerUser(User user, BigDecimal start_amount) {
        Account account = new Account(start_amount, user);
        user.setAccount(account);
        userRepository.save(user);
        accountRepository.save(account);
    }
}
