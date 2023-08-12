package com.example.alumni.service;

import com.example.alumni.entity.dto.request.LoginRequest;
import com.example.alumni.entity.dto.response.LoginResponse;
import com.example.alumni.entity.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
