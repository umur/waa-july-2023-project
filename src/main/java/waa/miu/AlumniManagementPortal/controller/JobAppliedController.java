package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.JobsApplied;
import waa.miu.AlumniManagementPortal.service.JobsAppliedService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs-applied")
@CrossOrigin
public class JobAppliedController {

    private final JobsAppliedService jobsAppliedService;

    @GetMapping
    public List<JobsApplied> findAll(){
        return jobsAppliedService.findAll();
    }

    @GetMapping("/{id}")
    public JobsApplied findById(@PathVariable Long id){
        return jobsAppliedService.findById(id);
    }

    @PostMapping
    public JobsApplied create(@RequestBody JobsApplied jobsApplied){
        return jobsAppliedService.create(jobsApplied);
    }

    @PutMapping("/{id}")
    public JobsApplied update(@PathVariable Long id, @RequestBody JobsApplied jobsApplied) {
        return jobsAppliedService.update(id, jobsApplied);
    }

    @PatchMapping("/{id}")
    public JobsApplied partialUpdate(@PathVariable Long id, @RequestBody JobsApplied jobsApplied) {
        return jobsAppliedService.update(id, jobsApplied);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        jobsAppliedService.delete(id);
    }

    @GetMapping("/find-top-10-jobs-by-date-applied")
    public List<JobsApplied> findTop10JobsByDateApplied(){
        return jobsAppliedService.findTop10JobsByDateApplied();
    }
}
