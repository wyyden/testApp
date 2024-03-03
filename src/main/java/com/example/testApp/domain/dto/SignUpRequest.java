package com.example.testApp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    @Size(min = 5, max = 50, message = "Имя пользователя должно содержать от 5 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;


    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;

    @NotBlank(message = "Имя не может быть пустыми")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotBlank(message = "Номер телефона не может быть пустыми")
    private String phone;

    @NotBlank(message = "Email не может быть пустыми")
    private String email;

    @NotBlank(message = "Дата рождения не может быть пустой")
    private LocalDate birthDate;

    @NotBlank(message = "Начальная сумма не может быть пустой")
    private BigDecimal balance;
}
