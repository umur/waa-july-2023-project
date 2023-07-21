package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();
    AddressDto findById(int id);
    public AddressDto  save(AddressDto addressDto );
    public void deleteById(int id);

    public AddressDto update(int id,AddressDto addressDto);
}
