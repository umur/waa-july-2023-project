package com.twohundred.alumni.service;

import com.twohundred.alumni.entity.Address;

import java.util.List;

public interface AddressService {
    void create(Address address);

    List<Address> findAll();

    void update(Address address);

    Address getAddress(Long id);

    void delete(Address address);
}
