package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.Address;
import com.miu.waa.aluminimanagement.model.Person;
import com.miu.waa.aluminimanagement.model.dto.PersonDto;
import com.miu.waa.aluminimanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable int id){
        return personService.getById(id);
    }

    @PostMapping("/send-password-reset-email/{id}/{recipient}")
    public String sendPasswordResetEmail(@PathVariable int id,@PathVariable String recipient){
        return personService.sendPasswordResetEmail(id,recipient);
    }

    @PutMapping("/{id}/update-address")
    public void updateAddress(@PathVariable int id, @RequestBody Address address){
        personService.updateAddress(id,address);
    }

    @PutMapping("/change-status/{id}/active/{status}")
    public void changeStatus(@PathVariable int id, @PathVariable Boolean status){
        personService.changeStatus(id,status);
    }

    @GetMapping("/profile")
    public PersonDto findById(){
        var x = personService.findById();
        return x;

    }

}
