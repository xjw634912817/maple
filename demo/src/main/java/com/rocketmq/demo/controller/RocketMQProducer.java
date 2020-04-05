package com.rocketmq.demo.controller;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class RocketMQProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        // 事务消息的时候会用到
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("maple_producer_group");
        // 它会从命名服务器上拿到broker的地址
        defaultMQProducer.setNamesrvAddr("");
        defaultMQProducer.setSendMsgTimeout(30000);
        defaultMQProducer.start();

        for (int i = 0; i < 20; i++) {
            // topic 主题
            // tag 标签 可以用作过滤
            Message message = new Message("maple_topic", "tag_a", ("Hello, RocketMQ : " + i).getBytes());
            SendResult sendResult = defaultMQProducer.send(message);
            System.out.println(sendResult);
        }
    }
}
