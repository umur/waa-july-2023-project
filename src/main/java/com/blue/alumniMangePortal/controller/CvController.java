package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.CurrentWorkPlace;
import com.blue.alumniMangePortal.entity.Cv;
import com.blue.alumniMangePortal.service.CvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cvs")
@RequiredArgsConstructor
public class CvController {
    private final CvService cvService;
    @PostMapping
    public Cv addCv(Cv cv){
        return cvService.saveCv(cv);
    }
    @GetMapping
    public List<Cv> getAll(){
        return cvService.getAll();

    }
    @GetMapping("/{id}")
    public Cv getById(@PathVariable Long id){
        return cvService.getCvById(id);
    }
    @PutMapping("/{id}")
    public Cv updateCv(@PathVariable Long id, @RequestBody Cv cv){
        return cvService.updateCv(id,cv);
    }
    @DeleteMapping("/{id}")
    public boolean deleteCvById(@PathVariable Long id){
        cvService.deleteCvById(id);
        return  true;
    }
}
