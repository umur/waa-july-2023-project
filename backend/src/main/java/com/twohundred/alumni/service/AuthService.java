package com.twohundred.alumni.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.Address;
import com.twohundred.alumni.entity.Faculty;
import com.twohundred.alumni.entity.Role;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.User;
import com.twohundred.alumni.entity.dto.request.FacultyRegisterRequest;
import com.twohundred.alumni.entity.dto.request.LoginRequest;
import com.twohundred.alumni.entity.dto.request.RegisterRequest;
import com.twohundred.alumni.entity.dto.request.StudentRegisterRequest;
import com.twohundred.alumni.entity.dto.response.LoginResponse;
import com.twohundred.alumni.repository.FacultyRepo;
import com.twohundred.alumni.repository.RoleRepo;
import com.twohundred.alumni.repository.StudentRepo;
import com.twohundred.alumni.repository.Token;
import com.twohundred.alumni.repository.TokenRepository;
import com.twohundred.alumni.repository.UserRepo;
import com.twohundred.alumni.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RoleRepo roleRepo;
    private final UserRepo repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final FacultyRepo facultyRepo;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public LoginResponse registerFaculty(FacultyRegisterRequest request) {
        List<Role> roles = Arrays.asList(roleRepo.findByRole("FACULTY"));
        var faculty = new Faculty(request.getTitle(), request.getSalary());
        faculty.setFirstName(request.getFirstname());
        faculty.setLastName(request.getLastname());
        faculty.setEmail(request.getEmail());
        faculty.setPassword(passwordEncoder.encode(request.getPassword()));
        faculty.setRoles(roles);
        Address address = modelMapper.map(request.getAddress(), Address.class);
        faculty.setAddress(address);
        facultyRepo.save(faculty);
        var jwtToken = jwtUtil.generateToken(faculty);
        saveUserToken(faculty, jwtToken);
        return new LoginResponse(jwtToken, faculty.getId(), faculty.getFirstName() + ' ' + faculty.getLastName(),
                faculty.getRoles().stream().map(r -> r.getRole()).toList());
    }

    public LoginResponse registerStudent(StudentRegisterRequest request) {
        List<Role> roles = Arrays.asList(roleRepo.findByRole("STUDENT"));
        var student = new Student(request.getMajor(), request.getGpa());
        student.setFirstName(request.getFirstname());
        student.setLastName(request.getLastname());
        student.setEmail(request.getEmail());
        student.setPassword(passwordEncoder.encode(request.getPassword()));
        student.setRoles(roles);
        Address address = modelMapper.map(request.getAddress(), Address.class);
        student.setAddress(address);
        studentRepo.save(student);
        var jwtToken = jwtUtil.generateToken(student);
        saveUserToken(student, jwtToken);
        return new LoginResponse(jwtToken, student.getId(), student.getFirstName() + ' ' +  student.getLastName(),
                student.getRoles().stream().map(r -> r.getRole()).toList());
    }

    public LoginResponse register(RegisterRequest request) {
        List<Role> roles = Arrays.asList(roleRepo.findByRole(request.getRole()));
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setZip(request.getZip());
        address.setState(request.getState());
        User user;
        if("STUDENT".equals(request.getRole())) {
            user = new Student();
        } else {
            user = new Faculty();
        }
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);
        user.setAddress(address);
        user.setActive(true);
        user.setLocked(false);
        var savedUser = repository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return new LoginResponse(jwtToken, user.getId(), user.getFirstName() + ' ' +  user.getLastName(),
                user.getRoles().stream().map(r -> r.getRole()).toList());
    }

    public LoginResponse authenticate(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }

        try {
            var user = repository.findByEmail(request.getEmail()).orElseThrow();
            var jwtToken = jwtUtil.generateToken(user);
            saveUserToken(user, jwtToken);
            return new LoginResponse(jwtToken, user.getId(), user.getFirstName() + ' ' +  user.getLastName(),
                    user.getRoles().stream().map(r -> r.getRole()).toList());
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
