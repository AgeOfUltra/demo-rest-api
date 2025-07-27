package com.rest.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(* com.rest.api.controllers.FlightController.*(..))")
//    public void log(){
//        System.out.println("Logging Aspect  called");
//    }

    @Pointcut("execution(* com.rest.api.controllers.FlightController.*(..))")
    public void controllerMethodLogger(){

    }

    @Around("controllerMethodLogger()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logging Aspect  called");
        Object object = joinPoint.proceed();
        System.out.println("Logging Aspect  returned");
        return object;
    }

}
