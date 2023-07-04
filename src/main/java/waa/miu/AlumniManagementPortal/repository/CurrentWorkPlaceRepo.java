package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.CurrentWorkPlace;

@Repository
public interface CurrentWorkPlaceRepo extends ListCrudRepository<CurrentWorkPlace, Long> {
}
