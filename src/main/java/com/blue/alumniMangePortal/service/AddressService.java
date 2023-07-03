package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Address;

public interface AddressService {
    public String getAll();
    public String getAddressById(Long id);
    public Address saveAddress(Address address);
    public Address updateAddress(long id,Address address);
    public String DeleteById(Long id);
}
