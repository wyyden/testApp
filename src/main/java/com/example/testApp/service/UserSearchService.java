package com.example.testApp.service;

import com.example.testApp.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface UserSearchService {
    User searchForPhone(String phone);
    User searchForEmail(String email);

    Page<User> findByBirthdateAfter(LocalDate birthDate, Pageable pageable);

    Page<User> findByFirstNameOrLastName(String firstName, String lastName, Pageable pageable);
}
