package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.auth.RegisterRequest;
import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.JobExperience;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.entity.UploadedFilePath;
import com.blue.alumniMangePortal.repository.FilePathUploadRepo;
import com.blue.alumniMangePortal.repository.JobExperienceRepo;
import com.blue.alumniMangePortal.repository.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.apache.tika.mime.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final JobExperienceRepo jobExperienceRepo;
    private final FilePathUploadRepo filePathUploadRepo;
    private final PasswordEncoder passwordEncoder;

    //    private final AddressRepo addressRepo;
    @Override
    public Student registerStudent(Student student) {
        jobExperienceRepo.save(student.getJobExperiences());
        UploadedFilePath filePath = null;
        if (student.getCv() == null) {
            filePath = null;
        } else {
            try {

                filePath = processCvPath(student);
                filePathUploadRepo.save(filePath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Student student1 = new Student();
        student1.setCv(filePath);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setPassword(student.getPassword());
        student1.setId(student.getId());
        student1.setDeleted(student.isDeleted());
        student1.setPhoneNumber(student.getPhoneNumber());
        student1.setJobExperiences(student.getJobExperiences());
        student1.setCurrentlyEmployed(student1.isCurrentlyEmployed());
        student1.setAddress(student.getAddress());
        student1.setMajor(student.getMajor());
        student1.setJobsAdvertisedList(student.getJobsAdvertisedList());

        studentRepo.save(student1);
        return student1;
    }

    //In summary, this method takes a base64-encoded file path,
    // decodes it, saves the corresponding file to the specified location on the desktop,
    // and returns an UploadedFilePath object representing the saved file path.
    private UploadedFilePath processCvPath(Student student) throws IOException {
        UploadedFilePath uploaded = student.getCv();

        String base64value = uploaded.getFilePath();

        byte[] fileBytes = Base64.getDecoder().decode(base64value);

        Tika tika = new Tika();//object used for detecting file formats

        MediaType mediaType = MediaType.parse(tika.detect(fileBytes));//storing media type

        String fileExtention = mediaType.getSubtype();

        if (fileExtention.equals("x-tika-ooxml")) fileExtention = "docx";

        String fileName = student.getFirstName() + "-" + student.getLastName() + "-CV." + fileExtention;
        String path1 = Paths.get("uploads", fileName).toString();

        Path path = Path.of(path1);
        Files.write(path, fileBytes);

        String path2Db = path1.toString();
        UploadedFilePath path3 = new UploadedFilePath();
        path3.setFilePath(path2Db);
        return path3;
    }

    @Override
    public Student updateProfile(Long id, Student student) {
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
            s.setCv(student.getCv());
            studentRepo.save(s);
            return s;
        }
        return null;
    }

    @Override
    public String seeStudentCv(Long id) {
        System.out.println("get CV file");
        return "Cv displayed";
    }

    @Override
    public List<Student> filterStudent(String var) {

        if (studentRepo.findByFirstName(var) != null) {
            return studentRepo.findByFirstName(var);
        }
        return null;
    }

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
        Optional<Student> std = studentRepo.findById(id);
        if (std.isPresent()) {
            Student student = std.get();
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
    @Override
    public void deleteById(Long id) {
        Optional<Student> std=studentRepo.findById(id);
        if(std.isPresent()){
            Student s= std.get();
            s.setDeleted(true);
        }
    }

    @Override
    public void addStudent(RegisterRequest request) {
        Student newStudent = new Student();
        newStudent.setFirstName(request.getFirst_name());
        newStudent.setLastName(request.getLast_name());
        newStudent.setEmail(request.getEmail());
        newStudent.setPassword(passwordEncoder.encode(request.getPassword()));
        newStudent.setRole(request.getRole());

        studentRepo.save(newStudent);
    }
}

