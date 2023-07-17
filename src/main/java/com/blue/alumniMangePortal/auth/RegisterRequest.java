package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Comment;
import com.blue.alumniMangePortal.entity.Department;
import com.blue.alumniMangePortal.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private Role role;
}
