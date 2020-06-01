package com.maple.springboot.springbootdemo.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    /**
     * Import注解可用于导入其他类（可导入配置类）
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
