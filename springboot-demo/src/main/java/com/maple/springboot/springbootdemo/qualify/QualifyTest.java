package com.maple.springboot.springbootdemo.qualify;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifyTest {

    /**
     * Qualifier注解Collection时，会找对应有Qualifier注解的bean来注入
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifyConfiguration.class);
    }

}
