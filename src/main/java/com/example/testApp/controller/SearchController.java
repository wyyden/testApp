package com.example.testApp.controller;

import com.example.testApp.entity.User;
import com.example.testApp.service.UserSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
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

    @GetMapping
    public List<User> findUsers(@RequestParam(required = false) LocalDate birthDate,
                                @RequestParam(required = false) String name,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size,
                                @RequestParam(defaultValue = "id") String sortBy) {
    }
}
