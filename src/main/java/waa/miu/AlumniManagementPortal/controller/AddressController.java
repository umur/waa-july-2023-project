package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.Address;
import waa.miu.AlumniManagementPortal.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        address.setId(id);
        Address updatedAddress = addressService.updateAddress(address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }







}
