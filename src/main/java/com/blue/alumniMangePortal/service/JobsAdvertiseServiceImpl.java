package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.entity.Student;
import com.blue.alumniMangePortal.repository.AddressRepo;
import com.blue.alumniMangePortal.repository.CvRepo;
import com.blue.alumniMangePortal.repository.JobsAdvertiseRepo;
import com.blue.alumniMangePortal.repository.StudentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class JobsAdvertiseServiceImpl implements JobsAdvertiseService {
    private final JobsAdvertiseRepo jobsAdvertiseRepo;
    private final StudentRepo studentRepo;
    private final AddressRepo addressRepo;

    public  List<JobsAdvertise> getAll(){
      return  jobsAdvertiseRepo.findAll();

    }
    public  JobsAdvertise getJobsAdvertiseById(Long id){
        Optional<JobsAdvertise> jobs = jobsAdvertiseRepo.findById(id);
        if(jobs.isPresent()){
            return jobs.get();
        }
        return null;

    }
    public JobsAdvertise saveJobsAdvertise(JobsAdvertise jobsAdvertise){
        addressRepo.save(jobsAdvertise.getAddress());
        JobsAdvertise jobsAdvertise1=new JobsAdvertise();
        jobsAdvertise1.setDate(jobsAdvertise.getDate());
        jobsAdvertise1.setPosition(jobsAdvertise.getPosition());
        jobsAdvertise1.setCompanyName(jobsAdvertise.getCompanyName());
        jobsAdvertise1.setJobAppliedDate(jobsAdvertise.getJobAppliedDate());
        jobsAdvertise1.setTag(jobsAdvertise.getTag());
        jobsAdvertise1.setAddress(jobsAdvertise.getAddress());

        jobsAdvertiseRepo.save(jobsAdvertise1);
        return jobsAdvertise1;
    }
    public JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise){
        Optional<JobsAdvertise> jobs = jobsAdvertiseRepo.findById(id);
        jobs.get().setDate(jobsAdvertise.getDate());
        jobs.get().setPosition(jobsAdvertise.getPosition());
        jobs.get().setJobAppliedDate(jobsAdvertise.getJobAppliedDate());
        jobs.get().setCompanyName(jobsAdvertise.getCompanyName());
        jobs.get().setTag(jobsAdvertise.getTag());

         jobs.get().setAddress(jobsAdvertise.getAddress());
         jobsAdvertiseRepo.save(jobs.get());
         return jobs.get();

    }

    public boolean  DeleteJobsAdvertiseById(Long id) {
        jobsAdvertiseRepo.deleteById(id);
             return true;
    }

    @Override
    public void findByDeletedTrue(Long id){
        Optional<JobsAdvertise>jobsAdvertiseToDelete=jobsAdvertiseRepo.findById(id);
        jobsAdvertiseToDelete.get().setDeleted(true);
        jobsAdvertiseRepo.save(jobsAdvertiseToDelete.get());
    }
    @Override
   public  List<JobsAdvertise> findTop10ByOrderByCreatedAtDesc(){
        return jobsAdvertiseRepo.findFirst10ByOrderByCreatedAtDesc();
   }

   public  List<JobsAdvertise> findTop10ByOrderByAppliedAtDesc(){
         return jobsAdvertiseRepo.findTop10ByOrderByAppliedAtDesc();

   }
    public List<JobsAdvertise> getJobsAdvertisByTag(String tag){
       return jobsAdvertiseRepo.findByTagValue(tag);


    }



}
