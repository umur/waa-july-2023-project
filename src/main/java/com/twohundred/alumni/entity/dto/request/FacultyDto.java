package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class FacultyDto {
    private Long id;
    private String title;
    private Double salary;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
}
