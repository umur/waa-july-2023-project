package com.twohundred.alumni.entity.dto.response;

import com.twohundred.alumni.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private Long id;
    private String name;
    private List<String> roles;
}
