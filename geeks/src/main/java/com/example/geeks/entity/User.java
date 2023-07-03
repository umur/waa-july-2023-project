package com.example.geeks.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Setter
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String username;
    private String password;
    private String email;
    private String state;
    private String city;
    private String major;
    private String role;
    private boolean isActive;
    private String cv;
    private boolean isDeleted;

    @OneToMany(mappedBy = "creator")
    private List<JobAd> jobsCreated;

    @ManyToMany(mappedBy = "applicants")
    private List<JobAd> jobsApplied;

    @OneToMany(mappedBy = "user")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "commenter")
    private List<Comment> commentedFrom;

    @OneToMany(mappedBy = "student")
    private List<Comment> commentedOn;


    /////////////////////////////////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // Add constructors, getters, and setters
}

