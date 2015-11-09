package lv.test.app.aspect.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * Created by artyom on 15.9.11.
 */

@Aspect
@Service
public class Logger {

    @Pointcut("execution(* lv.test.app.service.OfferService.getCurrent(..))")
    public void log() {
    }


    @Around("log()")
    public Object logGetCurrent(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("getCurrent execution");

        return joinPoint.proceed();
    }
}