package com.example.alumni.controller;

import com.example.alumni.entity.User;
import com.example.alumni.entity.dto.request.LoginRequest;
import com.example.alumni.entity.dto.request.RefreshTokenRequest;
import com.example.alumni.entity.dto.request.SignUpRequest;
import com.example.alumni.entity.dto.response.LoginResponse;
import com.example.alumni.service.AuthService;
import com.example.alumni.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {
    @Autowired
    private ModelMapper modelMapper;

    private final AuthService authService;

    private final UserService userService;

    @Autowired
    public UaaController(AuthService authService, UserService userService) {
        this.authService = authService;

        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        var loginResponse = authService.refreshToken(refreshTokenRequest);
        return loginResponse;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) throws IllegalAccessException {
        User user = modelMapper.map(signUpRequest, User.class);
        String email = user.getEmail();
        ;
        String plainPassword = user.getPassword();
        user = userService.add(user);

        LoginRequest loginRequest = new LoginRequest(email, plainPassword);

        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(
                loginResponse, HttpStatus.OK);
    }
}

