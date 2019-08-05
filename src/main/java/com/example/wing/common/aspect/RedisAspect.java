package com.example.wing.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Around("execution(* com.example.wing.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.err.println("***************");
        Object result = null;

        try {
            System.err.println("################");
            result = proceedingJoinPoint.proceed();
            logger.error(result.toString());
        } catch (Exception e) {
            logger.error("redis error", e);
            throw new Exception("Redis server exception");
        }
        return result;
    }
}
