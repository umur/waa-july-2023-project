package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class FacultyRegisterRequest {
    private String title;
    private Double salary;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private AddressDto address;
}
