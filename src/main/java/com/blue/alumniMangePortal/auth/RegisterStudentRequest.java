package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudentRequest {
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private Address address;
    private Role role;
}
