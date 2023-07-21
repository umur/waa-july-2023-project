package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.Major;
import waa.miu.AlumniManagementPortal.service.MajorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/majors")
@CrossOrigin
public class MajorController {

    private final MajorService majorService;

    @GetMapping
    public List<Major> findAll(){
        return majorService.findAll();
    }

    @GetMapping("/{id}")
    public Major findById(@PathVariable Long id){
        return majorService.findById(id);
    }

    @PostMapping
    public Major create(@RequestBody Major major){
        return majorService.create(major);
    }

    @PutMapping("/{id}")
    public Major update(@PathVariable Long id, @RequestBody Major major) {
        return majorService.update(id, major);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        majorService.delete(id);
    }
}
