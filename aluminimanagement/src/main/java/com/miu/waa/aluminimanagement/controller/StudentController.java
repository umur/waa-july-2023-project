package com.miu.waa.aluminimanagement.controller;

<<<<<<< HEAD
import com.miu.waa.aluminimanagement.service.StudentServiceImpl;
=======
import com.miu.waa.aluminimanagement.model.StudentPerState;
import com.miu.waa.aluminimanagement.model.dto.StudentDto;
import com.miu.waa.aluminimanagement.service.StudentService;
>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d
@RestController
@CrossOrigin
@RequestMapping("/students")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_FACULTY','ROLE_ADMIN')")
public class StudentController {
<<<<<<< HEAD

    private  final StudentServiceImpl studentService;


=======
    private final StudentService studentService;
    @GetMapping
    public List<StudentDto> findAll(
            @RequestParam(required = false, defaultValue = "") String filter,
            @RequestParam(required = false, defaultValue = "") String value
    ) {
        var students = studentService.findAll(filter, value);
        return students;
    }

    @GetMapping("/perState")
    public List<StudentPerState> noOfStudentsPerState(){
        return studentService.noOfStudentsPerState();
    }

>>>>>>> d04e8fcb214aa5015d586690d5daf5c64c82438d

}
