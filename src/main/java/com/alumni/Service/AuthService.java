package com.alumni.Service;

import com.alumni.dtos.request.LoginRequestDTO;
import com.alumni.dtos.request.SignupRequestDTO;
import com.alumni.dtos.response.LoginResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponseDTO signup(SignupRequestDTO signupRequestDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

}
