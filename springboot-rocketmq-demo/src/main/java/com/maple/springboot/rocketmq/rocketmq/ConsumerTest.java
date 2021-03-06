package com.maple.springboot.rocketmq.rocketmq;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
public class ConsumerTest implements RocketMQListener<Data> {
    @Override
    public void onMessage(Data data) {
        System.out.println("消费者收到消息");
        System.out.println(data);
    }
}
