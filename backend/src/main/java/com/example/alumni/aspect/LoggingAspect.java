package com.example.alumni.aspect;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.alumni.service.impl.*.update(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Executing method: {}. Parameters: {}", methodName, args);

        Object result;
        try {
            result = joinPoint.proceed();
            logger.info("Method {} executed successfully. Result: {}", methodName, result);
        } catch (Exception ex) {
            logger.error("Error executing method {}: {}", methodName, ex.getMessage());
            throw ex;
        }

        return result;
    }
}