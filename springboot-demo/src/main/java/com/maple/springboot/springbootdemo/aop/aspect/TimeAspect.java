package com.maple.springboot.springbootdemo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(20)
@Aspect
@Component
public class TimeAspect {

//    @Around("LogAspect.pointCutMethod()")
//    public Object around(ProceedingJoinPoint pjp) {
//        long start = System.currentTimeMillis();
//        System.out.println("Time Around advice -- start count");
//        Object result;
//        try {
//            result = pjp.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        } finally {
//            System.out.println("Time Around advice -- end count: " + (System.currentTimeMillis() - start) + " ms");
//        }
//        return result;
//    }

    @Around("LogAspect.pointCutMethod() && @annotation(test)")
    public Object around(ProceedingJoinPoint pjp, NeedAspect test) {
        System.out.println("Annotation Value: " + test.value());
        long start = System.currentTimeMillis();
        System.out.println("Time Around advice -- start count");
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Time Around advice -- end count: " + (System.currentTimeMillis() - start) + " ms");
        }
        return result;
    }

}
