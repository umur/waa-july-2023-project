package com.twohundred.alumni.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.twohundred.alumni.entity.User;

@Component
public class SecurityUtil {
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }
}
