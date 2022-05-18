package com.book.cofig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.book.controller.BookController.borrow*(..))")
    public void allMethodCallPointCut() {
    }

    @Pointcut("execution(* com.book.controller.BookController.goHomeLibrary(..))")
    public void allMethodListPointCut() {
    }

    @Before("allMethodListPointCut()")
    public void beforeCallMethodList(JoinPoint joinPoint) {
        System.err.println(" Prepare to run method   : " +
                joinPoint.getSignature().getName() +
                " time : " + LocalDate.now());
    }

    @After("allMethodListPointCut()")
    public void afterCallMethodList(JoinPoint joinPoint) {
        System.err.println(" finished running  : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }


    @Before("allMethodCallPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.err.println(" prepare to run method  : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }

    @AfterReturning("allMethodCallPointCut()")  
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("  finished running   : " +
                joinPoint.getSignature().getName() +
                " time : " + LocalDate.now());
    }


}
