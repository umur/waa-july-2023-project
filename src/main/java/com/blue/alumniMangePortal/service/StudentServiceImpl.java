package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.dto.StudentJob;
import com.blue.alumniMangePortal.entity.JobsAdvertised;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public String registerStudent(Student student) {
        studentRepo.save(student);
        return "student added";
    }

    public String updateProfile(Long id, Student student) {
        Optional<Student> std = studentRepo.findById(id);
        if (std.isPresent()) {
            Student s = std.get();
            s.setCurrentlyEmployed(student.isCurrentlyEmployed());
            s.setFirstName(student.getFirstName());
            s.setPassword(student.getPassword());
            s.setJobExperiences(student.getJobExperiences());
            s.setLastName(student.getLastName());
            s.setJobsAdvertisedList(student.getJobsAdvertisedList());
            s.setPhoneNumber(student.getPhoneNumber());
            studentRepo.save(s);
        }
        return null;
    }

    public String seeStudentCv(Long id) {
        System.out.println("get CV file");
        return "Cv displayed";
    }

    public Student filterStudent(Object obj) {
        if (obj instanceof String) {
            String var = (String) obj;
            if (studentRepo.findByState(var) != null) {
                return studentRepo.findByState(var);
            } else if (studentRepo.findByCity(var) != null) {
                return studentRepo.findByCity(var);
            } else if (studentRepo.findByMajor(var) != null) {
                return studentRepo.findByMajor(var);
            } else if (studentRepo.findByName(var) != null) {
                return studentRepo.findByName(var);
            }
        } else if (obj instanceof Long) {
            Long var = (Long) obj;
            if (studentRepo.findById(var) != null) {
                Optional<Student> std = studentRepo.findById(var);
                return std.get();
            }
        }
        return null;
    }

    public Student getStudentById(Long id) {
        Optional<Student> std = studentRepo.findById(id);
        if (std.isPresent()) {
            return std.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String addJobExperience(Student student, String jobExperience) {
        student.setJobExperiences(jobExperience);
        studentRepo.save(student);
        return jobExperience;
    }

    public String resetPassword(Student student, String password) {
        student.setPassword(password);
        studentRepo.save(student);
        return "password has been reset";
    }

    public List<Student> deleteById(Long id) {
        Optional<Student> std=studentRepo.findById(id);
        if(std.isPresent()){
            Student s= std.get();
            s.setDeleted(true);
            return studentRepo.findAllByIsDeletedFalse();
        }
        return null;
    }
}

