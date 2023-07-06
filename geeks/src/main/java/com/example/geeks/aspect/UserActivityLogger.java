package com.example.geeks.aspect;

import com.example.geeks.entity.Log;
import com.example.geeks.entity.User;
import com.example.geeks.repos.UserRepo;
import com.example.geeks.services.CommentService;
import com.example.geeks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Aspect
@Configuration
@Component
@RequiredArgsConstructor
public class UserActivityLogger {
    @Autowired
    LogService logger;


    private final UserRepo userRepo;


    @After("execution(* com.example.geeks.services.*.*(..))")
    public void log(JoinPoint joinPoint) {
        var log = new Log();
        log.setTime(LocalDateTime.now());
        log.setDescription(joinPoint.toShortString());
        SimpleGrantedAuthority userId = (SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1];
        User userInDB;
        if (userRepo.findById(Long.valueOf(userId.getAuthority())).isPresent()) {
            userInDB = userRepo.findById(Long.valueOf(userId.getAuthority())).get();
        } else {
            userInDB = null;
        }

        log.setUser(userInDB);
        logger.addLog(log);
    }
}
