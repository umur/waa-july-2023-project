package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Student;
import waa.miu.AlumniManagementPortal.repository.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        return studentRepo.save(student);
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
