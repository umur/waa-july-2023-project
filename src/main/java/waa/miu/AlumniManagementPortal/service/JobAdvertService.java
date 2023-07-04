package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.JobAdvert;

import java.util.List;

public interface JobAdvertService {

    List<JobAdvert> findAll();

    JobAdvert findById(Long id);

    JobAdvert create(JobAdvert jobAdvert);

    JobAdvert update(Long id, JobAdvert jobAdvert);

    void delete(Long id);
}
