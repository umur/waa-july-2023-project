package com.twohundred.alumni.entity.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String major;
    private Double gpa;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    @JsonIgnore
    private List<CVDto> cvs;
}
