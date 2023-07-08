package com.blue.alumniMangePortal.auth;

import com.blue.alumniMangePortal.entity.Address;
import com.blue.alumniMangePortal.entity.Comment;
import com.blue.alumniMangePortal.entity.Department;
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
    private String email;
    private String password;
    private String phone_number;
    private Department department;
    private String title;
    private List<Comment> comments;
    private Address address;
    private boolean is_admin;
    private boolean is_deleted;
}
