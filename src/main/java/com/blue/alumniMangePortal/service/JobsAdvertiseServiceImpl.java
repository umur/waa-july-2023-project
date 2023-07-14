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
        jobsAdvertiseRepo.save(jobsAdvertise);
        return jobsAdvertise;
    }
    public JobsAdvertise updateJobsAdvertise(long id,JobsAdvertise jobsAdvertise){
        Optional<JobsAdvertise> jobs = jobsAdvertiseRepo.findById(id);
         jobs.get().setPosition(jobsAdvertise.getPosition());
         jobs.get().setDate(jobsAdvertise.getDate());
         jobs.get().setStudent(jobsAdvertise.getStudent());
         jobs.get().setAddress(jobsAdvertise.getAddress());
         jobsAdvertiseRepo.save(jobs.get());
         return jobs.get();

    }

    public boolean  DeleteJobsAdvertiseById(Long id) {
        jobsAdvertiseRepo.deleteById(id);
             return true;
    }
    public void softDeleteItem(Long id) {
//
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
//  public Student filterStudent(Object obj) {
//        if (obj instanceof String) {
//            String var = (String) obj;
//            if (studentRepo.findByState(var) != null) {
//                return studentRepo.findByState(var);
//            } else if (studentRepo.findByCity(var) != null) {
//                return studentRepo.findByCity(var);
//            } else if (studentRepo.findByMajor(var) != null) {
//                return studentRepo.findByMajor(var);
//            } else if (studentRepo.findByName(var) != null) {
//                return studentRepo.findByName(var);
//            }
//        } else if (obj instanceof Long) {
//            Long var = (Long) obj;
//            if (studentRepo.findById(var) != null) {
//                Optional<Student> std = studentRepo.findById(var);
//                return std.get();
//            }
//        }
//        return null;
//    }

}
