package com.blue.alumniMangePortal.controller;
import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.JobsApplied;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.service.JobsAppliedService;
import com.blue.alumniMangePortal.service.JobsAppliedServiceImpl;
import com.blue.alumniMangePortal.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final JobsAppliedService jobsAppliedService;
    @PostMapping("/registerStudent")
    public Student registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }
    @PutMapping("/updateProfile/{id}")
    public Student updateProfile(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateProfile(id, student);
    }
    @PostMapping ("/applyForJob/{id}")
    public JobsApplied applyForJob(@PathVariable Long id,@RequestBody JobsApplied jobsApplied){
        return jobsAppliedService.addJobsApplied(id, jobsApplied);
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
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
         studentService.deleteById(id);
    }
    @GetMapping("/filterBy/{variable}")
    public List<Student> filterStudent(@PathVariable String variable){
        return studentService.filterStudent(variable);
    }
}
