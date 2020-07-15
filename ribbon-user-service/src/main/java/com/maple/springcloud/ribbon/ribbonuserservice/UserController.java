package com.maple.springcloud.ribbon.ribbonuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;


//    @Bean
//    public RestTemplate restTemplate() {
//        // 原生RestTemplate 结合LoadBalancerClient一起用
//        return new RestTemplate();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id") int id) {
        // 调用订单的服务获得订单信息
        // HttpClient   RestTemplate   OkHttp   JDK HttpUrl HttpConnection
        // 原生RestTemplate
//        return restTemplate.getForObject("http://localhost:8080/orders", String.class);

//        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-order-service");
//        String url = String.format("http://%s:%s/orders", serviceInstance.getHost(), serviceInstance.getPort());
        // 原生RestTemplate 结合LoadBalancerClient一起用
//        return restTemplate.getForObject(url, String.class);

        // 加了@LoadBalanced 的 RestTemplate
        return restTemplate.getForObject("http://spring-cloud-order-service/orders", String.class);
    }



}
