package waa.miu.AlumniManagementPortal.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;
import waa.miu.AlumniManagementPortal.repository.JobAdvertRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobAdvertServiceImpl implements JobAdvertService{

    private final JobAdvertRepo jobAdvertRepo;

    @Override
    public List<JobAdvert> findAll() {
        return jobAdvertRepo.findAll();
    }

    @Override
    public JobAdvert findById(Long id) {
        return jobAdvertRepo.findById(id).orElse(null);
    }

    @Override
    public JobAdvert create(JobAdvert jobAdvert) {
        return jobAdvertRepo.save(jobAdvert);
    }

    @Override
    public JobAdvert update(Long id, JobAdvert jobAdvert) {
        Optional<JobAdvert> optionalJobAdvert = jobAdvertRepo.findById(id);
        if (optionalJobAdvert.isPresent()){
            optionalJobAdvert.get().setJobName(jobAdvert.getJobName());
            optionalJobAdvert.get().setExpectedSalary(jobAdvert.getExpectedSalary());
            optionalJobAdvert.get().setJobDescription(jobAdvert.getJobDescription());
            optionalJobAdvert.get().setStudent(jobAdvert.getStudent());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        jobAdvertRepo.deleteById(id);
    }
}
