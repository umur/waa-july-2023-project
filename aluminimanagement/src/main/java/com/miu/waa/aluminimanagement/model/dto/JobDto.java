package com.miu.waa.aluminimanagement.model.dto;

import com.miu.waa.aluminimanagement.model.Tag;
import lombok.Data;

import java.util.List;

@Data
public class JobDto {
    private int id;
    private String jobTitle;
    private String jobType;
    private String description;
    private AddressDto address;
    private StudentDto student;
    private CompanyDto company;
    private List<Tag> tags;
}
