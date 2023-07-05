package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.dto.StudentJob;
//import com.blue.alumniMangePortal.entity.JobsAdvertised;
//import com.blue.alumniMangePortal.service.JobAdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JobAdvertController {
//    private final JobAdvertService jobAdvertService;

//    @GetMapping("/last10JobAdverts")
//    public List<JobsAdvertised> getFirstTenJobAdverts(){
//        return null;
//    }
    @GetMapping("last10AppliedJobAdverts")
//    public List<JobsAdvertised> getFirstTenJobAppliedAdverts(){
//        return null;
//    }

    @PutMapping("/editJobAdvertsPosted")
    public JobsAdvertise editJobAdverts(@PathVariable Long id, @RequestBody JobsAdvertise jobsAdvertise) {

        return jobsAdvertService.updateJobsAdvertise(id,jobsAdvertise);
    }

    @PostMapping("/applyForJob")
    public JobsAdvertise addForJob(@RequestBody JobsAdvertise jobsAdvertise) {
        return jobsAdvertService.saveJobsAdvertise(jobsAdvertise);
    }

    //    @GetMapping("/getJobAdvertByTags/{tag}")
//    public String GetJobAdvertsByTags(@PathVariable Tag tag){
//        return null;
//    }
    @GetMapping("/getJobAdvertByState/{state}")
    public String getJobAdvertsByState(@PathVariable String state) {
        return null;
    }
    @GetMapping("/getJobAdvertByCity/{city}")
    public String getJobAdvertsByCity(@PathVariable String city){
        return null;
    }
    @GetMapping("/getJobAdvertByCompanyName/{companyName}")
    public String getJobAdvertsCompanyName(@PathVariable String companyName){
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return null;
    }
//    @GetMapping("getByLoaction/{location}")
//    public String getJobsAdvertisedByLocation(@PathVariable Address location ){
//        return null;
//    }

}
