/*
package com.example.testApp.init;

import com.example.testApp.domain.entity.User;
import com.example.testApp.repository.UserRepository;
import com.example.testApp.service.UserRegistrationService;
import com.example.testApp.service.UserSearchService;
import com.example.testApp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CmdInit implements CommandLineRunner {
    private final UserRegistrationService userRegistrationService;
    private final UserService userService;

    private final UserSearchService userSearchService;

    public CmdInit(UserRegistrationService userRegistrationService, UserService userService, UserSearchService userSearchService) {
        this.userRegistrationService = userRegistrationService;
        this.userService = userService;
        this.userSearchService = userSearchService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("user1", "qwe123","Bob", "Bob", "89114195656", "user1@mail.ru", LocalDate.of(2001, 04, 23));

        User user2 = new User("user2", "qweqwe","Bob", "Tom", "89114195657", "user2@mail.ru", LocalDate.of(2001, 04, 23));

        userRegistrationService.registerUser(user, BigDecimal.valueOf(200));
        userRegistrationService.registerUser(user2, BigDecimal.valueOf(100));

        userService.addPhone(user.getId(), "89005553535");

        userSearchService.searchForEmail("user1@mail.ru");
        System.out.println(userSearchService.searchForPhone("89005553535").getUsername());
        List<User> users = userSearchService.findByFirstNameOrLastName("Bob", "", Pageable.ofSize(10)).stream().toList();
        for (User u : users) {
            System.out.println(u.getUsername());
        }

        System.out.println(userService.sendMoney(user.getUsername(), user2.getUsername(), BigDecimal.valueOf(50)));

    }
}
*/
