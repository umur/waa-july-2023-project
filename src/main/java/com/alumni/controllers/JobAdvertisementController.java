package com.alumni.controllers;


import com.alumni.Service.JobAdvertisementService;
import com.alumni.Service.JobApplicationService;
import com.alumni.Service.JwtService;
import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.entity.Comment;
import com.alumni.entity.JobAdvertisement;
import com.alumni.entity.JobApplication;
import com.alumni.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-advertisements")
@AllArgsConstructor
@CrossOrigin
public class JobAdvertisementController {
    private final JobAdvertisementService service;
    private final JobApplicationService jobApplicationService;




    @GetMapping
    public List<JobAdvertisementResponseDto> getList(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) List<Long> tags,
            @RequestParam(required = false,defaultValue = "") String  city,
            @RequestParam(required = false,defaultValue = "") String  state
            ){
        return service.getList(page,size,tags,state, city);

    }


    @PostMapping
    public void createOne(
            @RequestBody JobAdvertisementRequestDto requestDto){
        service.create(requestDto);
    }

    @GetMapping("/{id}")
    public JobAdvertisementResponseDto findById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
         service.deleteById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody JobAdvertisementRequestDto requestDto){
        service.put(id,requestDto);
    }



    @GetMapping("/{id}/applications")
    public List<JobApplication> getJobApplications(@PathVariable(name = "id") Long id){
        return jobApplicationService.getByJob(id);
    }

    @PostMapping("/{id}/applications")
    public void addJobApplication(@PathVariable(name = "id") Long id, HttpServletRequest request){


         jobApplicationService.createFromJob(id,request);
    }





}
