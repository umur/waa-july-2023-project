package com.miu.waa.aluminimanagement.model.dto;

import com.miu.waa.aluminimanagement.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class RegisterDto {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String major;
    private int graduatedYear;
    private String majorSubject;
    private int universityId;
    private int gpa;
    private Role role;
    private List<Role> roles;
}
