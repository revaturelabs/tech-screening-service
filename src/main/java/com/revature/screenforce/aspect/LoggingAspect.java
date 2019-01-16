package com.revature.screenforce.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("everything()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        Logger log = LogManager.getLogger(pjp.getTarget().getClass());
        log.info("Method with signature: "+pjp.getSignature());
        log.info("With arguments: "+Arrays.toString(pjp.getArgs()));
     
        try {
            obj = pjp.proceed();
        } catch (Exception e) {
            log.error(e.getMessage());
            for(StackTraceElement s : e.getStackTrace()) {
                log.warn(s);
            }
        }
        log.info(pjp.getSignature()+" returned: "+obj);
        return obj;
    }   
    
    @Pointcut("execution(* com.revature.screenforce..*(..))")
	public void everything() { /* Empty method for Aspect Pointcut */ }
}
