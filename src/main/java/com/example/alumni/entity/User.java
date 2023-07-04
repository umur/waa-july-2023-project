package com.example.alumni.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();
}
