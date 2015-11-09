package lv.test.app.aspect.controller;

import lv.test.app.controller.OfferController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by artyom on 15.9.11.
 */

@Aspect
@Service
public class Logger {

    @Pointcut("execution(* lv.test.app.controller.OfferController.showOffers(..))")
    public void log() {}



    @Around("log()")
    public Object logShowOffers(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("showOffers execution");

        return joinPoint.proceed();
    }



}
