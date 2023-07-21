package com.miu.waa.aluminimanagement.controller;

import com.miu.waa.aluminimanagement.model.dto.AddressDto;
import com.miu.waa.aluminimanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;
    @GetMapping()
    public List<AddressDto> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id){
        return addressService.findById(id);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto company){
        return addressService.save(company);

    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id){
        addressService.deleteById(id);
    }


    @PutMapping("/{id}")
    public AddressDto update(@PathVariable int id, @RequestBody AddressDto AddressDto){
        return addressService.update(id,AddressDto);

    }

}
