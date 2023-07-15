package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;

import java.util.List;

@Repository
public interface JobAdvertRepo extends ListCrudRepository<JobAdvert, Long> {

    List<JobAdvert> findTop10ByOrderByDateAddedDesc();
    List<JobAdvert> findTop10ByOrderByDateAppliedDesc();
}
