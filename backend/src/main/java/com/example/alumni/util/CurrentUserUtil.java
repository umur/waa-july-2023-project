package com.example.alumni.util;

import com.example.alumni.repository.UserRepository;
import com.example.alumni.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor

public class CurrentUserUtil {

    private final UserRepository userRepository;

    public Optional<Long> getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userId = authentication.getName();
            return Optional.ofNullable(Long.parseLong(userId));
        } else {
            return Optional.ofNullable(null);
        }
    }

    public Optional<User> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            return userRepository.findByEmail(email);
        } else {
            return Optional.ofNullable(null);
        }
    }
}
