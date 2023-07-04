package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> findAll();

    Student findById(Long id);

    void filterEntities(Map<String, String> filterParams);

    Student create(Student student);

    Student update(Long id, Student student);

    void delete(Long id);
}
