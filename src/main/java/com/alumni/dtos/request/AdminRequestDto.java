package com.alumni.dtos.request;

import com.alumni.entity.JobExperience;
import lombok.Data;

import java.util.List;


@Data
public class AdminRequestDto {
    private long id;
    private String name;
    private String email;
    private String password;


}
