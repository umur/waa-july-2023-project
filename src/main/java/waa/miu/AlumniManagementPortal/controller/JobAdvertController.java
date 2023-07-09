package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.JobAdvert;
import waa.miu.AlumniManagementPortal.service.JobAdvertService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobAdverts")
public class JobAdvertController {

    private final JobAdvertService jobAdvertService;

    @GetMapping
    public List<JobAdvert> findAll(){
        return jobAdvertService.findAll();
    }

    @GetMapping("/{id}")
    public JobAdvert findById(@PathVariable Long id){
        return jobAdvertService.findById(id);
    }

    @PostMapping
    public JobAdvert create(@RequestBody JobAdvert jobAdvert){
        return jobAdvertService.create(jobAdvert);
    }

    @PutMapping("/{id}")
    public JobAdvert update(@PathVariable Long id, @RequestBody JobAdvert jobAdvert) {
        return jobAdvertService.update(id, jobAdvert);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        jobAdvertService.delete(id);
    }

    @GetMapping("/findTop10JobsByDateAdded")
    public List<JobAdvert> findTop10JobsByDateAdded(){
        return jobAdvertService.findTop10JobsByDateAdded();
    }

    @GetMapping("/findTop10JobsByDateApplied")
    public List<JobAdvert> findTop10JobsByDateApplied(){
        return jobAdvertService.findTop10JobsByDateApplied();
    }
}
