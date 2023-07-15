package com.blue.alumniMangePortal.service.impl;

import com.blue.alumniMangePortal.entity.Faculty;
import com.blue.alumniMangePortal.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class FacultyUserDetails implements UserDetails {

    private String email;
    private String password;
    private Role role;

    public FacultyUserDetails(Faculty faculty) {
        this.email = faculty.getEmail();
        this.password = faculty.getPassword();
        this.role = faculty.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
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
