package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.Company;
import com.miu.waa.aluminimanagement.model.dto.AddressDto;
import com.miu.waa.aluminimanagement.model.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> findAll();

    CompanyDto findById(int id);

    CompanyDto save(CompanyDto companyDto);

    void deleteById(int id);

    CompanyDto update(int id, CompanyDto companyDto);
}
