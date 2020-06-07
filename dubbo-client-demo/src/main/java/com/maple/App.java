package com.maple;

import com.maple.dubbo.IPayService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "dubbo.xml"
        });

        IPayService payService = (IPayService) applicationContext.getBean("payService");
        payService.pay(999);

    }
}
