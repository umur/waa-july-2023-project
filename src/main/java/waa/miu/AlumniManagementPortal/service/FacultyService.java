package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.Faculty;

import java.util.List;

public interface FacultyService {

    List<Faculty> findAll();

    Faculty findById(Long id);

    Faculty create(Faculty faculty);

    Faculty update(Long id, Faculty faculty);

    void delete(Long id);
}
