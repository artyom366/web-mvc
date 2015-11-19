package lv.test.app.aspect.util;

import lv.test.app.util.IMachine;
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

    //making RRT class implement IMachine interface
    @DeclareParents(value = "lv.test.app.util.RRT", defaultImpl = lv.test.app.util.Machine.class)
    private IMachine iMachine;

    @Pointcut("this(lv.test.app.util.IMachine)")
    public void machineStarting() {
    }

    @Pointcut("execution(* lv.test.app.util.RRT.test(..))")
    public void log() {
    }

    @Pointcut("target (lv.test.app.util.Util)")
    public void logUtil() {
    }

    @Pointcut("this (lv.test.app.util.IUtil)")
    public void logUtilThis() {
    }

    @Around("machineStarting()")
    public Object logMachineStarting(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("logged machine start");
        return joinPoint.proceed();
    }

    @Around("log()")
    public Object logGetCurrent(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("rrt execution");

        return joinPoint.proceed();
    }

    @Around("logUtil() && args(i)")
    public Object logUt(ProceedingJoinPoint joinPoint, int i) throws Throwable {

        System.out.println("util execution " + i);

        return joinPoint.proceed();
    }

    @Around("log()")
    public Object logUtInt(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("inteface execution");

        return joinPoint.proceed();
    }

}
