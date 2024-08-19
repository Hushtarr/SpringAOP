package com.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;


@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class.getName());



    @After("@within(org.springframework.stereotype.Component)")
    public void log2(JoinPoint joinPoint) {
        logger.info("let's check which component executed {}", joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.springaop.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("{} method execution start", joinPoint.getSignature().toString());
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : {}", timeElapsed);
        logger.info("{} method execution end", joinPoint.getSignature().toString());
    }

}
