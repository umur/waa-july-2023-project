package com.twohundred.alumni.entity.dto.request;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String major;
    private Double gpa;
    private UserDto user;
}
