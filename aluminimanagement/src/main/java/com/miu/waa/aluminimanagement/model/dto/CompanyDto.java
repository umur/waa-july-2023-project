package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private int id;
    private String name;
    private AddressDto address;
}
