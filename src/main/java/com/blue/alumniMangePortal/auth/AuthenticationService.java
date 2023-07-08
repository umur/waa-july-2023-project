package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.configuration.JwtService;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.Role;
import com.blue.alumniMangePortal.repository.FacultyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final FacultyRepo facultyRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var faculty = Faculty.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .department(request.getDepartment())
                .title(request.getTitle())
                .comments(request.getComments())
                .address(request.getAddress())
                .is_admin(true)
                .is_deleted(false)
                .role(Role.USER)
                .build();
        facultyRepo.save(faculty);
        var jwtToken = jwtService.generateToken(faculty);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var faculty = facultyRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(faculty);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
