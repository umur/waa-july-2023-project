package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddresses();
    public Address getAddressById(Long id);
    public Address createAddress(Address address);
    public Address updateAddress(Address address);
    public void deleteAddress(Long id);
}
