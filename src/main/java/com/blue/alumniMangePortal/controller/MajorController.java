package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.entity.Major;
import com.blue.alumniMangePortal.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majors")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;
    @PostMapping
    public Major addMajor(Major major){
        return majorService.saveMajor(major);
    }
    @GetMapping
    public List<Major> getAll(){
        return majorService.getAll();

    }
    @GetMapping("/{id}")
    public Major getById(@PathVariable Long id){
        return majorService.getMajorById(id);
    }
    @PutMapping("/{id}")
    public Major updateCv(@PathVariable Long id, @RequestBody Major major){
        return majorService.updateMajor(id,major);
    }
    @DeleteMapping("/{id}")
    public boolean deleteCvById(@PathVariable Long id){
        majorService.DeleteMajorById(id);
        return  true;
    }
}
