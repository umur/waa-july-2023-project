package com.miu.waa.aluminimanagement.service.impl;
import com.miu.waa.aluminimanagement.model.Address;
import org.modelmapper.ModelMapper;
import com.miu.waa.aluminimanagement.model.dto.AddressDto;
import com.miu.waa.aluminimanagement.repository.AddressRepo;
import com.miu.waa.aluminimanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDto> findAll() {
        var addressList = addressRepo.findAll().stream().
                filter(c->!c.isDeleted())
                .map(p -> modelMapper.map(p, AddressDto.class))
                .toList();
        return addressList;
    }

    @Override
    public AddressDto findById(int id) {
        var address=addressRepo.findById(id).filter(c->!c.isDeleted()).orElseThrow(()->new RuntimeException("Address not found"));;
        return modelMapper.map(address,AddressDto.class);
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address=modelMapper.map(addressDto,Address.class);
        addressRepo.save(address);
        return modelMapper.map(address,AddressDto.class);
    }

    @Override
    public void deleteById(int id) {
        Address address = addressRepo.findById(id).orElseThrow(()->new RuntimeException("Address not found"));
        address.setId(id);
        address.setDeleted(true);
        addressRepo.save(address);

    }

    @Override
    public AddressDto update(int id, AddressDto addressDto) {
        addressRepo.findById(id).orElseThrow(()->new RuntimeException("Address not found"));
        Address address=modelMapper.map(addressDto,Address.class);
        address.setId(id);
        addressRepo.save(address);
        return modelMapper.map(address,AddressDto.class);
    }
}
