package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.apache.tika.mime.MediaType;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Student;
import waa.miu.AlumniManagementPortal.repository.StudentRepo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());


    private final StudentRepo studentRepo;


    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Student> filterEntities(Map<String, String> filterParams) {

        List<Student> students = new ArrayList<>();

        for (Map.Entry<String, String> entry : filterParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "state" -> students = studentRepo.findByAddressState(value);
                case "city" -> students = studentRepo.findByAddressCity(value);
                case "major" -> students = studentRepo.findAllByMajorMajorName(value);
                case "name" -> students = studentRepo.findAllByFirstName(value);
                default -> logger.info(key + " <==> " + value);
            }
        }
        return students;
    }

    @Override
    public Student create(Student student) {
        String studentCVPath = processCV(student);
        Student student1 = new Student();
        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setCv(studentCVPath);
        student1.setPassword(student.getPassword());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());
        student1.setAddress(student.getAddress());
        student1.setMajor(student.getMajor());
        student1.setJobAdverts(student.getJobAdverts());
        student1.setCurrentWorkPlace(student.getCurrentWorkPlace());
        student1.setCurrentlyEmployed(student.isCurrentlyEmployed());
        student1.setDeleted(student.isDeleted());
        return studentRepo.save(student1);
    }

    private String processCV(Student student) {
        String base64value = student.getCv();
        byte[] fileBytes = Base64.getDecoder().decode(base64value);
        Tika tika = new Tika();
        MediaType mediaType = MediaType.parse(tika.detect(fileBytes));
        String fileExtension = mediaType.getSubtype();
        if (fileExtension.equals("x-tika-ooxml")) fileExtension = "docx";
        String filePath = "/Users/fortuneking/Downloads/uploads/"+
                student.getFirstName()+"-"+
                student.getLastName()+
                "-CV."+fileExtension;
        try{
            Path path = Path.of(filePath);
            Files.write(path, fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }

    @Override
    public Student update(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()){
            optionalStudent.get().setFirstName(student.getFirstName());
            optionalStudent.get().setLastName(student.getLastName());
            optionalStudent.get().setPassword(student.getPassword());
            optionalStudent.get().setEmail(student.getEmail());
            optionalStudent.get().setPhone(student.getPhone());
            optionalStudent.get().setAddress(student.getAddress());
            optionalStudent.get().setMajor(student.getMajor());
            optionalStudent.get().setJobAdverts(student.getJobAdverts());
            optionalStudent.get().setCurrentWorkPlace(student.getCurrentWorkPlace());
            optionalStudent.get().setCurrentlyEmployed(student.isCurrentlyEmployed());
            optionalStudent.get().setDeleted(student.isDeleted());
        }
        return optionalStudent.orElse(null);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}
