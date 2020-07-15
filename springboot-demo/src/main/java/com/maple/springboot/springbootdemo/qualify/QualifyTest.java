package com.maple.springboot.springbootdemo.qualify;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifyTest {

    /**
     * Import注解可用于导入其他类（可导入配置类）
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifyConfiguration.class);
    }

}
