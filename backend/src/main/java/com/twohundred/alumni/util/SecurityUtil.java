package com.twohundred.alumni.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.twohundred.alumni.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    public Long getCurrentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getId();
    }

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }
}
