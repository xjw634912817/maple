package com.maple.springboot.springbootdemo.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    /**
     * ComponentScan注解会默认扫描当前类所在包路径下带有Component注解的类（包含子包）
     * 当ComponentScan注解配置了某个包路径，就不会默认加载当前类所在的路径
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
