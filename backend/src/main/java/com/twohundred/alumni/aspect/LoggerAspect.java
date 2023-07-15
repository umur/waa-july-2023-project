package com.twohundred.alumni.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Pointcut("@annotation(com.twohundred.alumni.aspect.annotation.LogMe)")
    public void a(){}

    @After("a()")
    public void log(JoinPoint joinPoint){
        log.info("User action="+ joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        Arrays.asList(args).forEach((arg) ->
                log.info("Data processed="+ arg.toString()));
    }
}
