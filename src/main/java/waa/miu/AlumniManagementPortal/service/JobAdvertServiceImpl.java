package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;
import waa.miu.AlumniManagementPortal.repository.JobAdvertRepo;

import java.time.LocalDateTime;
import java.util.List;

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
        return jobAdvertRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Job advert with id "+id+" not found"));
    }

    @Override
    public JobAdvert create(JobAdvert jobAdvert) {
        jobAdvert.setDateAdded(LocalDateTime.now());
        return jobAdvertRepo.save(jobAdvert);
    }

    @Override
    public JobAdvert update(Long id, JobAdvert jobAdvert) {
        JobAdvert existingJobAdvert = findById(id);
        existingJobAdvert.setJobName(jobAdvert.getJobName());
        existingJobAdvert.setExpectedSalary(jobAdvert.getExpectedSalary());
        existingJobAdvert.setJobDescription(jobAdvert.getJobDescription());
        existingJobAdvert.setStudent(jobAdvert.getStudent());
        return jobAdvertRepo.save(existingJobAdvert);
    }

    @Override
    public void delete(Long id) {
        jobAdvertRepo.deleteById(id);
    }

    @Override
    public List<JobAdvert> findTop10JobsByDateAdded(){
        return jobAdvertRepo.findTop10ByOrderByDateAddedDesc();
    }

    @Override
    public List<JobAdvert> findTop10JobsByDateApplied(){
        return jobAdvertRepo.findTop10ByOrderByDateAppliedDesc();
    }
}
