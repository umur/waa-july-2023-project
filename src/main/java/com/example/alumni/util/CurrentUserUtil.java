package com.example.alumni.util;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@NoArgsConstructor

public class CurrentUserUtil {

    public Optional<Long> getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userId = authentication.getName();
           return Optional.ofNullable(Long.parseLong(userId));
        } else {
           return Optional.ofNullable(null);
        }
    }
}
