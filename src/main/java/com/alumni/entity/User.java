package com.alumni.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   private String email;
    private String password;
    private boolean isActive;
    private String resetToken;
    private int  failedLoginAttempts;
    private LocalDateTime activeAfter;
    private List<Role> roles;
}
