package lv.test.app.aspect.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.persistence.JoinTable;

/**
 * Created by artyom on 15.9.11.
 */

@Component
@Aspect
public class UtilLogger {

    @Pointcut("execution(* lv.test.app.util.RRT.test(..))")
    public void log() {
    }

    @Pointcut("target (lv.test.app.util.Util)")
    public void logUtil() {
    }

    @Pointcut("this (lv.test.app.util.IUtil)")
    public void logUtilThis() {
    }

    @Around("log()")
    public Object logGetCurrent(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("rrt execution");

        return joinPoint.proceed();
    }

    @Around("log()")
    public Object logUt(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("util execution");

        return joinPoint.proceed();
    }

    @Around("log()")
    public Object logUtInt(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("inteface execution");

        return joinPoint.proceed();
    }

}
