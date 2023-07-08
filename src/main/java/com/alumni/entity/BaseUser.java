package com.alumni.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   private String email;
    private String password;
    private boolean isActive;
    private String resetToken;
    private int  failedLoginAttempts;
    private LocalDateTime activeAfter;

    @Enumerated(EnumType.STRING)
    private List<Role> roles;
}
