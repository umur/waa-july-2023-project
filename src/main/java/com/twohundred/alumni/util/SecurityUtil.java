package com.twohundred.alumni.util;

import com.twohundred.alumni.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.twohundred.alumni.entity.User;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    private final UserRepo repository;

    public String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
    }

    public User getCurrentUser() {
           return repository.findByEmail(getCurrentUserName())
                   .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
