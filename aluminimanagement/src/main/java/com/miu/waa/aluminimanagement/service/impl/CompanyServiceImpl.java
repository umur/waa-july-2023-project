package com.miu.waa.aluminimanagement.service.impl;
import org.modelmapper.ModelMapper;
import com.miu.waa.aluminimanagement.model.Company;
import com.miu.waa.aluminimanagement.model.dto.CompanyDto;
import com.miu.waa.aluminimanagement.repository.CompanyRepo;
import com.miu.waa.aluminimanagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CompanyDto> findAll() {
        var companyList = companyRepo.findAll().stream()
                .filter(c->!c.isDeleted())
                .map(d->modelMapper.map(d,CompanyDto.class))
                .toList();
        return companyList;
    }

    @Override
    public CompanyDto findById(int id) {
        var company = companyRepo.findById(id).filter(c->!c.isDeleted()).orElseThrow(()->new RuntimeException("Company Not Found."));
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        var company = modelMapper.map(companyDto,Company.class);
        companyRepo.save(company);
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public void deleteById(int id) {
        Company company = companyRepo.findById(id).orElseThrow(()->new RuntimeException("Company Not Found."));
        company.setId(id);
        company.setDeleted(true);
        companyRepo.save(company);
    }

    @Override
    public CompanyDto update(int id, CompanyDto companyDto) {
        companyRepo.findById(id).orElseThrow(()->new RuntimeException("Company Not Found."));
        Company company = modelMapper.map(companyDto,Company.class);
        companyRepo.save(company);
        return modelMapper.map(company,CompanyDto.class);
    }
}
