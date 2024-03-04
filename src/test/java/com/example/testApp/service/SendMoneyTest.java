package com.example.testApp.service;

import com.example.testApp.TestAppApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class SendMoneyTest extends TestAppApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    public void positiveTestSendMoneySuccess() {

        BigDecimal amount = BigDecimal.valueOf(100);

        boolean result = userService.sendMoney("user1", "user2", amount);
        // Assert
        assertTrue(result);
    }

    @Test
    public void negativeTestSendMoneySuccessAmountBiggerBalance() {

        BigDecimal amount = BigDecimal.valueOf(1000);

        boolean result = userService.sendMoney("user1", "user2", amount);
        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void negativeTestSendMoneySuccessNegativeAmount() {

        BigDecimal amount = BigDecimal.valueOf(-10);

        boolean result = userService.sendMoney("user1", "user2", amount);
        // Assert
        Assertions.assertFalse(result);
    }
}
