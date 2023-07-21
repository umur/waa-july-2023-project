package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.JobExperience;
import com.miu.waa.aluminimanagement.model.dto.JobExperienceDto;
import com.miu.waa.aluminimanagement.service.JobExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("job-experiences")
@RequiredArgsConstructor
public class JobExperienceController {

    private  final JobExperienceService jobExperienceService;

    @GetMapping
    public List<JobExperienceDto> findAll(){
        return jobExperienceService.findAll();
    }

    @GetMapping("/{id}")
    public JobExperienceDto findById(@PathVariable int id){
        return jobExperienceService.findById(id);
    }

    @PostMapping()
    public JobExperienceDto save (@RequestBody JobExperience jobExperience){
        return jobExperienceService.save(jobExperience);
    }

    @PutMapping ("/{id}")
    public JobExperienceDto update(@PathVariable int id, @RequestBody JobExperienceDto jobExperienceDto){
        return jobExperienceService.update(id,jobExperienceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteJobExperience(@PathVariable int id) {
        jobExperienceService.delete(id);
    }

    @GetMapping("/getExperiences/{userId}")
    public List<JobExperienceDto> getJobExperiencesByStudentId(@PathVariable int userId ){
        return jobExperienceService.findByStudentId(userId);
    }

}
