package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isDeleted;
    private boolean currentlyEmployed;
    @OneToOne
    private JobExperience jobExperiences;
    @OneToOne
    private Address address;
//    private Tag tag;
    @OneToOne
    private Major major;
    @OneToMany
    @JsonManagedReference
    private List<JobsAdvertise> jobsAdvertisedList=new ArrayList<>();
//    private CurrentWorkPlace;
//    private Cv cv;
    public void addJobsAdvertisedToStd(JobsAdvertise jobs){
        jobsAdvertisedList.add(jobs);
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
