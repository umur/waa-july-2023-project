package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/addresses")
    public Address addAddress(Address address){
        addressService.saveAddress(address);
        return address;
    }
    @GetMapping("/addresses")
    public List<Address> getAll(@RequestBody Address address){
        return addressService.getAll();

    }
    @GetMapping("/address/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @PutMapping("address/{id}")
    public Address updateAddress(@PathVariable Long id,@RequestBody Address address){
        return addressService.updateAddress(id,address);
    }
    @DeleteMapping("/{id}")
    public boolean deletById(@PathVariable Long id){
        addressService.deleteById(id);
        return  true;
    }
}
