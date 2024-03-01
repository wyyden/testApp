package com.example.testApp.init;

import com.example.testApp.entity.User;
import com.example.testApp.service.UserRegistrationService;
import com.example.testApp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CmdInit implements CommandLineRunner {
    private final UserRegistrationService userRegistrationService;

    public CmdInit(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("user1", "Fio Fio Fio", "89114195656", "user1@mail.ru", LocalDate.of(2001, 04, 23));

        User user2 = new User("user2", "Fio Fio Fio", "89114195657", "user2@mail.ru", LocalDate.of(2001, 04, 23));

        userRegistrationService.registerUser(user, BigDecimal.valueOf(200));
        userRegistrationService.registerUser(user2, BigDecimal.valueOf(100));
    }
}
