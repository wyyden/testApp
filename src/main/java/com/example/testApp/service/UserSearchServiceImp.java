package com.example.testApp.service;

import com.example.testApp.entity.User;
import com.example.testApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserSearchServiceImp implements UserSearchService{

    private final UserRepository userRepository;

    public UserSearchServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchForDate(LocalDate birthDate) {
        
        return null;
    }

    @Override
    public User searchForPhone(String phone) {
        return null;
    }

    @Override
    public User searchForEmail(String email) {
        return null;
    }

    @Override
    public User searchForFIO(String FIO) {
        return null;
    }
}
