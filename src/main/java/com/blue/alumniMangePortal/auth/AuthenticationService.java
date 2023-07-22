package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.configuration.JwtService;
import com.blue.alumniMangePortal.dto.RegisterStudent;
//import com.blue.alumniMangePortal.entity.AlumniUser;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.AlumniUserRepo;
import com.blue.alumniMangePortal.repository.FacultyRepo;
import com.blue.alumniMangePortal.repository.StudentRepo;
import com.blue.alumniMangePortal.service.FacultyService;
import com.blue.alumniMangePortal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AlumniUserRepo alumniUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final StudentRepo studentRepo;
    private final UserDetailsService userDetailsService;
    private final FacultyRepo facultyRepo;
    private final FacultyService facultyService;

//    public AuthenticationResponse registerStudent(RegisterStudent registerStudent) {
//        var student = Student.builder()
//                .firstName(registerStudent.getFirstName())
//                .lastName(registerStudent.getLastName())
//                .email(registerStudent.getEmail())
//                .password((passwordEncoder.encode(registerStudent.getPassword())))
//                .phoneNumber(registerStudent.getPhoneNumber())
//                .isDeleted(registerStudent.isDeleted())
//                .currentlyEmployed(registerStudent.isCurrentlyEmployed())
//                .address(registerStudent.getAddress())
//                .major(registerStudent.getMajor())
////                .role(registerStudent.getRole())
//                .build();
//        studentRepo.save(student);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(student.getEmail());
//        var jwtToken = jwtService.generateToken(userDetails);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
////        return null;
//    }

    public void registerFaculty(RegisterRequest request) {
//        String role = request.getRole();
//        var al =
        Faculty faculty = new Faculty();
        faculty.setFirstName(request.getFirst_name());
        faculty.setLastName(request.getLast_name());
        faculty.setEmail(request.getEmail());
        faculty.setPassword(passwordEncoder.encode(request.getPassword()));
        faculty.setRole(request.getRole());
//        var alumniUser = Faculty.builder();
//                .firstName(request.getFirst_name())
//                .lastName(request.getLast_name())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .phone_number(request.getPhone_number())
//                .department(request.getDepartment())
//                .title(request.getTitle())
//                .comments(request.getComments())
//                .address(request.getAddress())
//                .is_admin(true)
//                .is_deleted(false)
//                .role(request.getRole())
//                .build();
//        facultyService.addFaculty(faculty);
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(faculty.getEmail());
//        var jwtToken = jwtService.generateToken(userDetails);
//        System.out.println(jwtToken);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
//        var faculty = facultyRepo.findByEmail(request.getEmail())
//                .orElseThrow();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
