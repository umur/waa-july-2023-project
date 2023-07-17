package com.blue.alumniMangePortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Setter
@Getter
//@Builder
@RequiredArgsConstructor
@Entity
public class Faculty extends AlumniUser {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone_number;
    @ManyToOne
    private Department department;
    private String title;
    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Comment> comments;
    @OneToOne(cascade = CascadeType.MERGE)
    private Address address;
    private boolean is_admin;



    @JsonIgnore
    private boolean is_deleted;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.name()));
//    }

//    @Override
//    public String getPassword() {
//        return password;
//    }

//    @Override
//    public String getUsername() {
//        return email;
//    }

//    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    @Override
    public boolean isEnabled() {
        return true;
    }
}
