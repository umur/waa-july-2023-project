package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.Faculty;

import java.util.Optional;

@Repository
public interface FacultyRepo extends ListCrudRepository<Faculty, Long> {
    Optional<Faculty> findByEmail(String email);
}
