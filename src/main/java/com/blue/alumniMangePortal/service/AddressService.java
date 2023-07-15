package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAll();
    public Address getAddressById(Long id);
    public Address saveAddress(Address address);
    public Address updateAddress(long id,Address address);
    void findByDeletedTrue(Long id);
}
