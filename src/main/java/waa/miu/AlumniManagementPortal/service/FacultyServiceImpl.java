package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.Faculty;
import waa.miu.AlumniManagementPortal.repository.FacultyRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepo facultyRepo;

    @Override
    public List<Faculty> findAll() {
        return facultyRepo.findAll();
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Faculty with id "+id+" not found"));
    }

    @Override
    public Faculty create(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        Faculty existingFaculty = findById(id);
            existingFaculty.setFirstName(faculty.getFirstName());
            existingFaculty.setLastName(faculty.getLastName());
            existingFaculty.setPassword(faculty.getPassword());
            existingFaculty.setEmail(faculty.getEmail());
            existingFaculty.setPhone(faculty.getPhone());
            existingFaculty.setTitle(faculty.getTitle());
            existingFaculty.setDepartment(faculty.getDepartment());
            existingFaculty.setAddress(faculty.getAddress());
            existingFaculty.setComments(faculty.getComments());
        return facultyRepo.save(existingFaculty);
    }

    @Override
    public void delete(Long id) {
        facultyRepo.deleteById(id);
    }
}
