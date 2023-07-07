package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class FacultyDto {
    private Long id;
    private String title;
    private Double salary;
    private UserDto user;
}
