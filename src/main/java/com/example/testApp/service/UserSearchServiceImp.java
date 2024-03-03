package com.example.testApp.service;

import com.example.testApp.domain.entity.User;
import com.example.testApp.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserSearchServiceImp implements UserSearchService {

    private final UserRepository userRepository;

    public UserSearchServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchForPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User searchForEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<User> findByBirthdateAfter(LocalDate birthDate, Pageable pageable) {
        if (birthDate == null) {
            return userRepository.findAll(pageable);
        } else {
            return userRepository.findByBirthDateAfter(birthDate, pageable);
        }
    }

    @Override
    public Page<User> findByFirstNameOrLastName(String firstName, String lastName,Pageable pageable) {
        if (firstName == null) {
            return userRepository.findAll(pageable);
        } else {
            return userRepository.findByFirstNameLikeOrLastNameLike(firstName, lastName, pageable);
        }
    }
}
