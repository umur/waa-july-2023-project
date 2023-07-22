package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class StudentRegisterRequest {
    private String major;
    private Double gpa;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private AddressDto address;
}
