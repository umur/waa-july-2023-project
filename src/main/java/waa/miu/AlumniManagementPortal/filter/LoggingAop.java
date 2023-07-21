package waa.miu.AlumniManagementPortal.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAop {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAop.class);
    @Around("execution(* com.blue.alumniMangePortal.controller.*.*(..))")
    public Object interceptAllMethods(ProceedingJoinPoint pjp) throws Throwable{
        String methodName = pjp.getSignature().getName();
        logger.info("Entering method: {}", methodName);

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
