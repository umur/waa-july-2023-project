package com.alumni.dtos.request;

import com.alumni.entity.JobExperience;
import lombok.Data;

import java.util.List;


@Data
public class FacultyRequestDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
