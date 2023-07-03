package com.twohundred.alumni.service.impl;

import com.twohundred.alumni.entity.Address;
import com.twohundred.alumni.repository.AddressRepo;
import com.twohundred.alumni.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepo addressRepo;

    public void create(Address address) {
        addressRepo.save(address);
    }

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    @Override
    public void update(Address address) {
        addressRepo.save(address);
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepo.findById(id).orElseGet(null);
    }

    @Override
    public void delete(Address address) {
        addressRepo.delete(address);
    }
}
