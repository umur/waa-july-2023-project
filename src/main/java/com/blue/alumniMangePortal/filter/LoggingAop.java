package com.blue.alumniMangePortal.filter;
//import ch.qos.logback.classic.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAop {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAop.class);

    @Around("execution(* com.blue.alumniMangePortal.controller.*.*(..))")
    public Object interceptAllMethods(ProceedingJoinPoint pjp) throws Throwable{
        String methodName = pjp.getSignature().getName();
        logger.info("Entering method: {}", methodName);
        System.out.println("testing in aspect");
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Exception ex) {
            logger.error("Exception in method: {}", methodName, ex);
            throw ex;
        }

        logger.info("Exiting method: {}", methodName);
        return result;
    }
}




