package com.example.geeks.aspect;

import com.example.geeks.entity.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class UserActivityLogger {
    @Autowired
    LogService logger;

    @After("execution(* com.example.geeks.services.*.*(..))")
    public void log(JoinPoint joinPoint) {
        var log = new Log();
        log.setTime(LocalDateTime.now());
        log.setDescription(joinPoint.toShortString());
      //  log.(joinPoint.toLongString());
        logger.addLog(log);
    }
}
