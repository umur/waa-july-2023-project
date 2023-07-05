package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.JobExperienceRepo;
import com.blue.alumniMangePortal.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final JobExperienceRepo jobExperienceRepo;
//    private final AddressRepo addressRepo;
    @Override
    public String registerStudent(Student student) {
        studentRepo.save(student);
        return "student added";
    }
    @Override
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
    @Override
    public String seeStudentCv(Long id) {
        System.out.println("get CV file");
        return "Cv displayed";
    }
//    @Override
//    public Student filterStudent(Object obj) {
//        if (obj instanceof String) {
//            String var = (String) obj;
//            if (studentRepo.findByState(var) != null) {
//                return studentRepo.findByState(var);
//            } else if (studentRepo.findByCity(var) != null) {
//                return studentRepo.findByCity(var);
//            } else if (studentRepo.findByMajor(var) != null) {
//                return studentRepo.findByMajor(var);
//            } else if (studentRepo.findByName(var) != null) {
//                return studentRepo.findByName(var);
//            }
//        } else if (obj instanceof Long) {
//            Long var = (Long) obj;
//            if (studentRepo.findById(var) != null) {
//                Optional<Student> std = studentRepo.findById(var);
//                return std.get();
//            }
//        }
//        return null;
//    }
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> std = studentRepo.findById(id);
        if (std.isPresent()) {
            return std.get();
        }
        return null;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @Override
    public String addJobExperience(Long id, JobExperience jobExperience) {
        jobExperienceRepo.save(jobExperience);
        Optional<Student>std=studentRepo.findById(id);
        if(std.isPresent()) {
            Student student=std.get();
            student.setJobExperiences(jobExperience);
            studentRepo.save(student);
            return "job experience added";
        }
        return null;
    }
    @Override
    public String resetPassword(Student student, String password) {
        student.setPassword(password);
        studentRepo.save(student);
        return "password has been reset";
    }
//    @Override
//    public List<Student> deleteById(Long id) {
//        Optional<Student> std=studentRepo.findById(id);
//        if(std.isPresent()){
//            Student s= std.get();
//            s.setDeleted(true);
//            return studentRepo.findAllByIsDeletedFalse();
//        }
//        return null;
//    }
}

