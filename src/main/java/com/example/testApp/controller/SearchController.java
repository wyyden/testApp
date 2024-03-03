package com.example.testApp.controller;

import com.example.testApp.domain.entity.User;
import com.example.testApp.service.UserSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/user/search")
public class SearchController {

    private final UserSearchService userSearchService;

    public SearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @GetMapping("/phone")
    public User findUserByPhone(@RequestParam("phone") String phone) {
        return userSearchService.searchForPhone(phone);
    }

    @GetMapping("/email")
    public User findUserByEmail(@RequestParam("email") String email) {
        return userSearchService.searchForEmail(email);
    }


    @GetMapping("/birthDate")
    public Page<User> findByBirthDateAfter(
            @RequestParam(required = false) LocalDate birthdate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return userSearchService.findByBirthdateAfter(birthdate, pageable);
    }

    @GetMapping("/FIO")
    public Page<User> findByFirstName(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return userSearchService.findByFirstNameOrLastName(firstName, lastName, pageable);
    }
}
