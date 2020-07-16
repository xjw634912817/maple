package com.maple.springcloud.ribbon.ribbonorderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Value("${server.port}")
    int port;

    @GetMapping("/orders")
    public String orders() {
        System.out.println("收到请求：" + port);
        return "All Orders Return Port " + port;
    }

}
