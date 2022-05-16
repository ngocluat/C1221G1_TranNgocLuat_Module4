package com.book.cofig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {


    @Pointcut("execution(* com.book.controller.BookController.borrow*(..))")
    public void allMethodCallPointCut() {
    }


    @Before("allMethodCallPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.err.println(" chuẩn bị chạy : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }

    @AfterReturning("allMethodCallPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("  chạy xong  : " +
                joinPoint.getSignature().getName() +
                "time : " + LocalDate.now());
    }
}
