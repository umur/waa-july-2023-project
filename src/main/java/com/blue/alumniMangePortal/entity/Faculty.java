package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    @JsonIgnore
    private String password;
    private String email;
    private String phone_number;
    @ManyToOne
    private Department department;
    private String title;
    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Comment> comments;
    @OneToOne
    private Address address;
    private boolean is_admin;
    @JsonIgnore
    private boolean is_deleted;
}
