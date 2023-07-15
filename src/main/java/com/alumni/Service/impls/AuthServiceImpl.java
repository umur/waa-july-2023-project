package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.AuthService;
import com.alumni.Service.BaseUserService;
import com.alumni.Service.JwtService;
import com.alumni.dtos.request.LoginRequestDTO;
import com.alumni.dtos.request.SignupRequestDTO;
import com.alumni.dtos.response.LoginResponseDTO;
import com.alumni.entity.BaseUser;
import com.alumni.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    BaseUserService BaseUserService;
    @Autowired
    JwtService jwtService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BaseUserRepository baseUserRepository;


    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginResponseDTO signup(SignupRequestDTO signupRequestDTO) {
        BaseUser baseUser = BaseUserService.save(signupRequestDTO.getEmail(), signupRequestDTO.getPassword(), new ArrayList<>());
        String token = jwtService.generateToken(baseUser);
        LoginResponseDTO loginResponseDTO = modelMapper.map(baseUser, LoginResponseDTO.class);
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws NotFoundException {
        BaseUser baseUser = BaseUserService.getUserByEmailAndPassword(loginRequestDTO.getEmail(),
                bCryptPasswordEncoder.encode(loginRequestDTO.getPassword()));

        String token = jwtService.generateToken(baseUser);
        LoginResponseDTO loginResponseDTO = modelMapper.map(baseUser, LoginResponseDTO.class);
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }
}
