package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Role;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.LoginRequest;
import com.twohundred.alumni.entity.dto.request.RegisterRequest;
import com.twohundred.alumni.entity.dto.response.LoginResponse;
import com.twohundred.alumni.repository.RoleRepo;
import com.twohundred.alumni.repository.Token;
import com.twohundred.alumni.repository.TokenRepository;
import com.twohundred.alumni.repository.UserRepo;
import com.twohundred.alumni.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final RoleRepo roleRepo;
  private final UserRepo repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;
  private final AuthenticationManager authenticationManager;

  public LoginResponse register(RegisterRequest request) {
    List<Role> roles = Arrays.asList(roleRepo.findByRole(request.getRole()));
    var user = new User(
        request.getFirstname(),
        request.getLastname(),
        request.getEmail(),
        passwordEncoder.encode(request.getPassword()),
        roles);
    var savedUser = repository.save(user);
    var jwtToken = jwtUtil.generateToken(user);
    saveUserToken(savedUser, jwtToken);
    return new LoginResponse(jwtToken);
  }

  public LoginResponse authenticate(LoginRequest request) {
    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getEmail(),
                      request.getPassword()
              )
      );
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException(e.getMessage());
    } catch (Exception ex) {
      System.out.println("Error:" + ex.getMessage());
    }

    try {
      var user = repository.findByEmail(request.getEmail()).orElseThrow();
      var jwtToken = jwtUtil.generateToken(user);
      saveUserToken(user, jwtToken);
      return new LoginResponse(jwtToken);
    } catch (Exception ex) {
      System.out.println("Error:" + ex.getMessage());
    }
    return null;
  }

  private void saveUserToken(User user, String jwtToken) {
    Token token = new Token(jwtToken, System.currentTimeMillis(), user);
    tokenRepository.saveToken(token);
  }
}
