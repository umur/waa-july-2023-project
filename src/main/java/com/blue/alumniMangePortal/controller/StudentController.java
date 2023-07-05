package com.blue.alumniMangePortal.controller;
import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/registerStudent")
    public String registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }
    @PutMapping("/updateProfile/{id}")
    public String updateProfile(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateProfile(id, student);
    }
//    @PostMapping("/addJobAdverts/{id}")
//    public String addJobAdverts(@PathVariable Long id, @RequestBody JobsAdvertised jobs){
//
//        return
//    }
    @GetMapping("/seeCv/{id}")
    public String seeStudentCv(@PathVariable Long id){
        System.out.println("get CV file");
        return "cv is seen";
    }
    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PostMapping("/addprofessionalExperience/{id}")
    public String addJobExperience(@PathVariable Long id,@RequestBody JobExperience jobExperience){
        return studentService.addJobExperience(id, jobExperience);
    }
    @PutMapping("/resetPassword/{password}")
    public String resetPassword(@RequestBody Student student,@PathVariable String password){
        return studentService.resetPassword(student,password);
    }
//    @DeleteMapping("/delete/{id}")
//    public List<Student> deleteById(@PathVariable Long id){
//        return studentService.deleteById(id);
//    }
//    @GetMapping("/filterBy/{variable}")
//    public Student filterStudent(@PathVariable Object obj){
//        return studentService.filterStudent(obj);
//    }
}
