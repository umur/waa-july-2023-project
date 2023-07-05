package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.repository.CvRepo;
import com.blue.alumniMangePortal.repository.JobsAdvertiseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class JobsAdvertiseServiceImpl implements JobsAdvertiseService {
    private final JobsAdvertiseRepo jobsAdvertiseRepo;

    public  String getAll(){
        jobsAdvertiseRepo.findAll();
        return "return all jobsAdvertiseRepo";
    }
    public String getJobsAdvertiseById(Long id){
        jobsAdvertiseRepo.findById(id);
        return "get jobsAdvertiseRepo by id";
    }
    public JobsAdvertise saveJobsAdvertise(JobsAdvertise jobsAdvertise){
        jobsAdvertiseRepo.save(jobsAdvertise);
        return jobsAdvertise;
    }
    public JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise){
        Optional<JobsAdvertise> jobs = jobsAdvertiseRepo.findById(id);
         jobs.get().setPosition(jobsAdvertise.getPosition());
         jobs.get().setDate(jobsAdvertise.getDate());
         jobs.get().setStudent(jobsAdvertise.getStudent());
         jobsAdvertiseRepo.save(jobs.get());
         return jobs.get();

    }


    public boolean  DeleteJobsAdvertiseById(Long id) {
        jobsAdvertiseRepo.deleteById(id);
             return true;
    }
//    public List<JobsAdvertise> getFirstTenJobAppliedAdverts(){
//        return jobsAdvertiseRepo.getFirstTenJobAppliedAdverts();
//    }


}
