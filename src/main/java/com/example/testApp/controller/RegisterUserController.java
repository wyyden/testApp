package com.example.testApp.controller;

import com.example.testApp.domain.dto.JwtAuthenticationResponse;
import com.example.testApp.domain.dto.SignInRequest;
import com.example.testApp.domain.dto.SignUpRequest;
import com.example.testApp.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registerUser")
public class RegisterUserController {
    private final AuthenticationService authenticationService;


    public RegisterUserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
