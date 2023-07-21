package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.dto.CVDto;
import com.miu.waa.aluminimanagement.service.CVService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/cvs")
public class CVController {
    private final CVService cvService;
    @GetMapping
    public List<CVDto> getAllCvs(){
        return cvService.findAll();
    }
    @GetMapping("/{id}")
    public CVDto getCV(@PathVariable int id){
        return cvService.findById(id);
    }
    @PostMapping
    public CVDto addCV(@RequestBody CVDto cv){
        return cvService.addCV(cv);
    }
    @PutMapping("/{id}")
    public CVDto updateCV(@PathVariable int id, @RequestBody CVDto cv){
        return cvService.updateCV(id, cv);
    }
    @DeleteMapping("/{id}")
    public void deleteCV(@PathVariable int id){
        cvService.delete(id);
    }
}



