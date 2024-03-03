package com.example.testApp.service;

import com.example.testApp.domain.dto.JwtAuthenticationResponse;
import com.example.testApp.domain.dto.SignInRequest;
import com.example.testApp.domain.dto.SignUpRequest;
import com.example.testApp.domain.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {
    private final UserRegistrationService userRegistrationService;
    private final JwtService jwtService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRegistrationService userRegistrationService,
                                 JwtService jwtService, UserService userService, PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager) {
        this.userRegistrationService = userRegistrationService;
        this.jwtService = jwtService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        Set<String> phones = new HashSet<>();
        phones.add(request.getPhone());

        Set<String> emails = new HashSet<>();
        phones.add(request.getEmail());

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phones(phones)
                .emails(emails)
                .birthDate(request.getBirthDate())
                .build();

        userRegistrationService.registerUser(user, request.getBalance());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        User user = (User) userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
