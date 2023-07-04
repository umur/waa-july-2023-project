package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Faculty;
import waa.miu.AlumniManagementPortal.repository.FacultyRepo;

import java.util.List;
import java.util.Optional;

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
        return facultyRepo.findById(id).orElse(null);
    }

    @Override
    public Faculty create(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        Optional<Faculty> optionalFaculty = facultyRepo.findById(id);
        if (optionalFaculty.isPresent()){
            optionalFaculty.get().setFirstName(faculty.getFirstName());
            optionalFaculty.get().setLastName(faculty.getLastName());
            optionalFaculty.get().setPassword(faculty.getPassword());
            optionalFaculty.get().setEmail(faculty.getEmail());
            optionalFaculty.get().setPhone(faculty.getPhone());
            optionalFaculty.get().setTitle(faculty.getTitle());
            optionalFaculty.get().setAdmin(faculty.isAdmin());
            optionalFaculty.get().setDeleted(faculty.isDeleted());
            optionalFaculty.get().setDepartment(faculty.getDepartment());
            optionalFaculty.get().setAddress(faculty.getAddress());
            optionalFaculty.get().setComments(faculty.getComments());
        }
        return optionalFaculty.orElse(null);
    }

    @Override
    public void delete(Long id) {
        facultyRepo.deleteById(id);
    }
}
