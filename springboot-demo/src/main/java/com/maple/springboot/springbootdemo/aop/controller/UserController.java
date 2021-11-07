package com.maple.springboot.springbootdemo.aop.controller;

import com.maple.springboot.springbootdemo.aop.aspect.NeedAspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如果在类上加上final关键字，则启动项目会报错，无法用cglib生成该bean
 * 如果在方法上加上final关键字，则切面会生效，无法记录日志或者接口耗时，但是http方法还是可以调得通，@RequestMapping注解还是可以生效
 */
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    @GetMapping("/get")
    public String get() {
        System.out.println("UserController: executing get method");
        return "Success executed get method";
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("UserController: executing list method");
        return "Success executed list method";
    }

    @NeedAspect("Value of annotation")
    @GetMapping("/exception")
    public String exception() {
        throw new RuntimeException("throw user exception");
    }

    @GetMapping("/testDefault")
    public String testDefault() {
        return "testDefault";
    }

    @GetMapping("/testPrivate")
    private String testPrivate() {
        return "testPrivate";
    }

}
