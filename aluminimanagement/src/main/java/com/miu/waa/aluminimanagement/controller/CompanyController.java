package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.dto.CompanyDto;
import com.miu.waa.aluminimanagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDto> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable int id){
        return companyService.findById(id);
    }

    @PostMapping
    public CompanyDto save (@RequestBody CompanyDto companyDto){
        return companyService.save(companyDto);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        companyService.deleteById(id);
    }


    @PutMapping("/{id}")
    public CompanyDto update(@PathVariable int id, @RequestBody CompanyDto companyDto){
        return companyService.update(id,companyDto);

    }


}
