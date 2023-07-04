package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;


    public List<Address> getAll(){
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id){
        Optional<Address> add= addressRepo.findById(id);
        if(add.isPresent()) {
            return add.get();
        }
        return null;
    }
    public Address saveAddress(Address address){
        addressRepo.save(address);
        return address;
    }
    public Address updateAddress(long id,Address address){
        Optional<Address> add=addressRepo.findById(id);
        add.get().setCity(address.getCity());
        add.get().setZip(address.getZip());
        add.get().setStreet(address.getState());
        add.get().setState(address.getState());
        addressRepo.save(add.get());
        return add.get();

    }

    public String deleteById(Long id){
        Optional<Address> address= addressRepo.findById(id);
        if(address.isPresent()){
            addressRepo.deleteById(id);
        }
        return"Address deleted";
    }

}