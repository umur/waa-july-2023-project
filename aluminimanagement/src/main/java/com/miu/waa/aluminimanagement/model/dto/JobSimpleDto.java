package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class JobSimpleDto {
    private int id;
    private String jobTitle;
    private String jobType;
    private String companyName;
    private AddressDto address;
}
