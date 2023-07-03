package com.blue.alumniMangePortal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String phoneNumber;
    private Department department;
    private String title;
    private List<Comment> comments;
    private Address address;

}
