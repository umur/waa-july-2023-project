package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.service.FacultyService;
import com.blue.alumniMangePortal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final FacultyService facultyService;
    private final StudentService studentService;

    @PostMapping("/register/faculty")
    public ResponseEntity<String> registerFaculty(
            @RequestBody RegisterRequest request
    ){
        facultyService.addFaculty(request);
        return ResponseEntity.ok("Faculty Created Successfully");
    }

    @PostMapping("/register/student")
    public ResponseEntity<String> registerStudent(
            @RequestBody RegisterRequest request
    ){
        studentService.addStudent(request);
        return ResponseEntity.ok("Student Created Successfully");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
