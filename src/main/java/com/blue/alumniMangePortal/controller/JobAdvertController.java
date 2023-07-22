package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.dto.StudentJob;
//import com.blue.alumniMangePortal.entity.JobsAdvertised;
//import com.blue.alumniMangePortal.service.JobAdvertService;
import com.blue.alumniMangePortal.entity.JobsAdvertise;
import com.blue.alumniMangePortal.service.JobsAdvertiseService;
import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class JobAdvertController {
   private final JobsAdvertiseService jobsAdvertService;

    @GetMapping("/jobAdverts")
    public List<JobsAdvertise> getAllJobsAdvertise(){
        return jobsAdvertService.getAll();
    }
    @GetMapping("/jobsAdverts/{id}")
    public JobsAdvertise getJobsAdvertiseById(@PathVariable Long id){
     return jobsAdvertService.getJobsAdvertiseById(id);
    }

    @PutMapping("/editJobsAdverts")
    public JobsAdvertise editJobAdverts(@PathVariable Long id, @RequestBody JobsAdvertise jobsAdvertise)
    {

        return jobsAdvertService.updateJobsAdvertise(id,jobsAdvertise);
    }

    @PostMapping("/JobsAdverts")
    public JobsAdvertise addForJob(@RequestBody JobsAdvertise jobsAdvertise) {
        return jobsAdvertService.saveJobsAdvertise(jobsAdvertise);
    }

    @DeleteMapping("/deleteJobsAdverts/{id}")
    public void deleteStudent(@PathVariable Long id) {
        jobsAdvertService.findByDeletedTrue(id);
    }
      @GetMapping("/getTop10")
      public List<JobsAdvertise> findTop10ByOrderByCreatedAtDesc (){
        return jobsAdvertService.findTop10ByOrderByCreatedAtDesc();
      }
      @GetMapping("/getTop10Applied")
      public  List<JobsAdvertise> findTop10ByOrderByAppliedAtDesc(){
        return jobsAdvertService.findTop10ByOrderByAppliedAtDesc();
      }
      @GetMapping("/getByTag/{tag}")
    public List<JobsAdvertise> getJobsAdvertisByTag(@PathVariable String tag){
        return jobsAdvertService.getJobsAdvertisByTag(tag);
      }

}
