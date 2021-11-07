package com.maple.springboot.springbootdemo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order 值越高，离实际目标类越近，即先执行Order小的Aspect，再执行Order值大的Aspect
 *
 * Advice执行顺序:
 *   Around-Before
 *   Before
 *   Around-After
 *   After
 *   AfterReturning or After throwing
 */
@Order(2)
@Aspect
@Component
public class LogAspect {

    /**
     * 参考链接: https://blog.csdn.net/lmb55/article/details/82470388/
     * 1.execution:   用于匹配子表达式
     * 2.within:      用于匹配连接点所在的java类或包
     * 3.this:        用于向通知方法中传入代理对象的引用
     * 4.target:      用于向通知方法中传入目标对象的引用
     * 5.args:        用于向通知方法中传入参数
     * 6.@within:     用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配
     * 7.@target:     与@within类似，不过注解的Retention必须为RetentionPolicy.RUNTIME
     * 8.@args:       参数必须被指定的注解所标注
     * 9.@annotation: 所有被注解标注的方法将被匹配
     * 10.bean:       通过spring bean name匹配，spring 2.5新增
     *
     * execution表达式解释:
     * 第一个 * 符号	  表示返回值的类型任意
     * com.maple.springboot.springbootdemo.aop	表示AOP所切的服务的包名，即需要进行横切的业务类
     * 包名后面的 ..	  表示当前包及子包
     * 第二个 *	      表示类名
     * .*(..)	      表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
//    @Pointcut("bean(userController)")
    @Pointcut("execution(public * com.maple.springboot.springbootdemo.aop..*.*(..))")
    public static void pointCutMethod() {
    }

    @Around("pointCutMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around advice -- before execute:");
        Object result = pjp.proceed();
        System.out.println("Around advice -- result after executed : " + result);
        return result;
    }

    @Before("pointCutMethod()")
    public void before() {
        System.out.println("Before advice --");
    }

    @After("pointCutMethod()")
    public void after() {
        System.out.println("After advice --");
    }

    @AfterReturning("pointCutMethod()")
    public void afterReturning() {
        System.out.println("AfterReturning advice --");
    }

    @AfterThrowing("pointCutMethod()")
    public void afterThrowing() {
        System.out.println("AfterThrowing advice --");
    }
}
