package com.example.testApp.service;

import com.example.testApp.entity.User;

import java.time.LocalDate;

public interface UserSearchService {
    User searchForDate(LocalDate birthDate);
    User searchForPhone(String phone);
    User searchForEmail(String email);
    User searchForFIO(String FIO);
}
