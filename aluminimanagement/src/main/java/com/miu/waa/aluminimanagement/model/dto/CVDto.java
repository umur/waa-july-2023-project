package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class CVDto {
    private int id;
    private StudentDto student;
    private String cvData;
    private boolean isDeleted = false;
}
