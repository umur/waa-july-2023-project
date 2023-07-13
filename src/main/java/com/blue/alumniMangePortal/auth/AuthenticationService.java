package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.configuration.JwtService;
import com.blue.alumniMangePortal.dto.RegisterStudent;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.FacultyRepo;
import com.blue.alumniMangePortal.repository.StudentRepo;
import com.blue.alumniMangePortal.service.StudentService;
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
    private final StudentRepo studentRepo;

    public AuthenticationResponse registerStudent(RegisterStudent registerStudent) {
        var student = Student.builder()
                .firstName(registerStudent.getFirstName())
                .lastName(registerStudent.getLastName())
                .email(registerStudent.getEmail())
                .password((passwordEncoder.encode(registerStudent.getPassword())))
                .phoneNumber(registerStudent.getPhoneNumber())
                .isDeleted(registerStudent.isDeleted())
                .currentlyEmployed(registerStudent.isCurrentlyEmployed())
                .address(registerStudent.getAddress())
                .major(registerStudent.getMajor())
                .role(registerStudent.getRole())
                .build();
        studentRepo.save(student);
        var jwtToken = jwtService.generateToken(student);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerFaculty(RegisterRequest request) {
//        String role = request.getRole();
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
                .role(request.getRole())
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
