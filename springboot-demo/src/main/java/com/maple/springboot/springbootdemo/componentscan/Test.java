package com.maple.springboot.springbootdemo.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    /**
     * ComponentScan注解会默认扫描当前类所在包路径下带有Component注解的类（包含子包）
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

}
