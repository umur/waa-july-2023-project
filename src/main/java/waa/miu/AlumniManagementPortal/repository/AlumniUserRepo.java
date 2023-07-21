package waa.miu.AlumniManagementPortal.repository;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.AlumniUser;

import java.util.Optional;

@Repository
public interface AlumniUserRepo extends ListCrudRepository<AlumniUser, Long> {
    Optional<AlumniUser> findByEmail(String email);
}
