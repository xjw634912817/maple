package com.maple.springboot.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@RestController
@RequestMapping("/mq")
public class RocketMqTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send")
    public Object send() {
        Data data = new Data();
        data.setId(5);
        data.setName("hello mq");
        return rocketMQTemplate.syncSend("test-topic-2", MessageBuilder.withPayload(data).build());
    }

    @RequestMapping("/sendString")
    public Object sendString() {
        return rocketMQTemplate.syncSend("test-topic-2", MessageBuilder.withPayload("hello mq").build());
    }

}
