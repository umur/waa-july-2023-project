package com.example.geeks.auth;

import com.example.geeks.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private Role role;
    private String image;
    private String state;
    private String city;
    private String major;
}
