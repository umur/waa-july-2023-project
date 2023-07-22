package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class StudentWithoutCVDto {
    private Long id;
    private String major;
    private Double gpa;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
}
