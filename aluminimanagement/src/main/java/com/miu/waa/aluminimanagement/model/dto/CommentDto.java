package com.miu.waa.aluminimanagement.model.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int id;
    private String comment;
    private StudentDto student;
    private FacultyDto faculty;
}
