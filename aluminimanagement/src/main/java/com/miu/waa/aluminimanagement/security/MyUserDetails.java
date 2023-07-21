package com.miu.waa.aluminimanagement.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.waa.aluminimanagement.model.Person;
import com.miu.waa.aluminimanagement.model.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Getter
public class MyUserDetails implements UserDetails {

    private int userId;
    private String username;
    private String firstname;
    private String lastname;
    @JsonIgnore
    private String  password;
    private List<Role> roles;

    public MyUserDetails(Person person){
        this.userId = person.getId();
        this.username = person.getUsername();
        this.password = person.getPassword();
        this.roles = person.getRoles();
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.roles=person.getRoles();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var result = roles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRole().toUpperCase(Locale.ROOT)))
                .toList();
        return result;
    }

    public int getUserId() {
        return userId;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
