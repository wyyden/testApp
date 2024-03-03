package com.example.testApp.service;

import com.example.testApp.domain.entity.Account;
import com.example.testApp.domain.entity.User;
import com.example.testApp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public Optional<User> addPhone(Long id, String phone) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Set<String> phones = user.get().getPhones();
            phones.add(phone);
            user.get().setPhones(phones);
        }
        return user;
    }

    @Override
    public Optional<User> deletePhone(Long id, String phone) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Set<String> phones = user.get().getPhones();
            if (phones.size() > 1) {
                phones.remove(phone);
                user.get().setPhones(phones);
            }
        }
        return user;
    }

    @Transactional
    @Override
    public Optional<User> addEmail(Long id, String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Set<String> emails = user.get().getEmails();
            emails.add(email);
            user.get().setPhones(emails);
        }
        return user;
    }

    @Override
    public Optional<User> deleteEmail(Long id, String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Set<String> emails = user.get().getEmails();
            if (emails.size() > 1) {
                emails.remove(email);
                user.get().setPhones(emails);
            }
        }
        return user;
    }

    @Transactional
    @Override
    public boolean sendMoney(String userNameFrom, String userNameTo, BigDecimal amount) {
        User userFrom = userRepository.findByUsername(userNameFrom);
        if (userFrom.getAccount().getBalance().longValue() >= amount.longValue() && amount.longValue() > 0) {
            User userTo = userRepository.findByUsername(userNameTo);
            Account accountTo = userTo.getAccount();
            Account accountFrom = userFrom.getAccount();
            accountTo.setBalance(accountTo.getBalance().add(amount));
            accountFrom.setBalance(accountFrom.getBalance().subtract(amount));
            return true;
        }
        return false;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
}
